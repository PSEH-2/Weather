package com.weather.WeatherReport.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.WeatherReport.Model.WeatherForecast;
import com.weather.WeatherReport.Service.WeatherReportService;

@RestController
@RequestMapping("/api/weather")
public class WeatherReportController {

	@Autowired
	private WeatherReportService weatherReportService;

	@RequestMapping("now/{country}/{city}")
	public ResponseEntity<WeatherForecast> getWeather(@PathVariable String country, @PathVariable String city) {

		WeatherForecast weatherForecast = weatherReportService.getWeatherForecast(country, city);

		return new ResponseEntity<WeatherForecast>(weatherForecast, HttpStatus.OK);

	}

}
