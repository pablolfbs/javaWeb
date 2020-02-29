package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserDAO extends BaseDAO {
	
	public User getUser(String user_id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn= getConnection();
			stmt = conn.prepareStatement("select * from User where user_cpf=?");
			stmt.setString(1, user_id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				User u = createUser(rs);
				rs.close();
				return u;
			}
			rs.close();
		}finally{
			if(stmt !=null){
				stmt.close();
			}
			if(conn !=null){
				conn.close();
			}			
		}
		return null;
	}

	public User createUser(ResultSet rs) throws SQLException{
		User u = new User();
		u.setCpf(rs.getString("user_cpf"));
		u.setPassword(rs.getString("user_password"));
		u.setName(rs.getString("user_name"));
		u.setType(rs.getString("user_type"));
		u.setEmail(rs.getString("user_email"));
		u.setBirthdate(rs.getString("user_birthdate"));
		u.setState(rs.getString("user_state"));
		
		return u;
	} 
	
	public List<User> getUserAutentication(String user_id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		List<User> users = new ArrayList<>();
		try{
			conn=getConnection();
			stmt = conn.prepareStatement("select * from User where user_cpf=?");
			stmt.setString(1, user_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				User u = createUser(rs);
				users.add(u);				
			}
			rs.close();
		}finally{
			if(stmt !=null){
				stmt.close();
			}
			if(conn !=null){
				conn.close();
			}			
		}
		return users;
	}
}