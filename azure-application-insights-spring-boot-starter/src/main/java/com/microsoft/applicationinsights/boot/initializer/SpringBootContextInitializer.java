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

package com.microsoft.applicationinsights.boot.initializer;

import com.microsoft.applicationinsights.extensibility.ContextInitializer;
import com.microsoft.applicationinsights.extensibility.context.ContextTagKeys;
import com.microsoft.applicationinsights.telemetry.TelemetryContext;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.core.SpringVersion;
import org.springframework.core.env.Environment;

/**
 * Context initializer that adds information regarding spring and spring boot version.
 *
 * @author Arthur Gavlyukovskiy
 */
public class SpringBootContextInitializer implements ContextInitializer {
    private final Environment environment;

    public SpringBootContextInitializer(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void initialize(TelemetryContext telemetryContext) {
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment);
        telemetryContext.getTags().put("ai.spring-boot.version", SpringBootVersion.getVersion());
        telemetryContext.getTags().put("ai.spring.version", SpringVersion.getVersion());
        String ipAddress = relaxedPropertyResolver.getProperty("spring.cloud.client.ipAddress");
        if (ipAddress != null) {
            // if spring-cloud is available we can set ip address
            telemetryContext.getTags().put(ContextTagKeys.getKeys().getLocationIP(), ipAddress);
        }
    }
}