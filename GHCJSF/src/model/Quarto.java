package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="quarto")
public class Quarto {
	
	@Id
	@Column(name="quarto_num")
	private Integer num;

	public Quarto() {
	}

	public Quarto(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}
