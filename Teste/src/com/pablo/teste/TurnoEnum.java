package com.pablo.teste;

public enum TurnoEnum {
	
	MANHA("manhã"),
	TARDE("tarde"),
	NOITE("noite");

	private String descricao;
	
	TurnoEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() { 
		return descricao;
	}

}
