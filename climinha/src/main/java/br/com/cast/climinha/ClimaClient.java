package br.com.cast.climinha;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.climinha.dto.WeatherDTO;

@Component
public class ClimaClient {

	private static final String EVENT_WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},"

			+ "br&units=metric&mode=json&appid={appid}&lang=pt";

	private static final String ID = "31f812f79352d564bb09619ef42bd33b";

	private final RestTemplate restTemplate;

	public ClimaClient(RestTemplateBuilder builder) {

		this.restTemplate = builder.build();

	}

	public WeatherDTO fetchEvents(String cidade) {
		WeatherDTO dto = this.restTemplate.getForObject(EVENT_WEATHER_URL, WeatherDTO.class, cidade, ID);
		return dto;
	}

}
