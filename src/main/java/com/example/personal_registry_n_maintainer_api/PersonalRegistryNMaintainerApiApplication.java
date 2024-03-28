package com.example.personal_registry_n_maintainer_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PersonalRegistryNMaintainerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalRegistryNMaintainerApiApplication.class, args);
    }

}
