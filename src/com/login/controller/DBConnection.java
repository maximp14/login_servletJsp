package com.login.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	    private final static String login = "root";
	    private final static String password = "password123";
	    private final static String url = "jdbc:mysql://localhost:3306/servlet_jsp";
	    private static DBConnection instance = null;
	    private Connection connection = null;

	    private DBConnection() throws ClassNotFoundException{
	        if(connection == null){
	            try {
	            	Class.forName("com.mysql.jdbc.Driver");
	                connection = DriverManager.getConnection(url, login, password);
	                if(connection != null){
	                    System.out.println("Connection OK");
	                }
	            } catch (SQLException e) {
	                System.out.println(e);
	            }
	        }
	    }

	    public static DBConnection getInstance(){
	        if(instance == null){
	            try {
					instance = new DBConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return instance;
	    }


	    public Connection getConnection() {
	        return connection;
	    }

	    public void closeConnection(){
	        instance = null;
	    }

}
