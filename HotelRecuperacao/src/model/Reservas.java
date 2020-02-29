package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name = "reservas")
public class Reservas {

	@Id
	@Column(name = "idReserva")
	private Integer id;
	@ManyToMany
	@JoinTable(name = "reservaQuarto",
			joinColumns = @JoinColumn(name =  "idQuarto"),
			inverseJoinColumns = @JoinColumn(name = "idReserva"))
	private List<Quarto> quarto;	
	
//	private Quarto quarto;
	@OneToOne
	@JoinColumn(name = "idHospede")
	private Hospede hospede;
	@Column
	private Date dataSaida;
	@Column
	private Date dataEntrada;
	@GeneratedValue
	
	
	public List<Quarto> getQuarto() {
		return quarto;
	}
	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
