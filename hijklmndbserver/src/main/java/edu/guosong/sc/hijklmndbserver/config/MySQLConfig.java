package edu.guosong.sc.hijklmndbserver.config;

import java.net.MalformedURLException;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MySQLConfig implements EnvironmentAware {

	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource getDruidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setInitialSize(3);
		dataSource.setDriverClassName(environment.getRequiredProperty("mysql.driverClass"));
		dataSource.setUrl(environment.getRequiredProperty("mysql.url"));
		dataSource.setUsername(environment.getRequiredProperty("mysql.username"));
		dataSource.setPassword(environment.getRequiredProperty("mysql.password"));
		dataSource.setMaxActive(environment.getRequiredProperty("mysql.maxactive", Integer.class));
		dataSource.setMinIdle(environment.getRequiredProperty("mysql.minidle", Integer.class));
		dataSource.setMaxWait(environment.getRequiredProperty("mysql.maxwait", Integer.class));
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean getSqlSessionFactoryBean() throws MalformedURLException {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(getDruidDataSource());
		bean.setTypeAliasesPackage("edu.guosong.sc.hijklmndbserver.mapper");
		return bean;
	}

	@Bean
	public MapperScannerConfigurer getMapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("edu.guosong.sc.hijklmndbserver");
		return configurer;
	}

}
