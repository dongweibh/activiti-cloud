/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.starter.tests;

import org.activiti.cloud.starter.query.configuration.EnableActivitiQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableActivitiQuery
@ComponentScan({"org.activiti.cloud.services.query.app",
        "org.activiti.cloud.services.query.events",
        "org.activiti.cloud.services.query.rest",
        "org.activiti.cloud.starters",
        "org.activiti.cloud.starter",
        "org.activiti.cloud.services.common.security.keycloak",
        "org.activiti.spring.security.policies",
        "org.activiti.cloud.alfresco",
        "org.activiti.cloud.services.test.identity.keycloak.interceptor"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,
                              args);
    }
}