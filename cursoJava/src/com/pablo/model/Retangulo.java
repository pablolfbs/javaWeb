package com.pablo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Retangulo {

	private double width;
	private double height;

	public double area() {
		return width * height;
	}

	public double perimeter() {
		return width * 2 + height * 2;
	}

	public double diagonal() {
		return Math.sqrt((width * width) + (height * height));
	}

}
