package me.mikholskiy.appConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"me.mikholskiy.controllers"})
public class WebConfig implements WebMvcConfigurer {
	@Bean("viewResolver")
	public InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver(
				"/WEB-INF/views/",
				".jsp"
		);
	}
}
