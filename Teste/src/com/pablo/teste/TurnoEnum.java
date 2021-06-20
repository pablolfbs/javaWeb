package com.pablo.teste;

public enum TurnoEnum {
	
	MANHA("manh�"),
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
