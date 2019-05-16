/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo;

/**
 * @author 2385585770@qq.com
 * @since 1.6.0
 */
//@Service("flowRuleApolloPublisher")
//public class FlowRuleApolloPublisher implements DynamicRulePublisher<List<FlowRuleEntity>> {
//
//    private final ApolloOpenApiClient apolloOpenApiClient;
//
//    private final Converter<List<FlowRuleEntity>, String> converter;
//
//    @Value("${env:DEV}")
//    private String env;
//
//    @Autowired
//    public FlowRuleApolloPublisher(ApolloOpenApiClient apolloOpenApiClient, Converter<List<FlowRuleEntity>, String> converter) {
//        this.apolloOpenApiClient = apolloOpenApiClient;
//        this.converter = converter;
//    }
//
//    @Override
//    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
//        String flowDataId = "sentinel.flowRules";
//
//        AssertUtil.notEmpty(app, "app name cannot be empty");
//        if (rules == null) {
//            return;
//        }
//
//        OpenItemDTO openItemDTO = new OpenItemDTO();
//        openItemDTO.setKey(flowDataId);
//        openItemDTO.setValue(converter.convert(rules));
//        openItemDTO.setComment("modify by sentinel-dashboard");
//        openItemDTO.setDataChangeCreatedBy("apollo");
//        apolloOpenApiClient.createOrUpdateItem(app, env, "default", "application", openItemDTO);
//
//        // Release configuration
//        NamespaceReleaseDTO namespaceReleaseDTO = new NamespaceReleaseDTO();
//        namespaceReleaseDTO.setEmergencyPublish(true);
//        namespaceReleaseDTO.setReleaseComment("release by sentinel-dashboard");
//        namespaceReleaseDTO.setReleasedBy("apollo");
//        namespaceReleaseDTO.setReleaseTitle("release by sentinel-dashboard");
//        apolloOpenApiClient.publishNamespace(app, env, "default", "application", namespaceReleaseDTO);
//    }
//}
