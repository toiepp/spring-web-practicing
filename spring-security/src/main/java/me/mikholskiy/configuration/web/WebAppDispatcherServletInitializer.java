package me.mikholskiy.configuration.web;

import me.mikholskiy.configuration.security.WebAppSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WebAppContext.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{
			WebAppConfig.class,
			WebAppSecurityConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
