package edu.guosong.sc.hijklmnstage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("edu.guosong.sc.hijklmnstage")
public class ApplicationConfig {

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
