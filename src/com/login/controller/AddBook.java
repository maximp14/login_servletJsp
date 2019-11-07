package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.BookDAO;
import com.login.model.Book;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookDAO = new BookDAO();
		
		String id = request.getParameter("id");
		String bookName = request.getParameter("bname");
		String authorName = request.getParameter("bauthor");
		
		
		
		if(!(bookName.isEmpty() && authorName.isEmpty())) {
			Book book = new Book(bookName, authorName);
			bookDAO.create(book);
			response.sendRedirect("welcome.jsp");
		}else {
			Book book = new Book(Integer.parseInt(id), bookName, authorName);
			bookDAO.update(book);
			response.sendRedirect("welcome.jsp");
		}
		
		
	}

}
