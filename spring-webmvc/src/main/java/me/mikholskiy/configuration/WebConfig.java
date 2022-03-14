package me.mikholskiy.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.w3c.dom.UserDataHandler;

@Configuration
@EnableWebMvc
@ComponentScan({"me.mikholskiy"})
public class WebConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver(
				"/WEB-INF/templates/",
				".jsp"
		);
	}

	@Bean
	public MessageSource messageSource() {
		var source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}
}
