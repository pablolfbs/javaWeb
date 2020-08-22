package pt.his.vitacare.entidade;

import java.util.Date;

public class Agendamento {

	private Integer id;
	private Date data;
	private String status;
	private Date dtEvento;

	private Professional profissional;
	private Patient paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtEvento() {
		return dtEvento;
	}

	public void setDtEvento(Date dtEvento) {
		this.dtEvento = dtEvento;
	}

	public Professional getProfissional() {
		return profissional;
	}

	public void setProfissional(Professional profissional) {
		this.profissional = profissional;
	}

	public Patient getPaciente() {
		return paciente;
	}

	public void setPaciente(Patient paciente) {
		this.paciente = paciente;
	}

}
