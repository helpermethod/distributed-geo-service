package de.predic8.cloud;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Component
public class GeoCodeServiceClientFallback implements GeoCodeServiceClient{
	@Override
	public Coord coords(@RequestParam("plz") String plz) {
		return null;
	}
}
