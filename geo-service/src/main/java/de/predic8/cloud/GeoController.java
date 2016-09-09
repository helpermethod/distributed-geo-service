package de.predic8.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class GeoController {
	@Autowired
	private CoordService coordService;

	@RequestMapping(value = "/coords", method = RequestMethod.GET)
	public Coord shorten(@RequestParam("plz") String plz) throws IOException {
		return coordService.findOneByPlz(plz).orElseThrow(NotFoundException::new);
	}
}