/*
 * cna-spring-hello:CloudConfiguration.java
 */
package edu.hm.cs.fwp.cloud;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Mandatory {@code configuration bean} if you want to trigger service binding
 * via Spring Cloud Connectors.
 * 
 * @author mikeT92
 * @version 1.0
 * @since 12.05.2018
 */
@Profile({ "cloud" })
public class CloudConfiguration extends AbstractCloudConfig {

	@Bean
	public DataSource postgresDataSource() {
		return connectionFactory().dataSource();
	}
}
