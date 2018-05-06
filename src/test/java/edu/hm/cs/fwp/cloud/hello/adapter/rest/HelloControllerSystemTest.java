package edu.hm.cs.fwp.cloud.hello.adapter.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class HelloControllerSystemTest {

	private String targetUrl;

	/**
	 * Pulls the target URL of the REST endpoint from the environment and sets up
	 * the REST client.
	 */
	@Before
	public void onBefore() {

		this.targetUrl = System.getProperty("target.route");
		assertNotNull("system property \"target.route\" must set defined", this.targetUrl);
		String computerName = System.getenv("COMPUTERNAME");
		if (computerName != null && computerName.startsWith("MSG") && !this.targetUrl.contains("localhost")) {
			RestAssured.proxy("proxy.msg.de", 3128);
		}
		RestAssured.baseURI = this.targetUrl;
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
	}

	@Test
	public void testGetWelcomeMessage() {
		String welcomeMessage = RestAssured.given().get("hello").asString();
		assertEquals("Herzlich Willkommen bei Spring Boot!", welcomeMessage);
	}

}
