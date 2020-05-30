package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva implements Serializable {

	private static final long serialVersionUID = -2316524651754740385L;

	private int id;
	private Integer quarto;
	private Date dtEntrada;
	private Date dtSaida;
	
	private Hospede hospede;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospede == null) ? 0 : hospede.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (hospede == null) {
			if (other.hospede != null)
				return false;
		} else if (!hospede.equals(other.hospede))
			return false;
		return true;
	}

	/*
	 * SimpleDateFormat está estático por causa da conversão para JSON. Probably
	 * because Gson uses DecimalFormat to format numeric type data.
	 */
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public String getDtEntradaFormatada() {
		return sdf.format(getDtEntrada());
	}
	
	public String getDtSaidaFormatada() {
		return sdf.format(getDtSaida());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

}
