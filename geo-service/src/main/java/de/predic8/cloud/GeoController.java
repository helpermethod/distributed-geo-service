package de.predic8.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
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
	private CoordService coordService;
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	@Autowired
//	private RestTemplate restTemplate;
//	@Autowired
//	private GeoCodeServiceClient geoCodeServiceClient;
//	@Autowired
//	private GeoCodeResolver geoCodeResolver;

	@RequestMapping(value = "/coords", method = RequestMethod.GET)
	public Coord coords(@RequestParam("plz") String plz) throws IOException {
		logger.info("GET http://geo-service/coords/" + plz);
		return coordService.findOneByPlz(plz).orElseThrow(NotFoundException::new);

		// setzt einen laufenden geo-code-service voraus
//		URI uri = UriComponentsBuilder.fromUri(discoveryClient.getInstances("geo-code-service").get(0).getUri())
//				.path("/coords")
//				.queryParam("plz", plz)
//				.buildAndExpand(plz)
//				.toUri();

//		return restTemplate.getForObject(uri, Coord.class);
//		return geoCodeServiceClient.coords(plz);
//		return geoCodeResolver.resolve(plz);
	}
}