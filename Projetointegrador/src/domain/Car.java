package domain;

public class Car {

	private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSoldState() {
		return soldState;
	}

	public void setSoldState(boolean soldState) {
		this.soldState = soldState;
	}

	private int year;
	private String color;
	private String brand;
	private int price;
	private boolean soldState;

}
