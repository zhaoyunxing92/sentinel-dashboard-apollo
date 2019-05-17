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

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleService;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyunxing
 * @date: 2019-05-16 03:05
 * @since 1.6.0
 */
@Service
public class AuthorityRuleApolloService implements DynamicRuleService<List<AuthorityRuleEntity>> {

    private final ApolloDynamicRuleService apolloService;

    @Autowired
    public AuthorityRuleApolloService(ApolloDynamicRuleService apolloService) {
        this.apolloService = apolloService;
    }

    @Override
    public List<AuthorityRuleEntity> getRules(String appName) throws Exception {

        String rules = apolloService.getRules(appName, authorityRuleKey);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return JSON.parseArray(rules, AuthorityRuleEntity.class);
    }

    @Override
    public void publish(String appName, List<AuthorityRuleEntity> rules) throws Exception {
        apolloService.publish(appName, authorityRuleKey, JSON.toJSONString(rules));
    }
}
