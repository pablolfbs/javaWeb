package example.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import example.ejb.DataHora;

@Named(value = "controleDataHora")
@RequestScoped
public class ControleDataHora {

	@EJB
	private DataHora time;

	public DataHora getTime() {
		return time;
	}

	public void setTime(DataHora time) {
		this.time = time;
	}
	
}
