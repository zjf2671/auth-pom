package com.zjf.common.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate
 * @author Harry
 */
@Configuration
public class RestTemplateConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
