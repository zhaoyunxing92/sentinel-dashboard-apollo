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
package com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.bak;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AbstractRuleEntity;
import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowClusterConfig;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author Eric Zhao
 * @since 0.2.1
 */
public class ParamFlowRuleEntity extends AbstractRuleEntity<ParamFlowRule> {

    public ParamFlowRuleEntity() {}

    public ParamFlowRuleEntity(ParamFlowRule rule) {
        AssertUtil.notNull(rule, "Authority rule should not be null");
        super.setRule(rule);
    }

    public static ParamFlowRuleEntity fromAuthorityRule(String app, String ip, Integer port, ParamFlowRule rule) {
        ParamFlowRuleEntity entity = new ParamFlowRuleEntity(rule);
        entity.setApp(app);
        entity.setIp(ip);
        entity.setPort(port);
        return entity;
    }

    @JsonIgnore
    public String getLimitApp() {
        return getRule().getLimitApp();
    }

    @JsonIgnore
    public String getResource() {
        return getRule().getResource();
    }

    @JsonIgnore
    public int getGrade() {
        return getRule().getGrade();
    }

    @JsonIgnore
    public Integer getParamIdx() {
        return getRule().getParamIdx();
    }

    @JsonIgnore
    public double getCount() {
        return getRule().getCount();
    }

    @JsonIgnore
    public List<ParamFlowItem> getParamFlowItemList() {
        return getRule().getParamFlowItemList();
    }

    @JsonIgnore
    public boolean isClusterMode() {
        return getRule().isClusterMode();
    }

    @JsonIgnore
    public ParamFlowClusterConfig getClusterConfig() {
        return getRule().getClusterConfig();
    }

    @Override
    public Rule toRule() {
        return getRule();
    }
}
