package com.employee.portal.app.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * @author reyaj.ahmed
 *
 */
@Component
public class APPContextConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {

		factory.setPort(8080);
		factory.setContextPath("/employee-gateway");

	}

}