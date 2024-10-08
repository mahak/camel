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
package org.apache.camel.issues;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplitterParallelRuntimeExceptionInHasNextOrNextTest extends ContextTestSupport {

    /**
     * Tests that only one aggregator thread is created if a RuntimeException in the hasNext method of a custom iterator
     * occurs.
     */
    @Test
    public void testSplitErrorInHasNext() throws Exception {
        execute("direct:errorInHasNext");
    }

    /**
     * Tests that only one aggregator thread is created if a RuntimeException in the next method of a custom iterator
     * occurs.
     */
    @Test
    public void testSplitErrorInNext() throws Exception {
        execute("direct:errorInNext");
    }

    private void execute(String from) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            Exception e = assertThrows(Exception.class, () -> template.sendBody(from, "some content"),
                    "expected due to runtime exception in hasNext method");

            assertTrue(e.getMessage().startsWith("Exception occurred"));

            assertMockEndpointsSatisfied();
        }
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:errorInHasNext").split().method(SplitterImpl.class, "errorInHasNext").streaming()
                        .parallelProcessing(true).to("mock:split1");

                from("direct:errorInNext").split().method(SplitterImpl.class, "errorInNext").streaming()
                        .parallelProcessing(true).to("mock:split2");
            }
        };
    }

    public static class SplitterImpl {

        public Iterator<String> errorInHasNext(InputStream request, Exchange exchange) {

            return new CustomIterator(exchange, request, true);
        }

        public Iterator<String> errorInNext(InputStream request, Exchange exchange) {

            return new CustomIterator(exchange, request, false);
        }

    }

    static class CustomIterator implements Iterator<String>, Closeable {

        private int index;
        private final InputStream request;
        private final boolean errorInHasNext;

        CustomIterator(Exchange exchange, InputStream request, boolean errorInHasNext) {
            this.request = request;
            this.errorInHasNext = errorInHasNext;

        }

        @Override
        public boolean hasNext() {
            if (index < 7) {
                return true;
            }
            if (errorInHasNext) {
                throw new RuntimeException("Exception thrown");
            } else {
                return false;
            }
        }

        @Override
        public String next() {
            index++;

            if (index < 7) {
                return "<a>" + index + "</a>";
            }
            if (!errorInHasNext) {
                throw new RuntimeException("Exception thrown");
            } else {
                return "<a>" + index + "</a>";
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void close() throws IOException {
            request.close();
        }
    }

}
