package com.login.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.BookDAOImp;
import com.login.model.Book;


@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private BookDAOImp bookDAO = new BookDAOImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
		
        if(action == null) {
        	action = "LIST";
        }
        
        switch(action) {
        
        	case "LIST":
        		listBooks(request, response);
        	break;
        	
        	case "EDIT":
        		editBook(request, response);
        	break;
        	
        	case "DELETE":
        		deleteBook(request, response);
        	break;
        }
        
	}
	

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");		
		bookDAO.delete(Integer.parseInt(id));		
		listBooks(request,response);		
	}

	private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id = request.getParameter("id");
		Book book = bookDAO.findOne(Integer.parseInt(id));		
		request.setAttribute("book", book);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);			
	}

	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> bookList = bookDAO.findAll();
		request.setAttribute("bookList", bookList);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		BookDAOImp bookDAO = new BookDAOImp();
		
		String id = request.getParameter("id");
		String bookName = request.getParameter("bname");
		String authorName = request.getParameter("bauthor");
	
		if(!(id == null)) {			
			Book book = new Book(Integer.parseInt(id), bookName, authorName);			
			bookDAO.update(book);
			response.sendRedirect("welcome.jsp");
		}else {			
			Book book = new Book(bookName, authorName);			
			bookDAO.create(book);
			response.sendRedirect("welcome.jsp");
		}
	}

}
