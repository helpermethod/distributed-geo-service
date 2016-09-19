package de.predic8.boot;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
@Service
public class CoordService {
	@Autowired
	private ResourceLoader resourceLoader;

	public Optional<Coord> findOneByPlz(String plz) throws IOException {
		MappingIterator<Map<String, String>> it = new CsvMapper()
				.readerFor(Map.class)
				.with(CsvSchema.emptySchema().withColumnSeparator('\t').withHeader())
				.readValues(resourceLoader.getResource("classpath:DE.tab").getFile());

		while (it.hasNext()) {
			if (Arrays.asList(it.next().get("plz").split(",")).contains(plz)) {
				return Optional.of(new Coord(it.next().get("lon"), it.next().get("lat")));
			}
		}

		return Optional.empty();
	}
}