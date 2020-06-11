package model.enumerador;

public enum QuartoEnum {
	
	UM(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5),
	SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10);
//	ONZE(11), DOZE(12), TREZE(13), QUATORZE(14), QUINZE(15),
//	DEZESSEIS(16), DEZESETE(17), DEZOITO(18), DEZENOVE(19), VINTE(20),
//	VINTEEUM(21), VINTEEDOIS(22), VINTEETRES(23), VINTEEQUATRO(24), VINTEECINCO(25),
//	VINTEESEIS(26), VINTEESETE(27), VINTEEOITO(28), VINTEENOVE(29), TRINTA(30);
	
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
