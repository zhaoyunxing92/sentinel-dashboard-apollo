/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package com.alibaba.csp.sentinel.dashboard.rule.apollo;

import com.alibaba.csp.sentinel.dashboard.rule.ApolloDynamicRule;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import com.ctrip.framework.apollo.openapi.dto.NamespaceReleaseDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenItemDTO;
import com.ctrip.framework.apollo.openapi.dto.OpenNamespaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhaoyunxing
 * @date: 2019-05-16 02:15
 * @des:
 */
@Service
public class ApolloDynamicRuleService implements ApolloDynamicRule {

    private final ApolloOpenApiClient apolloOpenApiClient;

    @Value("${env:DEV}")
    private String env;

    @Autowired
    public ApolloDynamicRuleService(ApolloOpenApiClient apolloOpenApiClient) {
        this.apolloOpenApiClient = apolloOpenApiClient;

    }

    @Override
    public String getRules(String appName, String key) throws Exception {
        OpenNamespaceDTO openNamespaceDTO = apolloOpenApiClient.getNamespace(appName, env, "default", "application");
        return openNamespaceDTO
                .getItems()
                .stream()
                .filter(p -> p.getKey().equals(key))
                .map(OpenItemDTO::getValue)
                .findFirst()
                .orElse("");
    }

    @Override
    public void publish(String appName, String key, String rules) throws Exception {
        AssertUtil.notEmpty(appName, "app name cannot be empty");
        if (StringUtil.isEmpty(rules)) {
            return;
        }

        OpenItemDTO openItemDTO = new OpenItemDTO();
        openItemDTO.setKey(key);
        openItemDTO.setValue(rules);
        openItemDTO.setComment("modify by sentinel-dashboard");
        openItemDTO.setDataChangeCreatedBy("apollo");
        apolloOpenApiClient.createOrUpdateItem(appName, env, "default", "application", openItemDTO);

        // Release configuration
        NamespaceReleaseDTO namespaceReleaseDTO = new NamespaceReleaseDTO();
        namespaceReleaseDTO.setEmergencyPublish(true);
        namespaceReleaseDTO.setReleaseComment("release by sentinel-dashboard");
        namespaceReleaseDTO.setReleasedBy("apollo");
        namespaceReleaseDTO.setReleaseTitle("release by sentinel-dashboard");
        apolloOpenApiClient.publishNamespace(appName, env, "default", "application", namespaceReleaseDTO);
    }
}
