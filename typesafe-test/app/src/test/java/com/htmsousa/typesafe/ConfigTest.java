package com.htmsousa.typesafe;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigTest {

	@Test
	public void shouldLoadProperties1() throws Exception {
		String resourceName = "test1-main.conf";
		String propertyValueSufix = "1";
		runTest(resourceName, propertyValueSufix);
	}
	
	@Test
	public void shouldLoadProperties2() throws Exception {
		String resourceName = "test2/test2-main.conf";
		String propertyValueSufix = "2";
		runTest(resourceName, propertyValueSufix);
	}
	
	@Test
	public void shouldLoadProperties3() throws Exception {
		String resourceName = "test3/test3-main.conf";
		String propertyValueSufix = "3";
		runTest(resourceName, propertyValueSufix);
	}

	private void runTest(String resourceName, String propertyValueSufix) throws IOException {
		URL resource = this.getClass().getClassLoader().getResource(resourceName);
		System.out.println("Loading resource "+ resource.getPath());
		try (Reader configReader = new InputStreamReader(
				resource.openStream())) {
			Config conf = ConfigFactory.parseReader(configReader);

			Assert.assertEquals("Config from main conf " + propertyValueSufix, conf.getString("main.property"));
			Assert.assertEquals("Database Connection " + propertyValueSufix, conf.getString("jdbc.property"));

		}
	}
}