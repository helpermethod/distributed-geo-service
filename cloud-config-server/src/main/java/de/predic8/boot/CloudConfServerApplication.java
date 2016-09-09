package de.predic8.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//@EnableConfigServer
@SpringBootApplication
public class CloudConfServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudConfServerApplication.class, args);
	}
}