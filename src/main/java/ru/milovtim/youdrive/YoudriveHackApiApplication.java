package ru.milovtim.youdrive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class YoudriveHackApiApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
		SpringApplication.run(new Object[] {YoudriveHackApiApplication.class, ServletInitializer.class}, args);
	}
}
