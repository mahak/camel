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
package org.apache.camel.impl.engine;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.apache.camel.spi.RouteError;

public class DefaultRouteError implements RouteError {
    private final RouteError.Phase phase;
    private final Throwable throwable;
    private final boolean unhealthy;
    private final Date date;

    public DefaultRouteError(Phase phase, Throwable throwable) {
        this(phase, throwable, false);
    }

    public DefaultRouteError(Phase phase, Throwable throwable, boolean unhealthy) {
        this.phase = phase;
        this.throwable = throwable;
        this.unhealthy = unhealthy;
        this.date = new Date();
    }

    @Override
    public Phase getPhase() {
        return phase;
    }

    @Override
    public Throwable getException() {
        return throwable;
    }

    @Override
    public boolean isUnhealthy() {
        return unhealthy;
    }

    @Override
    public Date getDate() {
        return date;
    }

    // ***********************************
    // Helpers
    // ***********************************

    public static void set(CamelContext context, String routeId, RouteError.Phase phase, Throwable throwable) {
        Route route = context.getRoute(routeId);
        if (route != null) {
            route.setLastError(new DefaultRouteError(phase, throwable));
        }
    }

    public static void set(
            CamelContext context, String routeId, RouteError.Phase phase, Throwable throwable, boolean unhealthy) {
        Route route = context.getRoute(routeId);
        if (route != null) {
            route.setLastError(new DefaultRouteError(phase, throwable, unhealthy));
        }
    }

    public static void reset(CamelContext context, String routeId) {
        Route route = context.getRoute(routeId);
        if (route != null) {
            route.setLastError(null);
        }
    }
}
