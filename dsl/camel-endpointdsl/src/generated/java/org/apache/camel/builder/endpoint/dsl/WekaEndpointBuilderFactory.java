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
 * Perform machine learning tasks using Weka.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface WekaEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Weka component.
     */
    public interface WekaEndpointBuilder extends EndpointProducerBuilder {
        default AdvancedWekaEndpointBuilder advanced() {
            return (AdvancedWekaEndpointBuilder) this;
        }
        /**
         * The filter spec (i.e. Name Options).
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: filter
         * 
         * @param apply the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder apply(String apply) {
            doSetProperty("apply", apply);
            return this;
        }
        /**
         * The classifier spec (i.e. Name Options).
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: model
         * 
         * @param build the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder build(String build) {
            doSetProperty("build", build);
            return this;
        }
        /**
         * The named dataset to train the classifier with.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: model
         * 
         * @param dsname the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder dsname(String dsname) {
            doSetProperty("dsname", dsname);
            return this;
        }
        /**
         * Number of folds to use for cross-validation.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 10
         * Group: model
         * 
         * @param folds the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder folds(int folds) {
            doSetProperty("folds", folds);
            return this;
        }
        /**
         * Number of folds to use for cross-validation.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 10
         * Group: model
         * 
         * @param folds the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder folds(String folds) {
            doSetProperty("folds", folds);
            return this;
        }
        /**
         * Path to load the model from.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: model
         * 
         * @param loadFrom the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder loadFrom(String loadFrom) {
            doSetProperty("loadFrom", loadFrom);
            return this;
        }
        /**
         * Path to save the model to.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: model
         * 
         * @param saveTo the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder saveTo(String saveTo) {
            doSetProperty("saveTo", saveTo);
            return this;
        }
        /**
         * An optional seed for the randomizer.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: model
         * 
         * @param seed the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder seed(int seed) {
            doSetProperty("seed", seed);
            return this;
        }
        /**
         * An optional seed for the randomizer.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: model
         * 
         * @param seed the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder seed(String seed) {
            doSetProperty("seed", seed);
            return this;
        }
        /**
         * Flag on whether to use cross-validation with the current dataset.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: model
         * 
         * @param xval the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder xval(boolean xval) {
            doSetProperty("xval", xval);
            return this;
        }
        /**
         * Flag on whether to use cross-validation with the current dataset.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: model
         * 
         * @param xval the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder xval(String xval) {
            doSetProperty("xval", xval);
            return this;
        }
        /**
         * An in/out path for the read/write commands.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: write
         * 
         * @param path the value to set
         * @return the dsl builder
         */
        default WekaEndpointBuilder path(String path) {
            doSetProperty("path", path);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Weka component.
     */
    public interface AdvancedWekaEndpointBuilder
            extends
                EndpointProducerBuilder {
        default WekaEndpointBuilder basic() {
            return (WekaEndpointBuilder) this;
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
        default AdvancedWekaEndpointBuilder lazyStartProducer(
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
        default AdvancedWekaEndpointBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    }

    public interface WekaBuilders {
        /**
         * Weka (camel-weka)
         * Perform machine learning tasks using Weka.
         * 
         * Category: blockchain
         * Since: 3.1
         * Maven coordinates: org.apache.camel:camel-weka
         * 
         * Syntax: <code>weka:command</code>
         * 
         * Path parameter: command (required)
         * The command to use.
         * There are 7 enums and the value can be one of: filter, model, read,
         * write, push, pop, version
         * 
         * @param path command
         * @return the dsl builder
         */
        default WekaEndpointBuilder weka(String path) {
            return WekaEndpointBuilderFactory.endpointBuilder("weka", path);
        }
        /**
         * Weka (camel-weka)
         * Perform machine learning tasks using Weka.
         * 
         * Category: blockchain
         * Since: 3.1
         * Maven coordinates: org.apache.camel:camel-weka
         * 
         * Syntax: <code>weka:command</code>
         * 
         * Path parameter: command (required)
         * The command to use.
         * There are 7 enums and the value can be one of: filter, model, read,
         * write, push, pop, version
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path command
         * @return the dsl builder
         */
        default WekaEndpointBuilder weka(String componentName, String path) {
            return WekaEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }
    static WekaEndpointBuilder endpointBuilder(String componentName, String path) {
        class WekaEndpointBuilderImpl extends AbstractEndpointBuilder implements WekaEndpointBuilder, AdvancedWekaEndpointBuilder {
            public WekaEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new WekaEndpointBuilderImpl(path);
    }
}