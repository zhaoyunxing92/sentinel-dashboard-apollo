/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule;

/**
 * @author zhaoyunxing
 * @date: 2019-05-16 02:11
 * @des:
 */
public interface ApolloDynamicRule {
    /**
     * 获取规则
     *
     * @param appName apollo的项目项目名称
     * @param key     key
     * @return json字符串
     * @throws Exception
     */
    String getRules(String appName, String key) throws Exception;

    /**
     * 提交规则
     *
     * @param appName apollo的项目项目名称
     * @param key     key
     * @param rules   规则
     * @throws Exception
     */
    void publish(String appName, String key, String rules) throws Exception;
}
