package com.user.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CourseRegistrationServlet
 */

@WebServlet("/register-courses")
public class CourseRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	        RequestDispatcher view = null;
	        Connection con = null;
	        List<User> userList = new ArrayList<>();
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
	        	PreparedStatement pst = con.prepareStatement("select name,email from users where role='student';");
	        	ResultSet rowCount = pst.executeQuery();
	        	while (rowCount.next()) {
	        	    String name = rowCount.getString("name");
	        	    String email = rowCount.getString("email");
	        	    User user = new User(name, email);
	        	    userList.add(user);
	        	}
	           request.setAttribute("userList", userList);
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
		view=request.getRequestDispatcher("/pages/CourseRegistration.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        //TODO: Get the logged in user's email
        String user_email = (String) request.getSession().getAttribute("email");
        String[] selectedCourses = request.getParameterValues("courses");
        RequestDispatcher dispatcher = null;
        Connection conn = null;
         try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db", "root", "12345678");
            
            // Delete existing courses for the user
            PreparedStatement deleteStatement = conn.prepareStatement("DELETE FROM student_courses WHERE email = ?");
            deleteStatement.setString(1, user_email);
            deleteStatement.executeUpdate();
            
            // Assign new courses for the user
            PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO student_courses (email, course_code) VALUES (?, ?)");
            for (String courseCode : selectedCourses) {
            	System.out.println("Selected courses: " + courseCode);
                insertStatement.setString(1, user_email);
                insertStatement.setString(2, courseCode);
                insertStatement.executeUpdate();
            }
            
            // Close database connection
            conn.close();
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

	}

}
