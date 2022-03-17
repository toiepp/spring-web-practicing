package me.mikholskiy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan({"me.mikholskiy"})
@PropertySource("classpath:applicationProps.yml")
public class AppConfig implements EnvironmentAware {
	private Environment environment;

	@Bean("c3poDataSource")
	public DataSource source() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		dataSource.setUser(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
		dataSource.setMinPoolSize(environment.getProperty("jdbc.minPoolSize", Integer.class));
		dataSource.setMaxPoolSize(environment.getProperty("jdbc.maxPoolSize", Integer.class));
		dataSource.setMaxIdleTime(environment.getProperty("jdbc.maxIdleTime", Integer.class));
		return dataSource;
	}

	@Bean("driverManagerDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		return dataSource;
	}

	@Bean("sessionFactory")
	public LocalSessionFactoryBean sessionFactory(@Qualifier("driverManagerDataSource") DataSource source) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(source);
		sessionFactoryBean.setPackagesToScan("me.mikholskiy.domains");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());

		return sessionFactoryBean;
	}

	@Bean("transactionManager")
	public HibernateTransactionManager transactionManager(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql", String.class));
		return properties;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
