package com.zjf.auth.config;

import com.zjf.common.core.constant.SecurityConstants;
import com.zjf.common.security.service.AuthUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description token enhancer
 * @Author Harry
 * @Date 2019/9/15 10:43
 **/
@Configuration
public class TokenEnhancerConfig {

    /**
     * 对token内容进行增强
     * @return
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            if(authentication.getUserAuthentication()!=null){
                AuthUser authUser = (AuthUser) authentication.getUserAuthentication().getPrincipal();
                additionalInfo.put(SecurityConstants.DETAILS_LICENSE, SecurityConstants.PROJECT_LICENSE);
                additionalInfo.put(SecurityConstants.DETAILS_USER_ID, authUser.getId());
                additionalInfo.put(SecurityConstants.DETAILS_USERNAME, authUser.getUsername());
                additionalInfo.put(SecurityConstants.DETAILS_DEPT_ID, authUser.getDeptId());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            }
            return accessToken;
        };
    }

}
