package com.webTest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/views/*",loadOnStartup = 1)
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX ="/WEB-INF";
	private static final String SUFFIX =".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(PREFIX+request.getRequestURI()+SUFFIX).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
