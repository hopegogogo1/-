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

import com.dao.StudentDao;
import com.data.StudentData;
import com.model.Student;

@WebServlet(name = "LoginServlet" , urlPatterns = {"/servlet/login.do"})
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		
		String userName = request.getParameter( "userName" );
		String password = request.getParameter( "password" );
		String rememberMe = request.getParameter( "rememberMe" );

		String message = "";
		String location = request.getContextPath() + "/login.jsp";

		Cookie userNameCookie = new Cookie( "userName", "" );
		Cookie passwordCookie = new Cookie( "password", "" );

		userNameCookie.setMaxAge( 0 );
		passwordCookie.setMaxAge( 0 );
		
		userNameCookie.setPath( request.getContextPath() );
		passwordCookie.setPath( request.getContextPath() );

		if( "zhangsan".equals( userName )){
			if( "123456".equals( password ) ){
				if( "rememberMe".equals( rememberMe ) ){
					userNameCookie.setValue( userName );
					passwordCookie.setValue( password );
					// userNameCookie = new Cookie( "userName", userName );
					// passwordCookie = new Cookie( "password", password );
					userNameCookie.setMaxAge( 60*60 );
					passwordCookie.setMaxAge( 60*60 );
				}
				session.setAttribute( "user" , userName );
				message = "登录成功！";
				
				response.addCookie( userNameCookie );
				response.addCookie( passwordCookie );
				response.sendRedirect( request.getContextPath() +  "/index.jsp" );
				return ;
			}
			else{
				message = "用户名或密码错误！";
			}
		}
		else{
			message = "找不到该用户！";
			
		}
		response.addCookie( userNameCookie );
		response.addCookie( passwordCookie );

		request.setAttribute( "message", message );
		request.setAttribute( "location", location );
		request.getRequestDispatcher( "/error.jsp" )
			.forward( request , response );
	}
}
