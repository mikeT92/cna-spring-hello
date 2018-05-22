package edu.hm.cs.fwp.cloud.hello.adapter.rest;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class HelloControllerSystemTest {

	/**
	 * Pulls the target URL of the REST endpoint from the environment and sets up
	 * the REST client.
	 */
	@BeforeClass
	public static void onBeforeClass() throws Exception {
		String targetUrl = System.getProperty("target.route");
		assertNotNull("system property \"target.route\" must be set", targetUrl);
		RestAssured.baseURI = targetUrl;
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
		String checkReadinessPath = "actuator/health";
		int failureThreshold = 3;
		int initialDelaySeconds = 10;
		int periodSeconds = 10;
		if (initialDelaySeconds > 0) {
			Thread.sleep(initialDelaySeconds * 1000);
		}
		boolean succeeded = false;
		while (!succeeded && failureThreshold > 0) {
			try {
				RestAssured.given().get(checkReadinessPath).then().assertThat().statusCode(200);
				succeeded = true;
			} catch (Exception ex) {
			}
			if (!succeeded) {
				if (--failureThreshold > 0) {
					Thread.sleep(periodSeconds * 1000);
				}
			}
		}
		assertTrue("readiness check succeeded", succeeded);
	}

	@AfterClass
	public static void onAfterClass() {
		RestAssured.reset();
	}

	@Test
	public void testGetWelcomeMessage() {
		String welcomeMessage = RestAssured.given().get("hello").asString();
		assertEquals("Herzlich Willkommen bei Spring Boot!", welcomeMessage);
	}
}
