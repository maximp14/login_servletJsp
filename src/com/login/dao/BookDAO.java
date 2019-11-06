package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.controller.DBConnection;
import com.login.model.Book;

public class BookDAO{
	
	final String CREATE = "INSERT INTO books (boo_name, boo_author) VALUES (?,?)";
	final String DELETE = "DELETE FROM books WHERE boo_name = ?";
	final String UPDATE = "UPDATE books SET boo_name = ?, boo_author = ? WHERE boo_name = ?";
	final String GET_ALL = "SELECT boo_name, boo_author FROM books ";
	final String FIND_ONE = "SELECT boo_name, boo_author WHERE boo_name = ?";
	
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
			System.out.println("Create book error");
		}finally {
			connection.closeConnection();
		}
	}
	
	public List<Book> findAll(){
		PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<Book> bookList = new ArrayList();
        
        try {
			preparedStatement = connection.getConnection().prepareStatement(GET_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				bookList.add(new Book(resultSet.getString("boo_name"), resultSet.getString("boo_author")));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
        return bookList;
	}
	
	public Book findOne(String name) {
		PreparedStatement preparedStatement;
        ResultSet resultSet;
        Book book = null;
        
        try {
			preparedStatement = connection.getConnection().prepareStatement(FIND_ONE);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				book = new Book(resultSet.getString("boo_name"),resultSet.getString("boo_author"));
			}
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.closeConnection();
		}
		return book;
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
