package me.mikholskiy.configuration.web;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Optional;

@Configuration
/* Аналогичен <mvc:annotation-driven />
* Добавляет поддержку преобразования, форматирования и валидации
* А также обработку классов-контроллеров и прочего */
@EnableWebMvc
@ComponentScan({"me.mikholskiy"})
public class WebAppConfiguration implements WebMvcConfigurer, EnvironmentAware {
	private Environment environment;

	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver(
			Optional.ofNullable(environment.getProperty("application.view_resolver.prefix", String.class)).orElse("/WEB-INF/templates/"),
			Optional.ofNullable(environment.getProperty("application.view_resolver.suffix", String.class)).orElse(".jsp")
		);
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}

