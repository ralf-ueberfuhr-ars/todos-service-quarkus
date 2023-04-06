package de.samples.quarkus.helloworld.config;

import javax.enterprise.context.Dependent;

import org.eclipse.microprofile.config.inject.ConfigProperties;

@Dependent
@ConfigProperties(prefix = "hello")
public class HelloWorldConfig {

	private String template = "Hello {0}!";
	private String defaultName = "World";

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

}
