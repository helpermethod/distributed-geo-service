package de.predic8.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

	@HystrixCommand(fallbackMethod = "timeout")
	public Coord resolve(String plz) {
		return restTemplate.getForObject("http://geo-code-service/coords/?plz={plz}", Coord.class, plz);
	}

	public Coord timeout(String plz) {
		throw new GatewayTimeoutException();
	}
}
