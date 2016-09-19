package de.predic8.cloud;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Component
public class PlzBackendServiceClientFallback implements PlzBackendServiceClient {
	@Override
	public Coord coords(@RequestParam("plz") String plz) {
		return new Coord("13.4061", "52.5192");
	}
}
