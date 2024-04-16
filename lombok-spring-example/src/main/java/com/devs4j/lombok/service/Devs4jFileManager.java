package com.devs4j.lombok.service;

//import java.io.Closeable;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Devs4jFileManager /*implements Closeable*/ {
	
	//private static final Logger log = LoggerFactory.getLogger(Devs4jFileManager.class);

	public void write(String text, String file) {
		log.info("Writing {} in {} ", text, file);
	}
	
	/*@Override
	public void close() throws IOException {
		log.info("Releasing resources");
		
	}*/
	
	public void releasingResources() throws IOException {
		log.info("Releasing resources");
		
	}
	
}
