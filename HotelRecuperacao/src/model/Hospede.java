package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "hospede")
public class Hospede {
	
	@Id
	@GeneratedValue
	@Column(name = "idHospede")
	private Integer id;
	@Column
	private String nome;
	@Column
	private String cpf;
	@OneToOne(mappedBy="hospede")
	private Reservas reserva;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Reservas getReserva() {
		return reserva;
	}
	public void setReserva(Reservas reserva) {
		this.reserva = reserva;
	}


}
