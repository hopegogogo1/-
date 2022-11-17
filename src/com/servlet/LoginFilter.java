package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.data.StudentData;
import com.model.Student;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"*.do","*.jsp"} )
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req
			, ServletResponse resp
			, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = ( HttpServletRequest ) req;
		HttpServletResponse response = ( HttpServletResponse ) resp;
		
		response.setCharacterEncoding( "utf8" );
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf8");
		
		String path = request.getServletPath();
		if( "/login.jsp".equals( path ) 
				|| "/servlet/login.do".equals( path ) ) {
			chain.doFilter( req, resp );
			return ;
		}
		
		HttpSession session = request.getSession();
		String user = ( String )session.getAttribute( "user" );
		if( user == null || "".equals( user ) ){
			request.setAttribute( "message", "没有访问权限，请先登录！" );
			request.setAttribute( "location", request.getContextPath() +  "/login.jsp" );
			request.getRequestDispatcher( "/error.jsp" )
				.forward( request , response );
			return;
		}
		else {
			chain.doFilter( req, resp );
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	
}
