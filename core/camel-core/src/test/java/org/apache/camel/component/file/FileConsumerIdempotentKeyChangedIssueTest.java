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
package org.apache.camel.component.file;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;

public class FileConsumerIdempotentKeyChangedIssueTest extends ContextTestSupport {
    private static final String TEST_FILE_NAME = "hello" + UUID.randomUUID() + ".txt";

    private Endpoint endpoint;

    @Test
    public void testFile() throws Exception {
        getMockEndpoint("mock:file").expectedBodiesReceived("Hello World");

        template.sendBodyAndHeader(endpoint, "Hello World", Exchange.FILE_NAME, TEST_FILE_NAME);

        context.getRouteController().startAllRoutes();

        assertMockEndpointsSatisfied();
        oneExchangeDone.matches(5, TimeUnit.SECONDS);

        resetMocks();
        getMockEndpoint("mock:file").expectedBodiesReceived("Hello World Again");

        template.sendBodyAndHeader(endpoint, "Hello World Again", Exchange.FILE_NAME, TEST_FILE_NAME);

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                endpoint = endpoint(
                        fileUri("?noop=true&readLock=changed&initialDelay=0&delay=10&readLockCheckInterval=100"
                                + "&idempotentKey=${file:onlyname}-${file:size}-${date:file:yyyyMMddHHmmss}"));

                from(endpoint).autoStartup(false).convertBodyTo(String.class).to("log:file").to("mock:file");
            }
        };
    }
}
