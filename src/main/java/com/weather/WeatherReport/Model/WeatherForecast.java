package com.weather.WeatherReport.Model;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherForecast implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7846276466381925037L;

	private String name;

	private List<WeatherEntry> entries = new ArrayList<>();

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("entries")
	public List<WeatherEntry> getEntries() {
		List<WeatherEntry> weather = new ArrayList<WeatherEntry>();

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -3);
		calendar.add(Calendar.DATE, 17);
		for (WeatherEntry weatherEntry : entries) {
			ZonedDateTime zdt = ZonedDateTime.ofInstant(weatherEntry.getTimestamp(), ZoneId.systemDefault());
			Calendar cal1 = GregorianCalendar.from(zdt);
		
			if (cal1.getTime().before(calendar.getTime())) {
				weather.add(weatherEntry);
			}
		}

		return weather;
	}

	@JsonSetter("list")
	public void setEntries(List<WeatherEntry> entries) {
		this.entries = entries;
	}

	@JsonProperty("city")
	public void setCity(Map<String, Object> city) {
		setName(city.get("name").toString());
	}
}