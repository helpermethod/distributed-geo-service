package de.predic8.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class GeoController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private PlzBackendServiceClient plzBackendServiceClient;

	@RequestMapping(value = "/coords", method = RequestMethod.GET)
	public Coord coords(@RequestParam("plz") String plz) throws IOException {
		logger.info("GET http://geo-service/coords/" + plz);

		return plzBackendServiceClient.coords(plz);
	}
}