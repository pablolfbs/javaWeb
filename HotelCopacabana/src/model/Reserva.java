package model;

import java.util.ArrayList;

public class Reserva {

	private ArrayList<Reserva> reserva;
	
	private Quarto quarto;
	
	private Hospede hospede;

	public ArrayList<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(ArrayList<Reserva> reserva) {
		this.reserva = reserva;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

}
