package me.mikholskiy.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath*:database.yml"})
public class ApplicationConfig {
	private final Environment environment;

	public ApplicationConfig(Environment environment) {
		this.environment = environment;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver_class_name"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(@Qualifier("dataSource") DataSource source) {
		var factory = new LocalSessionFactoryBean();

		factory.setDataSource(source);
		factory.setHibernateProperties(hibernateProps());

		return factory;
	}

	private Properties hibernateProps() {
		Properties properties = new Properties();

		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

		return properties;
	}
}
