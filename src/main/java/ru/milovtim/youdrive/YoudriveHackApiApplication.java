package ru.milovtim.youdrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

@SpringBootApplication
public class YoudriveHackApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(YoudriveHackApiApplication.class, args);
	}
}
