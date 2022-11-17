package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(name = "StudentServlet" , urlPatterns = {"/servlet/student.do"})
public class StudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		doPost( request , response );

	}

	@Override
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		PrintWriter out = response.getWriter();

		StudentDao stdDao = new StudentDao();

		String action = request.getParameter( "action" );

		if( "list".equals( action )) {
			List<Object> stdList = stdDao.findAll();
			request.setAttribute( "stdList", stdList );
			request.getRequestDispatcher( "/student/studentList.jsp" )
				.forward( request, response ) ;
		}
		else if( "del".equals( action ) ){
			String idStr = request.getParameter( "id" );
			if( idStr != null ){
				long id = Long.parseLong( idStr );
				Student std = ( Student ) stdDao.findById( id );

				if( std != null ){
					int f = stdDao.delete( std );
					if( f == 1 ) {
						out.println( "<script type='text/javascript'>" );
						out.println( "alert('删除完成！')" );
						out.println( "window.opener.location.reload()" );
						out.println( "window.close()" );
						out.println( "</script>" );
						return;
					}else {
						out.println( "<script type='text/javascript'>" );
						out.println( "alert('删除失败！')" );
						out.println( "window.opener.location.reload()" );
						out.println( "window.close()" );
						out.println( "</script>" );
					}
				}else {
					out.println( "<script type='text/javascript'>" );
					out.println( "alert('未找到相关学生信息！')" );
					out.println( "window.opener.location.reload()" );
					out.println( "window.close()" );
					out.println( "</script>" );
					return;
				}


			}
			out.println( "<script type='text/javascript'>" );
			out.println( "alert('参数错误！')" );
			out.println( "window.opener.location.reload()" );
			out.println( "window.close()" );
			out.println( "</script>" );
			return;
		}
		else if( "modify".equals( action ) ){

			String idStr = request.getParameter( "id" );
			Long id = Long.parseLong( idStr );
			Student std = ( Student ) stdDao.findById( id );
			if( std == null ) {
				out.println( "<script type='text/javascript'>" );
				out.println( "alert('未找到相关学生信息！')" );
				out.println( "window.opener.location.reload()" );
				out.println( "window.close()" );
				out.println( "</script>" );
				return;
			}
			else {
				String number = request.getParameter( "number" );
				String name = request.getParameter( "name" );
				String sex = request.getParameter( "sex" );
				String department = request.getParameter( "department" );
				String specialty = request.getParameter("specialty");
				String [] likeArr = request.getParameterValues( "like" );
				List<String> likeList = new ArrayList();
				if( likeArr != null && likeArr.length > 0 ){
					for( int i=0; i<likeArr.length; i++ ){
						likeList.add( likeArr[i] );
					}
				}

				std.setName( name );
				std.setNumber( number );
				std.setDepartment( department );
				std.setSpecialty(specialty);
				std.setSex( sex );
				std.setLike( likeList );
				if( "男".equals( sex )){
					String img = Math.random() > 0.5 ? "/img/9901.png" : "/img/9903.png";
					std.setImage( img );
				}
				else{
					String img = Math.random() > 0.5 ? "/img/9902.png" : "/img/9904.png";
					std.setImage( img );
				}

				stdDao.update( std );

				out.println( "<script type='text/javascript'>" );
				out.println( "alert('修改完成！')" );
				out.println( "window.opener.location.reload()" );
				out.println( "window.close()" );
				out.println( "</script>" );

			}

		}
		else if ( "add".equals( action ) ){
			String number = request.getParameter( "number" );
			String name = request.getParameter( "name" );
			String sex = request.getParameter( "sex" );
			String department = request.getParameter( "department" );
			String specialty = request.getParameter("specialty");
			String [] likeArr = request.getParameterValues( "like" );
			List<String> likeList = new ArrayList();
			if( likeArr != null && likeArr.length > 0 ){
				for( int i=0; i<likeArr.length; i++ ){
					likeList.add( likeArr[i] );
				}
			}

			Student std = new Student();
			std.setId( Student.getMaxId() );
			std.setName( name );
			std.setNumber( number );
			std.setDepartment( department );
			std.setSpecialty(specialty);
			std.setSex( sex );
			std.setLike( likeList );
			if( "男".equals( sex )){
				String img = Math.random() > 0.5 ? "/img/9901.png" : "/img/9903.png";
				std.setImage( img );
			}
			else{
				String img = Math.random() > 0.5 ? "/img/9902.png" : "/img/9904.png";
				std.setImage( img );
			}

			stdDao.insert( std );


			out.println( "<script type='text/javascript'>" );
			out.println( "alert('增加完成！')" );
			out.println( "window.opener.location.reload()" );
			out.println( "window.close()" );
			out.println( "</script>" );
		}

	}
}
