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
 * Servlet implementation class CourseAssignServlet
 * This servlet handles assigning courses to teachers.
 * For all the courses we have options to assign them to any teacher.
 */

@WebServlet("/assign")
public class CourseAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseAssignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * sets view to course assign page.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	        RequestDispatcher view = null;
		setUserListToRequest(request);
		view=request.getRequestDispatcher("/pages/CourseAssign.jsp");
		view.forward(request, response);
	}

	/**
	 * populates list of teachers for dropdown
	 * 
	 * @param request
	 * tells us when to set the user list
	 */
	private void setUserListToRequest(HttpServletRequest request) {
		Connection con = null;
		List<User> userList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
			PreparedStatement pst = con.prepareStatement("select name,email from users where role='teacher';");
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
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * sets the course to its assigned teacher
	 * delete if any duplicate
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        String course_code = request.getParameter("course_code");
        String user_email = request.getParameter("user_email");
		setUserListToRequest(request);
		RequestDispatcher dispatcher = null;
        Connection con = null;
        System.out.println(course_code);
        System.out.println(user_email);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
			PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM user_courses WHERE course_code = ?");
            deleteStatement.setString(1, course_code);
            deleteStatement.executeUpdate();
        	PreparedStatement statement = con.prepareStatement("insert into user_courses(email,course_code) values(?,?)");
        	statement.setString(1, user_email);
        	statement.setString(2, course_code);
        	int rowCount = statement.executeUpdate();
        	if(rowCount > 0) {
        		request.setAttribute("status", "success");
        		dispatcher=request.getRequestDispatcher("/pages/CourseAssign.jsp");
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
        dispatcher=request.getRequestDispatcher("/pages/CourseAssign.jsp");
		dispatcher.forward(request, response);

	}

}