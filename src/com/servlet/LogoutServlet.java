package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.data.StudentData;
import com.model.Student;

@WebServlet(name = "LogoutServlet" , urlPatterns = {"/servlet/logout.do"})
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		doPost( request, response );
	}
	
	@Override
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute( "user" );
		session.invalidate();

		response.sendRedirect( request.getContextPath() +  "/login.jsp" );
	}
}
