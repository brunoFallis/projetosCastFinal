package br.com.cast.climinha.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.climinha.ClimaClient;
import br.com.cast.climinha.dto.ResultWeatherDTO;
import br.com.cast.climinha.dto.WeatherDTO;
import br.com.cast.climinha.dto.WeatherDataDTO;

@Service
public class BusinessClima {

	@Autowired
	private ClimaClient cc;

	public List<ResultWeatherDTO> buscaClimaPorCidade(String cidade) {

		WeatherDTO climas = cc.fetchEvents(cidade);

		List<ResultWeatherDTO> results = new ArrayList<>();

		for (WeatherDataDTO dto : climas.getList()) {
			
			ResultWeatherDTO rwDTO = new ResultWeatherDTO();
			
			rwDTO.setData(dto.getDtTxt());
			rwDTO.setPressao(dto.getMain().getPressure());
			rwDTO.setTempMax(dto.getMain().getTemp_max());
			rwDTO.setTempMin(dto.getMain().getTemp_min());
			rwDTO.setUmidade(dto.getMain().getHumidity());

			results.add(rwDTO);

		}

		return results;

	}

}
