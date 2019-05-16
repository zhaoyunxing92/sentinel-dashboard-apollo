/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule;

/**
 * @author zhaoyunxing
 * @date: 2019-05-16 14:11
 * @des:
 */
public interface ApolloRuleService<T> {
    /**
     *
     */
    String flowRuleKey = "sentinel.flowRules";

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
