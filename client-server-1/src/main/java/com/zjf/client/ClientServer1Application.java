package com.zjf.client;

import com.zjf.common.security.annotation.EnableZjfResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Harry
 */
@EnableZjfResourceServer
@SpringBootApplication
public class ClientServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientServer1Application.class, args);
	}

}
