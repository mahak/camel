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
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.processing.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * Interact with Asterisk PBX Server (VoIP).
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface AsteriskEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Asterisk component.
     */
    public interface AsteriskEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedAsteriskEndpointConsumerBuilder advanced() {
            return (AdvancedAsteriskEndpointConsumerBuilder) this;
        }
        /**
         * The hostname of the asterisk server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param hostname the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointConsumerBuilder hostname(String hostname) {
            doSetProperty("hostname", hostname);
            return this;
        }
        /**
         * Login password.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointConsumerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Login username.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointConsumerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Asterisk component.
     */
    public interface AdvancedAsteriskEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AsteriskEndpointConsumerBuilder basic() {
            return (AsteriskEndpointConsumerBuilder) this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions occurred while the consumer is trying to
         * pickup incoming messages, or the likes, will now be processed as a
         * message and handled by the routing Error Handler. By default the
         * consumer will use the org.apache.camel.spi.ExceptionHandler to deal
         * with exceptions, that will be logged at WARN or ERROR level and
         * ignored.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder exceptionHandler(
                org.apache.camel.spi.ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder exchangePattern(
                org.apache.camel.ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Asterisk component.
     */
    public interface AsteriskEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedAsteriskEndpointProducerBuilder advanced() {
            return (AdvancedAsteriskEndpointProducerBuilder) this;
        }
        /**
         * The hostname of the asterisk server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param hostname the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointProducerBuilder hostname(String hostname) {
            doSetProperty("hostname", hostname);
            return this;
        }
        /**
         * Login password.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointProducerBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Login username.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointProducerBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
        /**
         * What action to perform such as getting queue status, sip peers or
         * extension state.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.asterisk.AsteriskAction&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param action the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointProducerBuilder action(
                org.apache.camel.component.asterisk.AsteriskAction action) {
            doSetProperty("action", action);
            return this;
        }
        /**
         * What action to perform such as getting queue status, sip peers or
         * extension state.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.asterisk.AsteriskAction&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param action the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointProducerBuilder action(String action) {
            doSetProperty("action", action);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Asterisk component.
     */
    public interface AdvancedAsteriskEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AsteriskEndpointProducerBuilder basic() {
            return (AsteriskEndpointProducerBuilder) this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedAsteriskEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Asterisk component.
     */
    public interface AsteriskEndpointBuilder
            extends
                AsteriskEndpointConsumerBuilder,
                AsteriskEndpointProducerBuilder {
        default AdvancedAsteriskEndpointBuilder advanced() {
            return (AdvancedAsteriskEndpointBuilder) this;
        }
        /**
         * The hostname of the asterisk server.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param hostname the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointBuilder hostname(String hostname) {
            doSetProperty("hostname", hostname);
            return this;
        }
        /**
         * Login password.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param password the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointBuilder password(String password) {
            doSetProperty("password", password);
            return this;
        }
        /**
         * Login username.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Required: true
         * Group: common
         * 
         * @param username the value to set
         * @return the dsl builder
         */
        default AsteriskEndpointBuilder username(String username) {
            doSetProperty("username", username);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Asterisk component.
     */
    public interface AdvancedAsteriskEndpointBuilder
            extends
                AdvancedAsteriskEndpointConsumerBuilder,
                AdvancedAsteriskEndpointProducerBuilder {
        default AsteriskEndpointBuilder basic() {
            return (AsteriskEndpointBuilder) this;
        }
    }

    public interface AsteriskBuilders {
        /**
         * Asterisk (camel-asterisk)
         * Interact with Asterisk PBX Server (VoIP).
         * 
         * Category: mobile
         * Since: 2.18
         * Maven coordinates: org.apache.camel:camel-asterisk
         * 
         * @return the dsl builder for the headers' name.
         */
        default AsteriskHeaderNameBuilder asterisk() {
            return AsteriskHeaderNameBuilder.INSTANCE;
        }
        /**
         * Asterisk (camel-asterisk)
         * Interact with Asterisk PBX Server (VoIP).
         * 
         * Category: mobile
         * Since: 2.18
         * Maven coordinates: org.apache.camel:camel-asterisk
         * 
         * Syntax: <code>asterisk:name</code>
         * 
         * Path parameter: name (required)
         * Name of component
         * 
         * @param path name
         * @return the dsl builder
         */
        default AsteriskEndpointBuilder asterisk(String path) {
            return AsteriskEndpointBuilderFactory.endpointBuilder("asterisk", path);
        }
        /**
         * Asterisk (camel-asterisk)
         * Interact with Asterisk PBX Server (VoIP).
         * 
         * Category: mobile
         * Since: 2.18
         * Maven coordinates: org.apache.camel:camel-asterisk
         * 
         * Syntax: <code>asterisk:name</code>
         * 
         * Path parameter: name (required)
         * Name of component
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path name
         * @return the dsl builder
         */
        default AsteriskEndpointBuilder asterisk(
                String componentName,
                String path) {
            return AsteriskEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }

    /**
     * The builder of headers' name for the Asterisk component.
     */
    public static class AsteriskHeaderNameBuilder {
        /**
         * The internal instance of the builder used to access to all the
         * methods representing the name of headers.
         */
        private static final AsteriskHeaderNameBuilder INSTANCE = new AsteriskHeaderNameBuilder();

        /**
         * The name of the Asterisk event.
         * 
         * The option is a: {@code java.lang.String} type.
         * 
         * Default: Simple name of the event
         * Group: consumer
         * 
         * @return the name of the header {@code AsteriskEventName}.
         */
        public String asteriskEventName() {
            return "AsteriskEventName";
        }

        /**
         * The extension to query in case of an ExtensionStateAction.
         * 
         * The option is a: {@code java.lang.String} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code AsteriskExtension}.
         */
        public String asteriskExtension() {
            return "AsteriskExtension";
        }

        /**
         * The name of the context that contains the extension to query in case
         * of an ExtensionStateAction.
         * 
         * The option is a: {@code java.lang.String} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code AsteriskContext}.
         */
        public String asteriskContext() {
            return "AsteriskContext";
        }

        /**
         * The Asterisk action to do.
         * 
         * The option is a: {@code
         * org.apache.camel.component.asterisk.AsteriskAction} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code AsteriskAction}.
         */
        public String asteriskAction() {
            return "AsteriskAction";
        }
    }
    static AsteriskEndpointBuilder endpointBuilder(
            String componentName,
            String path) {
        class AsteriskEndpointBuilderImpl extends AbstractEndpointBuilder implements AsteriskEndpointBuilder, AdvancedAsteriskEndpointBuilder {
            public AsteriskEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new AsteriskEndpointBuilderImpl(path);
    }
}