package de.predic8.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@RestController
public class CoordsController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CoordService coordService;

	@RequestMapping(value = "/coords", method = RequestMethod.GET)
	public Coord coords(@RequestParam("plz") String plz) throws IOException {
		logger.info("GET http://plz-backend-service/coords/" + plz);

		return coordService.findOneByPlz(plz).orElseThrow(NotFoundException::new);
	}
}