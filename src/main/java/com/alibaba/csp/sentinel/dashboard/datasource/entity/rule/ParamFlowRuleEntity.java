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
package com.alibaba.csp.sentinel.dashboard.datasource.entity.rule;

import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowClusterConfig;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowItem;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Eric Zhao
 * @since 0.2.1
 */
public class ParamFlowRuleEntity implements RuleEntity {
    @JSONField(serialize = false)
    private Long id;
    @JSONField(serialize = false)
    private String app;
    @JSONField(serialize = false)
    private String ip;
    @JSONField(serialize = false)
    private Integer port;

    private ParamFlowRule rule;

    //    public ParamFlowRuleEntity(ParamFlowRule rule) {
    //        AssertUtil.notNull(rule, "Authority rule should not be null");
    //        this.rule = rule;
    //    }

    //    public static ParamFlowRuleEntity fromAuthorityRule(String app, String ip, Integer port, ParamFlowRule rule) {
    //        ParamFlowRuleEntity entity = new ParamFlowRuleEntity(rule);
    //        entity.setApp(app);
    //        entity.setIp(ip);
    //        entity.setPort(port);
    //        return entity;
    //    }

    @JsonIgnore
    public String getLimitApp() {
        return rule.getLimitApp();
    }

    @JsonIgnore
    public String getResource() {
        return rule.getResource();
    }

    @JsonIgnore
    public int getGrade() {
        return rule.getGrade();
    }

    @JsonIgnore
    public Integer getParamIdx() {
        return rule.getParamIdx();
    }

    @JsonIgnore
    public double getCount() {
        return rule.getCount();
    }

    @JsonIgnore
    public List<ParamFlowItem> getParamFlowItemList() {
        return new ArrayList<>();
    }

    @JsonIgnore
    public boolean isClusterMode() {
        return rule.isClusterMode();
    }

    @JsonIgnore
    public ParamFlowClusterConfig getClusterConfig() {
        return rule.getClusterConfig();
    }

    @Override
    public Rule toRule() {
        return rule;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    @Override
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public Integer getPort() {
        return port;
    }

    @Override
    public Date getGmtCreate() {
        return new Date();
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public ParamFlowRule getRule() {
        return rule;
    }

    public void setRule(ParamFlowRule rule) {
        this.rule = rule;
    }
}
