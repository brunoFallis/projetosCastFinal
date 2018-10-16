package br.com.cast.climinha.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {

	WeatherMainDTO main;
	List<WeatherDescriptionDTO> weather;
	WeatherWindDTO wind;

	@JsonProperty("dt_txt")
	private String dtTxt;

	public WeatherMainDTO getMain() {
		return main;
	}

	public void setMain(WeatherMainDTO main) {
		this.main = main;
	}

	public List<WeatherDescriptionDTO> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherDescriptionDTO> weather) {
		this.weather = weather;
	}

	public WeatherWindDTO getWind() {
		return wind;
	}

	public void setWind(WeatherWindDTO wind) {
		this.wind = wind;
	}

	public String getDtTxt() {
		return dtTxt;
	}

	public void setDtTxt(String dtTxt) {
		this.dtTxt = dtTxt;
	}

	@Override
	public String toString() {
		return "WeatherDataDTO [main=" + main + ", weather=" + weather + ", wind=" + wind + ", dtTxt=" + dtTxt + "]";
	}

}
