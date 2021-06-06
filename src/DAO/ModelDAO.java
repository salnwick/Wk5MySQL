package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Models;

public class ModelDAO {
	
	private Connection connection;
	private final String GET_MODELS_BY_MAKE_ID_QUERY= "SELECT * FROM models WHERE make_id = ?";
	private final String DELETE_MODELS_BY_MAKE_ID_QUERY = "Delete From models WHERE make_id = ?";
	
	public ModelDAO() {
		connection = DBConnection.getConnection();
	}

	public List<Models> getModelsByMakeId(int make_id) throws SQLException {
		PreparedStatement ps = connection.prepareCall(GET_MODELS_BY_MAKE_ID_QUERY);
		ps.setInt(1, make_id);
		ResultSet rs = ps.executeQuery();
		List<Models> models = new ArrayList<Models>();
		
		while (rs.next()) {
			models.add(new Models(rs.getInt(1), rs.getString(2)));
				
			}
			
		return models;
	}
	
	public void deleteModelsByMakeId(int makeId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_MODELS_BY_MAKE_ID_QUERY);
		ps.setInt(1, makeId);
		ps.executeUpdate();
	}
	
	
	

}
