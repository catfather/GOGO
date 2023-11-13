package com.gogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={
//		org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
//		org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
//		org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
})
public class Application {



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
