package com.zjf.common.cecurity.component;

import com.zjf.common.cecurity.annotation.EnableZjfResourceServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @Description 资源服务配置
 * @Author Harry
 * @Date 2019/9/2 17:19
 **/
@Configuration
public class Oauth2ResourceServer extends ResourceServerConfigurerAdapter{

    @Autowired
    private RemoteTokenServices remoteTokenServices;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .requestMatchers()
                .antMatchers("/api/**");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        remoteTokenServices.setClientId("client1");
        remoteTokenServices.setClientSecret("123456");
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8080/auth/oauth/check_token");
        resources.tokenServices(remoteTokenServices);
    }


    @Bean
    public RemoteTokenServices remoteTokenServices(){
        return new RemoteTokenServices();
    }


}
