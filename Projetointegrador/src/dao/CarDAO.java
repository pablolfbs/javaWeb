package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.Car;

public class CarDAO extends BaseDAO {

	public List<Car> getListCars() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		List<Car> cars = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from Car");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Car u = createCar(rs);
				cars.add(u);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return cars;
	}

	public void UpdateCar(Car c) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("update car set id=?, year=? where id=?");
			stmt.setString(1, c.getId());
			stmt.setInt(2, c.getYear());
			stmt.setString(3, c.getId());
			stmt.executeUpdate();

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	public Car createCar(ResultSet rs) throws SQLException {
		Car c = new Car();

		c.setId(rs.getString("id"));
		c.setYear(rs.getInt("year"));
		c.setColor(rs.getString("color"));
		c.setBrand(rs.getString("brand"));
		c.setPrice(rs.getInt("price"));
		c.setSoldState(rs.getBoolean("soldState"));
		return c;
	}

}
