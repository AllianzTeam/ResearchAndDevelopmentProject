package com.groupchallenge.co2tracker;

import com.groupchallenge.co2tracker.controller.CityController;
import com.groupchallenge.co2tracker.controller.CustomerController;
import com.groupchallenge.co2tracker.controller.DistrictController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
		CityController.class, CustomerController.class, DistrictController.class })
public class SwaggerConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfig.class);

private static final String SWAGGER_API_VERSION = "1.0";
	private static final String LICENSE_TEXT = "License";
	private static final String title = "CO2 Tracker REST API";
	private static final String description = "apis for CO2 tracker";

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.license(LICENSE_TEXT)
				.version(SWAGGER_API_VERSION)
				.build();
	}

	@Bean
	public Docket frameworkApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.pathMapping("/")
				.select()
				.paths(PathSelectors.regex("/api.*"))
				.build();
	}
}


