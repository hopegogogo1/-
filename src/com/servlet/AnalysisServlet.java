package com.servlet;


import com.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AnalysisServlet" , urlPatterns = {"/servlet/analysis"})
public class AnalysisServlet extends HttpServlet {
	/*@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		if("/analysis/gender".equals(servletPath)){
			toGenderAnalysis(request,response);
		}else {
			System.out.println(1111);
		}

	}

	private  void toGenderAnalysis(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		StudentDao stdDao = new StudentDao();
		int count = stdDao.getCount();
		request.setAttribute( "count", count );

		response.sendRedirect(request.getContextPath() + "/echart.js/index.html");
		*//*request.getRequestDispatcher( "/echarts/index.html" )
				.forward( request, response ) ;*//*
	}*/


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}





}
