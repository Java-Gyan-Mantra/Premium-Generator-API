package com.health.insurance.premium.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class PremiumGeneratorApiApplication extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Premium-Generator/home").setViewName("findPremium");;
	}

	public static void main(String[] args) {
		SpringApplication.run(PremiumGeneratorApiApplication.class, args);
	}
}
