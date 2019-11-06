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

import com.login.dao.BookDAO;
import com.login.model.Book;


@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private BookDAO bookDAO = new BookDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		//BookDAO bookDAO = new BookDAO();
		/*List<Book> bookList = bookDAO.findAll();	
		if(action.equals("LIST")) {
		request.setAttribute("bookList", bookList);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(request, response);*/
        
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
	

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void editBook(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> bookList = bookDAO.findAll();
		request.setAttribute("bookList", bookList);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
        dispatcher.forward(request, response);
	}
	

}
