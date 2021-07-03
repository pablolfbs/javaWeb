package model;

import java.io.Serializable;

public class Quarto implements Serializable {

	private static final long serialVersionUID = 8624884126540496990L;

	private int num;

	public Quarto() {
	}

	public Quarto(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		Quarto other = (Quarto) obj;
		
		return num == other.num;
	}

	@Override
	public String toString() {
		return "Quarto [num= " + num + "]";
	}

}
