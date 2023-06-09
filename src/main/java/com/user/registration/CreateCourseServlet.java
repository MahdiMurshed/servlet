package com.user.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class CreateCourseServlet
 * Creates new courses in the database
 */
@WebServlet("/create-course")
public class CreateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CreateCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * sests the view
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=request.getRequestDispatcher("/pages/CreateCourse.jsp");
		view.forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * gets course details and pushes it into the database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        String course_name = request.getParameter("course_name");
        String course_code = request.getParameter("course_code");
        String course_credit = request.getParameter("credit");
        String course_semester = request.getParameter("semester");
        RequestDispatcher dispatcher = null;
        Connection con = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
        	PreparedStatement pst = con.prepareStatement("insert into courses(course_name,course_code,course_credit,course_semester) values(?,?,?,?)");
        	pst.setString(1, course_name);
        	pst.setString(2, course_code);
        	pst.setString(3, course_credit);
        	pst.setString(4, course_semester);
        	int rowCount = pst.executeUpdate();
        	dispatcher = request.getRequestDispatcher("/pages/CreateCourse.jsp");
        	if(rowCount > 0) {
        		request.setAttribute("status", "success");
        		dispatcher.forward(request, response);
        	}else {
        		request.setAttribute("status", "failed");
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
        	try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}

}