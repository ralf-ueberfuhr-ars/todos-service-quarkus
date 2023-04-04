package de.samples.quarkus.helloworld.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
	
	@JsonProperty("greeting")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeting [message=" + message + "]";
	}

}
