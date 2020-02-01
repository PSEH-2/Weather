package com.weather.WeatherReport.Service;

import com.weather.WeatherReport.Model.WeatherForecast;

public interface WeatherReportService {
	public WeatherForecast getWeatherForecast(String country,String city);
}
