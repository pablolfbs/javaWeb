package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.CarDAO;
import domain.Anuncio;
import domain.Car;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {

	private final static String[] colors;

	private final static String[] brands;

	static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";

		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagen";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
	}

	private CarDAO db = new CarDAO();

	public List<Car> getListCars() {
		try {
			List<Car> cars = db.getListCars();
			if (cars != null) {
				return cars;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void UpdateCar(Car c) {
		try {
			db.UpdateCar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getColor() {
		// obter do banco de dados cores disponíveis
		return Arrays.asList(colors);
	}

	public List<String> getBrands() {
		// obter do banco de dados brands disponíveis
		return Arrays.asList(brands);
	}

}