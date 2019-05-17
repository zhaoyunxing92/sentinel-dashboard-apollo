/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule;

/**
 * @author zhaoyunxing
 * @date: 2019-05-16 02:01
 * @des:
 */
public interface DynamicRuleService<T> {
    /**
     * 流控规则
     */
    String flowRuleKey = "sentinel.flowRules";
    /**
     * 熔断降级规则
     */
    String degradeRuleKey = "sentinel.degradeRules";
    /**
     * 授权规则
     */
    String authorityRuleKey = "sentinel.authorityRules";
    /**
     * 系统规则
     */
    String systemRuleKey = "sentinel.systemRules";
    /**
     * 热点规则
     */
    String paramFlowRuleKey = "sentinel.paramFlowRules";

    /**
     * 获取
     *
     * @param appName 项目名称
     * @return List<FlowRuleEntity>
     * @throws Exception
     */
    T getRules(String appName) throws Exception;

    /**
     * 推送
     *
     * @param appName 项目名称
     * @param rules   规则
     * @throws Exception
     */
    void publish(String appName, T rules) throws Exception;
}
