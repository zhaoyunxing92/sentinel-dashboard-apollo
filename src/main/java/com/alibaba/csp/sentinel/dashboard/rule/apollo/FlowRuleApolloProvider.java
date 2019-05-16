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
//@Service("flowRuleApolloProvider")
//public class FlowRuleApolloProvider implements DynamicRuleProvider<List<FlowRuleEntity>> {
//
//    private final ApolloOpenApiClient apolloOpenApiClient;
//    private final Converter<String, List<FlowRuleEntity>> converter;
//
//    @Value("${env:DEV}")
//    private String env;
//
//    @Autowired
//    public FlowRuleApolloProvider(ApolloOpenApiClient apolloOpenApiClient, Converter<String, List<FlowRuleEntity>> converter) {
//        this.apolloOpenApiClient = apolloOpenApiClient;
//        this.converter = converter;
//    }
//
//    @Override
//    public List<FlowRuleEntity> getRules(String appName) throws Exception {
//        String flowDataId = "sentinel.flowRules";
//        OpenNamespaceDTO openNamespaceDTO = apolloOpenApiClient.getNamespace(appName, env, "default", "application");
//        String rules = openNamespaceDTO
//            .getItems()
//            .stream()
//            .filter(p -> p.getKey().equals(flowDataId))
//            .map(OpenItemDTO::getValue)
//            .findFirst()
//            .orElse("");
//
//        if (StringUtil.isEmpty(rules)) {
//            return new ArrayList<>();
//        }
//        return converter.convert(rules);
//    }
//}
