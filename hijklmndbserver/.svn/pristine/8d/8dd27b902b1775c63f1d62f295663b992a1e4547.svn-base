package edu.guosong.sc.hijklmndbserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import edu.guosong.sc.hijklmndbserver.config.MySQLConfig;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({ MySQLConfig.class })
@PropertySource("classpath:/jdbc.properties")
public class ApplicationConfig {

}
