package de.predic8.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@FeignClient(value = "plz-backend-service", fallback = PlzBackendServiceClientFallback.class)
public interface PlzBackendServiceClient {
	@RequestMapping("/coords")
	Coord coords(@RequestParam("plz") String plz);
}