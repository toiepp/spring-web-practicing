package me.mikholskiy.configuration.web;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan({"me.mikholskiy"})
@PropertySource("classpath:application.properties")
public class WebAppContext implements EnvironmentAware {
	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		dataSource.setUser(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		try {
			dataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		dataSource.setInitialPoolSize(environment.getProperty("connection.initialPoolSize", Integer.class));
		dataSource.setMinPoolSize(environment.getProperty("connection.minPoolSize", Integer.class));
		dataSource.setMaxPoolSize(environment.getProperty("connection.maxPoolSize", Integer.class));
		dataSource.setMaxIdleTime(environment.getProperty("connection.maxIdleTime", Integer.class));

		return dataSource;
	}
}
