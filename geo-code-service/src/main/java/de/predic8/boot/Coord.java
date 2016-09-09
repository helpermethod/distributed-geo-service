package de.predic8.boot;

/**
 * @author Oliver Weiler (weiler@predic8.de)
 */
public class Coord {
	private String lat;
	private String lon;

	private Coord() {
	}

	public Coord(String lat, String lon) {
		this.lat = lat;
		this.lon = lon;
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