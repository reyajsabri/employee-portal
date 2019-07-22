package com.employee.portal.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * @author reyaj.ahmed
 *
 */
@Configuration
public class DataSourceConfig {
	
	@Value( "${spring.datasource.url}" )
	private String url;
	@Value( "${spring.jdbc.user}" )
	private String user;
	@Value( "${spring.jdbc.password}" )
	private String pasword;
	

	@Bean
	public DataSource dataSource(){
		final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.hsqldb.jdbc.JDBCDriver());
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pasword);
        return dataSource;

	}
}
