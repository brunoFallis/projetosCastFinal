package br.com.cast.climinha.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.climinha.ClimaClient;
import br.com.cast.climinha.dao.WeatherDAO;
import br.com.cast.climinha.dto.ResultWeatherDTO;
import br.com.cast.climinha.dto.WeatherDTO;
import br.com.cast.climinha.dto.WeatherDataDTO;
import br.com.cast.climinha.entidade.Clima;

@Service
public class BusinessClima {

	@Autowired
	private ClimaClient cc;

	@Autowired
	private WeatherDAO wd;

	@Transactional
	public List<ResultWeatherDTO> buscaClimaPorCidade(String cidade) {
		
		List<Clima> climasCidades = wd.buscaPorCidade(cidade);
		List<String> datas = new ArrayList<>();

		if (climasCidades.isEmpty() || climasCidades.size() < 5) {
			
			wd.deletePorCidade(cidade);
			
			WeatherDTO climas = cc.fetchEvents(cidade);

			for (WeatherDataDTO dto : climas.getList()) {

				String dataTemp = dto.getDtTxt().substring(0, 10);

				if (!datas.contains(dataTemp)) {
					datas.add(dataTemp);
					this.insere(dto, cidade);
				}

			}
			
			climasCidades = wd.buscaPorCidade(cidade);
			
		}

		List<ResultWeatherDTO> results = new ArrayList<>();
		
		for (Clima dto : climasCidades) {

			ResultWeatherDTO rwDTO = new ResultWeatherDTO();

			rwDTO.setData(new SimpleDateFormat("dd/MM/yyyy").format(dto.getData()));
			rwDTO.setPressao(dto.getPressao());
			rwDTO.setTempMax(dto.getTempmax());
			rwDTO.setTempMin(dto.getTempmin());
			rwDTO.setUmidade(dto.getUmidade());
			
			results.add(rwDTO);
			
		}

		return results;

	}

	@Transactional
	public void insere(WeatherDataDTO dto, String cidade) {

		Clima clima = new Clima();

		try {
			clima.setData(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDtTxt()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		clima.setCidade(cidade);
		clima.setPressao(dto.getMain().getPressure());
		clima.setTempmax(dto.getMain().getTemp_max());
		clima.setTempmin(dto.getMain().getTemp_min());
		clima.setUmidade(dto.getMain().getHumidity());

		wd.insere(clima);

	}

}
