package com.user.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 * Handles user login and setting session values for users
 */
@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * sests the view
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=request.getRequestDispatcher("/pages/Login.jsp");
		view.forward(request, response);
	}
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * gets the input credentials from the users and matches it with the records in database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		//TODO: Save user_email, role in session
		RequestDispatcher dispatcher = null;
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
		 PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
		 pst.setString(1, email);
		 pst.setString(2, password);
		 
		 ResultSet rs = pst.executeQuery();
		 if(rs.next()) {
			 session.setAttribute("email",rs.getString("email"));
			 session.setAttribute("role", rs.getString("role"));
			 dispatcher = request.getRequestDispatcher("/pages/Profile.jsp");
		 }else {
			 request.setAttribute("status", "failed");
			 dispatcher = request.getRequestDispatcher("/pages/Login.jsp");
		 }
		 dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
