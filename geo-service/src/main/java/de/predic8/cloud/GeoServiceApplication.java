package de.predic8.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GeoServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeoServiceApplication.class, args);
	}
}