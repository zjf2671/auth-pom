package com.zjf.common.security.annotation;

import com.zjf.common.security.component.ZjfResourceServerAutoConfiguration;
import com.zjf.common.security.component.ZjfSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 *  资源服务注解
 * @author Harry
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ZjfResourceServerAutoConfiguration.class, ZjfSecurityBeanDefinitionRegistrar.class})
public @interface EnableZjfResourceServer {

}
