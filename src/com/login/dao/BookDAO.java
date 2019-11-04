package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.login.controller.DBConnection;
import com.login.model.Book;

public class BookDAO{
	
	final String CREATE = "INSERT INTO books (boo_name, boo_author) VALUES (?,?)";
	final String DELETE = "DELETE FROM books WHERE boo_name = ?";
	final String UPDATE = "UPDATE books SET boo_name = ?, boo_author = ? WHERE boo_name = ?";
	
	private DBConnection connection = DBConnection.getInstance();
	
	public void create(Book book) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(CREATE);
			preparedStatement.setString(1, book.getBookName());
			preparedStatement.setString(2, book.getBookAuthor());
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
	
	public void update(String name, Book book) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(UPDATE);
			preparedStatement.setString(1, book.getBookName());
			preparedStatement.setString(2, book.getBookAuthor());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
		
	}
	
	public void delete(String name) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(DELETE);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
	}

	

}
