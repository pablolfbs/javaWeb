package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "quartos")
public class Quarto {
	
	@Id
	@Column(name = "idQuarto")
	@GeneratedValue
	private Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	


}
