package com.zjf;

import com.zjf.common.cecurity.annotation.EnableZjfResourceServer;
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
