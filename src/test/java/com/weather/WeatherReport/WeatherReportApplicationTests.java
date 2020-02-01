package com.weather.WeatherReport;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.weather.WeatherReport.Controller.WeatherReportController;
import com.weather.WeatherReport.Model.Weather;
import com.weather.WeatherReport.Model.WeatherEntry;
import com.weather.WeatherReport.Model.WeatherForecast;
import com.weather.WeatherReport.Service.WeatherReportServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherReportController.class)
class WeatherReportApplicationTests {

	@MockBean
	private WeatherReportServiceImpl weatherService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void weather() throws Exception {
		WeatherForecast weather = new WeatherForecast();
		weather.setName("London");
		
		
//		setWeatherEntry(weather, 286, 800.0, "rain",Instant.ofEpochSecond(1234));
//		given(this.weatherService.getWeatherForecast("uk", "london")).willReturn(weather);
//		this.mvc.perform(get("/api/weather/now/uk/london")).andExpect(status().isOk())
//				.andExpect(jsonPath("$.name", is("London"))).andExpect(jsonPath("$.temperature", is(286.72)))
//				.andExpect(jsonPath("$.temp_max", is(800))).andExpect(jsonPath("$.weatherIcon", is("01d")))
//				.andExpect(jsonPath("$.temp_min", is("1970-01-01T00:20:34Z")));
//		verify(this.weatherService).getWeatherForecast("uk", "london");
	}


	private static void setWeatherEntry(WeatherEntry entry, double temp_min, double temp_max, String raindes,
			Instant timestamp) {
		entry.setMinTemparature(temp_min);
		entry.setMaxTemparature(temp_max);
		entry.setMessage(raindes);
		entry.setTimestamp(timestamp);

	}

}
