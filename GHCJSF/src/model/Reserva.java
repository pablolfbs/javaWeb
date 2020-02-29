package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue
	@Column(name="id_reserva")
	private Integer id;
	@OneToOne
	@JoinColumn(name="id_hospede")
	private Hospede hospede;
	@OneToOne
	@JoinColumn(name="quarto_num")
	private Quarto quarto;
	@Column
	private String dtEntrada;
	@Column
	private String dtSaida;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public String getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public String getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}
	
}
