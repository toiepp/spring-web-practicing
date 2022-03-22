package me.mikholskiy.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Objects;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@PropertySource("classpath:applicationProps.yml")
@ComponentScan({"me.mikholskiy"})
public class WebConfig implements EnvironmentAware {
	private Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver(
			Objects.requireNonNull(environment.getProperty("spring.viewResolver.prefix")),
			Objects.requireNonNull(environment.getProperty("spring.viewResolver.suffix"))
		);
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}
