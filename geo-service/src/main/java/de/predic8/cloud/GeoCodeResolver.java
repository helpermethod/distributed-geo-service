package de.predic8.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Service
public class GeoCodeResolver {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "resolveBerlin",
			commandProperties = {@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "1")})
	public Coord resolve(String plz) {
		return restTemplate.getForObject("http://geo-code-service/coords/?plz={plz}", Coord.class, plz);
	}

	public Coord resolveBerlin(String plz) {
		return new Coord("13.4061", "52.5192");
	}
}