/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;

public class PdfTextExtractionTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Test
    public void testExtractText() throws Exception {
        final String expectedText = "Test string";
        PDDocument document = PDFUtil.textToPDF(expectedText);

        template.sendBody("direct:start", document);

        resultEndpoint.setExpectedMessageCount(1);
        resultEndpoint.expectedMessagesMatches(new Predicate() {
            @Override
            public boolean matches(Exchange exchange) {
                Object body = exchange.getIn().getBody();
                assertThat(body, instanceOf(String.class));
                assertThat((String) body, containsString(expectedText));
                return true;
            }
        });
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testExtractTextFromEncrypted() throws Exception {
        final String ownerPass = "ownerPass";
        final String userPass = "userPass";
        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setCanExtractContent(false);
        StandardProtectionPolicy protectionPolicy = new StandardProtectionPolicy(ownerPass, userPass, accessPermission);
        protectionPolicy.setEncryptionKeyLength(128);

        final String expectedText = "Test string";
        PDDocument document = PDFUtil.textToPDF(expectedText);

        document.protect(protectionPolicy);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        document.save(output);

        // Encryption happens after saving.
        PDDocument encryptedDocument
                = Loader.loadPDF(new RandomAccessReadBuffer(new ByteArrayInputStream(output.toByteArray())), userPass);

        template.sendBodyAndHeader("direct:start",
                encryptedDocument,
                PdfHeaderConstants.DECRYPTION_MATERIAL_HEADER_NAME,
                new StandardDecryptionMaterial(userPass));

        resultEndpoint.setExpectedMessageCount(1);
        resultEndpoint.expectedMessagesMatches(new Predicate() {
            @Override
            public boolean matches(Exchange exchange) {
                Object body = exchange.getIn().getBody();
                assertThat(body, instanceOf(String.class));
                assertThat((String) body, containsString(expectedText));
                return true;
            }
        });
        resultEndpoint.assertIsSatisfied();
        document.isEncrypted();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start")
                        .to("pdf:extractText")
                        .to("mock:result");
            }
        };
    }
}
