package com.login.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.controller.DBConnection;
import com.login.model.Book;

public class BookDAOImp implements BookDAO{
	
	final String CREATE = "INSERT INTO books (boo_name, boo_author) VALUES (?,?)";
	final String DELETE = "DELETE FROM books WHERE boo_id = ?";
	final String UPDATE = "UPDATE books SET boo_name = ?, boo_author = ? WHERE boo_id = ?";
	final String GET_ALL = "SELECT boo_id, boo_name, boo_author FROM books ";
	final String FIND_ONE = "SELECT * FROM books WHERE boo_id = ?";
	
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
			System.out.println("Create book error");  /// need to implement daoexception
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
				bookList.add(new Book(resultSet.getInt("boo_id"),resultSet.getString("boo_name"), resultSet.getString("boo_author")));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
        return bookList;
	}
	
	public Book findOne(Integer id){
		PreparedStatement preparedStatement;
        ResultSet resultSet;
        Book book = null;        
        
        try {
			preparedStatement = connection.getConnection().prepareStatement(FIND_ONE);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();			
			if(resultSet.next()) {
				book = new Book(resultSet.getInt("boo_id"), resultSet.getString("boo_name"),resultSet.getString("boo_author"));
			}else {
				System.out.println("Book not found");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.closeConnection();
		}
		return book;
	}
	
	// I have to see why the initial query is not working like the others
	public void update(Book book) {
		PreparedStatement preparedStatement;	
		try {
			String sql = "UPDATE books SET boo_name = '"+book.getBookName()+"', "
					+ "boo_author = '"+book.getBookAuthor()+"' where boo_id="+book.getId(); // this query works just fine
			preparedStatement = connection.getConnection().prepareStatement(sql);					
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
		
	}
	
	public void delete(Integer id) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = connection.getConnection().prepareStatement(DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.closeConnection();
		}
	}

	

	

}
