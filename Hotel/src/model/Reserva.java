package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Reserva implements Serializable {

	private static final long serialVersionUID = -2316524651754740385L;

	private int id;
	private Integer quarto;
	private Date dtEntrada;
	private Date dtSaida;

	private Hospede hospede;

	public Reserva(Integer quarto, Hospede hospede, Date dtEntrada, Date dtSaida) {
		this.quarto = quarto;
		this.hospede = hospede;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
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

}
