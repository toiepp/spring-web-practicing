package me.mikholskiy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"me.mikholskiy"})
public class WebAppContext implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver(
				"/WEB-INF/templates/",
				".jsp"
		);
	}
}
