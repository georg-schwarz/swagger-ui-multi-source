package com.schwarz.georg.swaggeruimultisource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource
@ContextConfiguration(classes = SwaggerUiMultiSourceApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
public class SwaggerUiMultiSourceApplicationTest {

	@Autowired
	SwaggerResourceProperties swaggerResourceProperties;

	@Test
	public void propertiesFileTwoEntries() {
		List<SwaggerResourceDefinition> resourceDefinitions = swaggerResourceProperties.getResources();
		assertEquals(2, resourceDefinitions.size());

		assertEquals(new SwaggerResourceDefinition("test1", "http://test1:8080/test1", "2.0"), resourceDefinitions.get(0));
		assertEquals(new SwaggerResourceDefinition("test2", "http://test2:8080/test2", "2.2"), resourceDefinitions.get(1));
	}

}

