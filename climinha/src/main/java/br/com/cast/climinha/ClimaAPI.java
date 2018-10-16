package br.com.cast.climinha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.climinha.business.BusinessClima;
import br.com.cast.climinha.dto.ResultWeatherDTO;

@RestController
@RequestMapping(path="/clima")
public class ClimaAPI {

	@Autowired
	private BusinessClima bc;
	
	@GetMapping("/{cidade}")
	public List<ResultWeatherDTO> retornaClima(@PathVariable("cidade") String cidade) {
		return bc.buscaClimaPorCidade(cidade);
	}
	
}
