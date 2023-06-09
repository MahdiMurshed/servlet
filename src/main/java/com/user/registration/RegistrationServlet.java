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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
       
	/**
	 * @see HttpServlet#doGett(HttpServletRequest request, HttpServletResponse response)
	 * Sets the view of the page
	 * 
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=request.getRequestDispatcher("/pages/Signup.jsp");
		view.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * gets the information from the signup form and creates new users
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String type = request.getParameter("type");
        String password = request.getParameter("password");
        String repeatPass = request.getParameter("re-password");
        RequestDispatcher dispatcher = null;
        Connection con = null;
//        PrintWriter out = response.getWriter();
//        out.print(name);
//        out.print(email);
//        out.print(department);
//        out.print(type);
//        out.print(password);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
        	PreparedStatement pst = con.prepareStatement("insert into users(name,email,password,contact,role,status) values(?,?,?,?,?,?)");
        	pst.setString(1, name);
        	pst.setString(2, email);
        	pst.setString(3, password);
        	pst.setString(4, contact);
        	pst.setString(5, "student");
        	pst.setString(6, "ok");
        	int rowCount = pst.executeUpdate();
        	dispatcher = request.getRequestDispatcher("/pages/Login.jsp");
        	if(rowCount > 0) {
        		request.setAttribute("status", "success");
        	}else {
        		request.setAttribute("status", "failed");
        	}
        	dispatcher.forward(request, response);
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
