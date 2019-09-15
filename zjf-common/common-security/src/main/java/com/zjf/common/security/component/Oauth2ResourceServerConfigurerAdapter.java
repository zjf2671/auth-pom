package com.zjf.common.security.component;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @Description 资源服务配置
 * @Author Harry
 * @Date 2019/9/2 17:19
 **/
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
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        ZjfUserAuthenticationConverter zjfUserAuthenticationConverter = new ZjfUserAuthenticationConverter();
        defaultAccessTokenConverter.setUserTokenConverter(zjfUserAuthenticationConverter);
        remoteTokenServices.setAccessTokenConverter(defaultAccessTokenConverter);
        remoteTokenServices.setClientId("client1");
        remoteTokenServices.setClientSecret("123456");
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8080/auth/oauth/check_token");
        resources.tokenServices(remoteTokenServices);
    }


}
