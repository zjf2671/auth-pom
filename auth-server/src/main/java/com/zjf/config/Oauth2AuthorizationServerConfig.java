package com.zjf.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

/**
 * @Description oauth2适配器相关配置
 * @Author Harry
 * @Date 2019/9/2 9:38
 **/
@EnableAuthorizationServer
@Configuration
@AllArgsConstructor
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

    /**
     * 密码加密方式
     */
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 用户认证
     */
    private AuthenticationManager authenticationManager;

    /**
     * 数据源
     */
    private DruidDataSource druidDataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory() // 测试用，将客户端信息存储在内存中
//                .withClient("client1")
//                .secret(passwordEncoder.encode("123456"))
//                // 该client允许的授权类型
//                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
//                .redirectUris("http://localhost:8080/callback")
//                .scopes("all")
//                //登录后绕过批准询问(/oauth/confirm_access)
//                .autoApprove(true);
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(druidDataSource);
        clients.withClientDetails(jdbcClientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                //只允许验证用户访问令牌解析端点（/oauth/check_token）
                .checkTokenAccess("isAuthenticated()")
                //允许所有资源服务器访问公钥端点（/oauth/token_key）
                //.tokenKeyAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }
}
