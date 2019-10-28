package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.login.controller.DBConnection;
import com.login.model.User;

public class RegisterDAO {
	
	final String CREATE = "INSERT INTO logins (log_uname, log_password, log_email) VALUES (?,?,?)";
	
	private DBConnection connection = DBConnection.getInstance();
	
	public void create(User user) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(CREATE);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			if(preparedStatement.executeUpdate() == 0 ){
	                System.out.println("Something went wrong");
	        }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
	}

}
