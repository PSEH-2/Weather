package com.weather.WeatherReport.Model;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherEntry implements Serializable {

	private static final long serialVersionUID = 4083090887773582329L;

	private Instant timestamp;

	private double minTemparature;

	private double maxTemparature;

	private Boolean rain;

	private String message;
	private Map<String, Object> main;

	@JsonSetter("dt")
	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);

	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		this.main = main;

		setMinTemparature(Double.parseDouble(main.get("temp_min").toString()));
		setMaxTemparature(Double.parseDouble(main.get("temp_max").toString()));

	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);

		String rainDec = weather.get("description").toString();
		System.out.println(rainDec);
		if (rainDec != null && rainDec.length() > 0) {
			if ("few clouds".equals(rainDec.trim()) || "light rain".equals(rainDec.trim())
					|| "moderate rain".equals(rainDec.trim()))
				setMessage("Carry umbrella");
		}

	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public double getMinTemparature() {
		return minTemparature;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMinTemparature(double minTemparature) {
		this.minTemparature = minTemparature;
	}

	public double getMaxTemparature() {
		return maxTemparature;
	}

	public void setMaxTemparature(double maxTemparature) {
		this.maxTemparature = maxTemparature;
	}

}