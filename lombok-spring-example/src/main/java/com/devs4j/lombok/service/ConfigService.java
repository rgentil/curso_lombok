package com.devs4j.lombok.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigService {
	//Si pongo true este metodo no se ejecuta hasta que se llame
	@Getter(lazy = false)
	private final String configuration = getConfigurationFromRemoteSource();

	private String getConfigurationFromRemoteSource() {
		log.info("Getting configuration");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		log.info("Configuration calculated");
		return "Configuration from remote source";
	}
}
