package edu.guosong.sc.hijklmnadmin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("edu.guosong.sc.hijklmnadmin")
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
