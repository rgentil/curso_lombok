package com.devs4j.lombok.model;

import lombok.NonNull;

public class TwitterAcount {

	private String username;

	public TwitterAcount(@NonNull String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
