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

package org.activiti.cloud.alfresco.config;

import java.util.ArrayList;
import java.util.List;

import org.activiti.cloud.alfresco.argument.resolver.AlfrescoPageArgumentMethodResolver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

public class AlfrescoWebConfigurerTest {

    @InjectMocks
    private AlfrescoWebConfigurer configurer;

    @Mock
    private AlfrescoPageArgumentMethodResolver alfrescoPageArgumentMethodResolver;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void addArgumentResolversShouldAddAlfrescoPageArgumentMethodResolverAtTheFirstPosition() throws Exception {
        //given
        List<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();
        resolvers.add(mock(HandlerMethodArgumentResolver.class));

        //when
        configurer.addArgumentResolvers(resolvers);

        //then
        assertThat(resolvers.get(0)).isEqualTo(alfrescoPageArgumentMethodResolver);
    }

}