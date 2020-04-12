package dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Foods;

public class FoodsDao {
	
	
	private Connection connection;
	private final String GET_FOODS_QUERY = "SELECT * FROM foods";
	private final String GET_FOOD_BY_ID_QUERY = "SELECT * FROM foods WHERE id = ?";
	private final String CREATE_NEW_FOOD_QUERY = "INSERT INTO foods(name, cuisine) VALUES(?, ?)";
	private final String DELETE_FOOD_BY_ID_QUERY = "DELETE FROM foods WHERE id = ?";
	
	public FoodsDao() {
		connection = DBConnection.getConnection();
		
	}
	
	public List<Foods> displayFoods() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_FOODS_QUERY).executeQuery();
		List<Foods> foods = new ArrayList<Foods>();
		
			while (rs.next()) {
				foods.add(populateFood(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return foods;
	}
	
	
	public Foods getFoodById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_FOOD_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next(); 
		return populateFood(rs.getInt(1), rs.getString(2), rs.getString(3));
	}

	
	public void deleteFoodById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_FOOD_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}
	
	
	public void createNewFood (String name, String cuisine) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FOOD_QUERY);
		ps.setString(1, name);
		ps.setString(2, cuisine);
		ps.executeUpdate();
	}

	
	private Foods populateFood(int id, String name, String cusine) throws SQLException {
		return new Foods(id, name, cusine);
	}
	
}
