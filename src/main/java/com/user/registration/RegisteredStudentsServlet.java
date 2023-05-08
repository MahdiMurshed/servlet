package com.user.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisteredStudentsServlet
 */
@WebServlet("/RegisteredStudentsServlet")
public class RegisteredStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		 String classCode = request.getParameter("courseCode");  
//		 request.setAttribute(classCode, classCode);
//		 RequestDispatcher view = null;
//		 view=request.getRequestDispatcher("/pages/RegisteredStudents.jsp?courseCode=" + classCode);
//		 view.forward(request, response);
		// TODO Auto-generated method stub
				 String classCode = request.getParameter("courseCode");  
				 request.setAttribute(classCode, classCode);
				 RequestDispatcher view = null;
				 view=request.getRequestDispatcher("/pages/RegisteredStudents.jsp?courseCode=" + classCode);
				 view.forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
