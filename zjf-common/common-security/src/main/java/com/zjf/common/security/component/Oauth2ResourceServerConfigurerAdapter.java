package com.zjf.common.security.component;

import com.zjf.common.core.constant.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description 资源服务配置
 * @Author Harry
 * @Date 2019/9/2 17:19
 **/
@Slf4j
public class Oauth2ResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/message").permitAll()
                .anyRequest()
                .authenticated()
//                .and()
//                .requestMatchers()
//                .antMatchers("/api/**")
                ;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
//        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
//        ZjfUserAuthenticationConverter zjfUserAuthenticationConverter = new ZjfUserAuthenticationConverter();
//        defaultAccessTokenConverter.setUserTokenConverter(zjfUserAuthenticationConverter);
//        remoteTokenServices.setAccessTokenConverter(defaultAccessTokenConverter);
//        remoteTokenServices.setClientId("client1");
//        remoteTokenServices.setClientSecret("123456");
//        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8080/auth/oauth/check_token");
//        resources.tokenServices(remoteTokenServices);
        resources.tokenStore(jwtTokenStore());
    }

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        //用自定义的ZjfUserAuthenticationConverter解析出用户增强信息数据
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        ZjfUserAuthenticationConverter zjfUserAuthenticationConverter = new ZjfUserAuthenticationConverter();
        defaultAccessTokenConverter.setUserTokenConverter(zjfUserAuthenticationConverter);

        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SecurityConstants.JWT_SIGNING_KEY);
        jwtAccessTokenConverter.setAccessTokenConverter(defaultAccessTokenConverter);
        try {
            //这地方必须显示的的调用afterPropertiesSet，否则使用对称加密方式会有问题
            jwtAccessTokenConverter.afterPropertiesSet();
        } catch (Exception e) {
            log.error("显示调用afterPropertiesSet异常",e);
        }
        return jwtAccessTokenConverter;

    }


}
