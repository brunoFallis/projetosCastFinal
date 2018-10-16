package br.com.cast.climinha.dto;

import java.util.List;

public class WeatherDTO {

	List<WeatherDataDTO> list;

	public List<WeatherDataDTO> getList() {
		return list;
	}

	public void setList(List<WeatherDataDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "WeatherDTO [list=" + list + "]";
	}

}
