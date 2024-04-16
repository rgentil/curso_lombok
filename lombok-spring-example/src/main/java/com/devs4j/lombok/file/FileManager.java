package com.devs4j.lombok.file;

import java.io.File;
//import java.io.IOException;

import lombok.SneakyThrows;

public class FileManager {
	
	public static void createFiles(String ...files){
		for (String file : files) {
			createFile(file);
		}
	}
	
	//Solo para excepciones check, solo las que heredan de Exception, en este caso IOException
	@SneakyThrows
	public static void createFile(String file){
		File f = new File(file);
		f.createNewFile();
	}
}
