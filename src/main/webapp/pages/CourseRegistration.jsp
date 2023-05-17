<!-- 
Description: This JSP file allows users to register for available courses.
Author: Mahdi Murshed & Tahsina Bintay Azam
Date: 2023-05-09
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ page import="java.sql.*" %>
  <%
    if(session.getAttribute("email")==null){
      response.sendRedirect("landing.jsp");
    }
    if(session.getAttribute("role").equals("admin")){
      response.sendRedirect("CourseAssign.jsp");
    }
    if(session.getAttribute("role").equals("teacher")){
      response.sendRedirect("TeacherCourses.jsp");
    }
  %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>Register Course</title>
      <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-gradient-to-r from-gray-700 via-gray-900 to-black text-white">
      <% 
      try 
      { Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
      String email = (String)session.getAttribute("email");
      String sql="SELECT course_name, course_code FROM courses WHERE course_code NOT IN (SELECT student_courses.course_code FROM student_courses LEFT JOIN courses ON student_courses.course_code = courses.course_code WHERE email= ?) ;" ;
      PreparedStatement stmt=con.prepareStatement(sql);
      stmt.setString(1,email);
      ResultSet rs=stmt.executeQuery();
      if(rs.next()==false) 
        { out.println("No Records in the table");
        }else
        {%>
      <jsp:include page="components/Navbar.jsp" />
      <form action="register-courses" method="post">
        <div class="flex w-2/3 justify-between mx-auto my-6">
          <h2 class="text-2xl text-center text-white my-2 font-bold">Register Courses</h2>
          <button type="submit" class="px-6 py-2 text-gray-900 bg-cyan-400 rounded-lg transition-all hover:scale-105">
            Submit
          </button>
        </div>
        <div class="flex justify-center">
        <table class="w-2/3 text-left text-white dark:text-gray-400 backdrop-blur-xl bg-gray-700/30 rounded-xl">
          <thead class="text-lg uppercase">
            <tr>
              <th scope="col" class="px-6 py-3"></th>
              <th scope="col" class="px-6 py-3">
                Course code
              </th>
              <th scope="col" class="px-6 py-3">
                Course Name
              </th>
            </tr>
          </thead>
          <tbody>
            <% do {%>
              <tr class="hover:bg-gray-700">
                <td class="px-6 py-4">
                  <input class="form-checkbox h-5 w-5 text-gray-600 rounded-xl" type="checkbox" name="courses" value="<%=rs.getString(2)%>">
                </td>
                <td class="px-6 py-4">
                  <input disabled class="bg-transparent text-white" name="course_code" value="<%=rs.getString(2)%>" />
                </td>
                <td class="px-6 py-4">
                  <input disabled class="bg-transparent text-white" name="course_name" value="<%=rs.getString(1)%>" />
                  <!-- <%= rs.getString(2)%> -->
                </td>
              </tr>
              <%}while(rs.next());
            }
          } catch(Exception e)
          { 
            System.out.println(e.getMessage());
            e.getStackTrace();
          }
          %>
        </tbody>
      </table>
    </div>
  </form>
    </body>

    </html>