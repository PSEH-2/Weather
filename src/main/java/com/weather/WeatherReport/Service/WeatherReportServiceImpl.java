package com.weather.WeatherReport.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.weather.WeatherReport.Model.WeatherForecast;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Value("${url}")
	private String url;
	@Value("${appid}")
	private String appId;
	
	@Autowired
	private RestTemplate restTempalte;
	
	@Bean
	public RestTemplate getRestTemplate() {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	
	@Cacheable("forecast")
	public WeatherForecast getWeatherForecast(String country, String city) {
		StringBuffer str=new StringBuffer(url);
		str.append("?q="+city+","+country+"&appid="+appId);
		System.out.println(str.toString());
		URI url = new UriTemplate(str.toString()).expand(city, country, this.appId);
		return invoke(url, WeatherForecast.class);
	}

	private <T> T invoke(URI url, Class<T> responseType) {
		RequestEntity<?> request = RequestEntity.get(url)
				.accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<T> exchange = this.restTempalte.exchange(request, responseType);
		return exchange.getBody();
	}
	
	

}
