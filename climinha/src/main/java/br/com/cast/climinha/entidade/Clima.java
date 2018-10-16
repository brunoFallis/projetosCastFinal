package br.com.cast.climinha.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "clima", schema = "clima")
public class Clima {

	@Id
	@SequenceGenerator(sequenceName = "clima_id_seq", schema = "clima", allocationSize = 1, name = "clima_sequence")
	@GeneratedValue(generator = "clima_sequence", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String pressao;
	private String tempmax;
	private String tempmin;
	private Date data;
	private String umidade;
	private String cidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getTempmax() {
		return tempmax;
	}

	public void setTempmax(String tempmax) {
		this.tempmax = tempmax;
	}

	public String getTempmin() {
		return tempmin;
	}

	public void setTempmin(String tempmin) {
		this.tempmin = tempmin;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
