package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Makes;

public class MakeDAO {
	

	
	private Connection connection;
	private ModelDAO modelDao;
	private final String GET_MAKES_QUERY = "SELECT * From makes";
	private final String GET_MAKES_BY_ID_QUERY = "SELECT * From makes WHERE make_id = ?";
	private final String CREATE_NEW_MAKE_QUERY = "INSERT INTO makes(make) VALUES(?)";
	private final String DELETE_MAKE_BY_ID_QUERY = "DELETE FROM makes WHERE make_id = ?";
	
	public MakeDAO() {
		connection = DBConnection.getConnection();
		modelDao = new ModelDAO();
	}
	
	public List<Makes> getMakes() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MAKES_QUERY).executeQuery();
		List<Makes> makesList = new ArrayList<Makes>();
		
		while (rs.next()) {
			makesList.add(populateMake(rs.getInt(1), rs.getString(2)));
		}
		return makesList;
			
	}
	
	public Makes getMakesById(int make_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_MAKES_BY_ID_QUERY);
		ps.setInt(1, make_id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateMake(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewMake(String MakeName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MAKE_QUERY);
		ps.setString(1, MakeName);
		ps.executeUpdate();
	}
	
	public void deleteMakeById(int make_id) throws SQLException {
		modelDao.deleteModelsByMakeId(make_id);
		PreparedStatement ps = connection.prepareStatement(DELETE_MAKE_BY_ID_QUERY);
		ps.setInt(1, make_id);
		ps.executeUpdate();
	}
	
	private Makes populateMake(int make_id, String make) throws SQLException {
		return new Makes(make_id, make, modelDao.getModelsByMakeId(make_id));
	}
}
