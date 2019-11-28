package com.rizomm.filemanager;

import com.rizomm.filemanager.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class FilemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilemanagerApplication.class, args);
	}

}
