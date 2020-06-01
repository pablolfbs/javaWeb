package model.enumerador;

public enum QuartoEnum {
	
	UM(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10);

	
	private Integer num;
	
	QuartoEnum(Integer num) {
		this.num = num;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
}
