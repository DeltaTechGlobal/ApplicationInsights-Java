/*
 * ApplicationInsights-Java
 * Copyright (c) Microsoft Corporation
 * All rights reserved.
 *
 * MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the ""Software""), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.applicationinsights.boot;

import com.microsoft.applicationinsights.web.extensibility.initializers.WebOperationIdTelemetryInitializer;
import com.microsoft.applicationinsights.web.extensibility.initializers.WebOperationNameTelemetryInitializer;
import com.microsoft.applicationinsights.web.extensibility.initializers.WebSessionTelemetryInitializer;
import com.microsoft.applicationinsights.web.extensibility.initializers.WebUserAgentTelemetryInitializer;
import com.microsoft.applicationinsights.web.extensibility.initializers.WebUserTelemetryInitializer;
import com.microsoft.applicationinsights.web.extensibility.modules.WebRequestTrackingTelemetryModule;
import com.microsoft.applicationinsights.web.extensibility.modules.WebSessionTrackingTelemetryModule;
import com.microsoft.applicationinsights.web.extensibility.modules.WebUserTrackingTelemetryModule;
import com.microsoft.applicationinsights.web.internal.perfcounter.WebPerformanceCounterModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationInsightsWebModuleConfiguration {

    @Bean
    public WebRequestTrackingTelemetryModule webRequestTrackingTelemetryModule() {
        return new WebRequestTrackingTelemetryModule();
    }

    @Bean
    public WebSessionTrackingTelemetryModule webSessionTrackingTelemetryModule() {
        return new WebSessionTrackingTelemetryModule();
    }

    @Bean
    public WebUserTrackingTelemetryModule webUserTrackingTelemetryModule() {
        return new WebUserTrackingTelemetryModule();
    }

    @Bean
    public WebPerformanceCounterModule webPerformanceCounterModule() {
        return new WebPerformanceCounterModule();
    }

    @Bean
    public WebOperationIdTelemetryInitializer webOperationIdTelemetryInitializer() {
        return new WebOperationIdTelemetryInitializer();
    }

    @Bean
    public WebOperationNameTelemetryInitializer webOperationNameTelemetryInitializer() {
        return new WebOperationNameTelemetryInitializer();
    }

    @Bean
    public WebSessionTelemetryInitializer webSessionTelemetryInitializer() {
        return new WebSessionTelemetryInitializer();
    }

    @Bean
    public WebUserTelemetryInitializer webUserTelemetryInitializer() {
        return new WebUserTelemetryInitializer();
    }

    @Bean
    public WebUserAgentTelemetryInitializer webUserAgentTelemetryInitializer() {
        return new WebUserAgentTelemetryInitializer();
    }
}
