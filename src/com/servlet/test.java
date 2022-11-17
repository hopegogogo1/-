package com.servlet;


import com.dao.StudentDao;
import com.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/analysis/gender","/analysis/likes"})
public class test extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		if("/analysis/gender".equals(servletPath)){
			toGenderAnalysis(request,response);
		}else if("/analysis/likes".equals(servletPath)){
			toLikesAnalysis(request,response);
		}else {
			response.sendRedirect("/error.jsp");
		}

	}



	private void  toGenderAnalysis(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		StudentDao stdDao = new StudentDao();
		int man=0;
		int women=0;
		List<Object> stdList = stdDao.findAll();
		if( stdList != null ) {
			for (Object obj : stdList) {
				Student std = (Student) obj;
				if(std.getSex().equals("男"))
				{
					man+=1;
				}
				else {
					women+=1;
				}
			}
		}
		request.setAttribute("man",man);
		request.setAttribute("women",women);
		request.getRequestDispatcher("/genderAnalysis.jsp").forward(request,response);
	}

	private void toLikesAnalysis(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		StudentDao stdDao=new StudentDao();
		int music=0;
		int sport=0;
		int book=0;
		int study=0;
		List<Object> stdList = stdDao.findAll();
		if( stdList != null ) {
			for (Object obj : stdList) {
				Student std = (Student) obj;
				List<String> likes = std.getLike();
				if(likes!=null){
					for(String like:likes){
						if(like.equals("音乐"))
						{
							music+=1;
						}else if(like.equals("运动")){
							sport+=1;
						}else if(like.equals("读书")){
							book+=1;
						}else if(like.equals("学习")){
							study+=1;
						}
					}
				}

			}
		}
		request.setAttribute("music",music);
		request.setAttribute("sport",sport);
		request.setAttribute("book",book);
		request.setAttribute("study",study);
		request.getRequestDispatcher("/likesAnalysis.jsp").forward(request,response);
		/*response.sendRedirect(request.getContextPath()+"/login.jsp");*/
	}

}


