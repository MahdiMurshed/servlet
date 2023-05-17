<!-- 
Description: This JSP file allows teachers to view courses assigned to them.
Author: Mahdi Murshed & Tahsina Bintay Azam
Date: 2023-05-09
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@ page import="java.sql.*" %>
  <%
   if(!session.getAttribute("role").equals("teacher")){
     response.sendRedirect("landing.jsp");
   }
  %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="ISO-8859-1">
      <title>My Courses</title>
      <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-gradient-to-r from-gray-700 via-gray-900 to-black">
      <% 
      try 
      { Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
      String sql="select course_name,course_code from courses;" ;
      String email = (String)session.getAttribute("email");
      String joined = "SELECT course_name, courses.course_code, course_credit, course_semester FROM user_courses LEFT JOIN courses ON user_courses.course_code = courses.course_code WHERE email= ? ;";
      PreparedStatement stmt=con.prepareStatement(joined);
      stmt.setString(1,email);
      ResultSet rs=stmt.executeQuery();
      String sqlt="select name,email from users where role='student';" ;
      PreparedStatement stlt=con.prepareStatement(sqlt);
      ResultSet rt=stlt.executeQuery();
      if(rs.next()==false) 
        { out.println("No Records in the table");
        } else if(rt.next()==false){
        	out.println("No Records in the table");
        }else
        {%>
      <jsp:include page="components/Navbar.jsp" />
      <h2 class="text-2xl text-center text-white my-2 mt-6 font-bold">My Courses</h2>
      <div class="flex justify-center">
        <table class="w-10/12 text-left text-white dark:text-gray-400 bg-gray-800 rounded-xl">
          <thead class="text-lg uppercase">
            <tr>
               <th scope="col" class="px-6 py-3">
                Course Name
              </th>
              <th scope="col" class="px-6 py-3">
                Course Code
              </th>
              <th scope="col" class="px-6 py-3">
                Course Credit
              </th>
              <th scope="col" class="px-6 py-3">
                Course Semester
              </th>
               <th scope="col" class="px-6 py-3">
                Registered Students
              </th>
            </tr>
          </thead>
          <tbody>
            <% do {%>
              <tr class="hover:bg-gray-700">
                <td class="px-6 py-4">
                  <input disabled class="bg-transparent text-white" name="course_code" value="<%=rs.getString(1)%>" />
                </td>
                <td class="px-6 py-4">
                  <input disabled class="bg-transparent text-white" name="course_name" value="<%=rs.getString(2)%>" />
                  <!-- <%= rs.getString(2)%> -->
                </td>
                  <td class="px-6 py-4">
                  <input disabled class="bg-transparent text-white" name="course_credit" value="<%=rs.getString(3)%>" />
                </td>
                <td class="px-6 py-4">
                 <input disabled class="bg-transparent text-white" name="course_semester" value="<%=rs.getString(4)%>" />
                </td>
                 <td class="px-6 py-4">
                 <a href="/Servlet-Project/registered-students?courseCode=<%=rs.getString(2)%>" class="">
                      <button type="submit" class="w-full px-2 py-2 mt-4 rounded-lg text-sm font-semibold text-gray-900 bg-cyan-400 transition-all hover:scale-105">See Students</button>
                   </a>
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
    </body>

    </html>