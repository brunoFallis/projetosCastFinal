package br.com.cast.climinha.dto;

public class ResultWeatherDTO {

	private String data;
	private String pressao;
	private String tempMin;
	private String tempMax;
	private String umidade;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getTempMin() {
		return tempMin;
	}

	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}

	public String getTempMax() {
		return tempMax;
	}

	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

}
