package de.predic8.cloud;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
public class Coord {
	private String lat;
	private String lon;

	public Coord(String lon, String lat) {
		this.lon = lon;
		this.lat = lat;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}
}