<!-- 
Description: This JSP file allows admin to assign courses to teachers.
Author: Mahdi Murshed & Tahsina Bintay Azam
Date: 2023-05-09
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" %>
<%
if(!session.getAttribute("role").equals("admin")){
response.sendRedirect("landing.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Course</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gradient-to-r from-gray-700 via-gray-900 to-black">
<%
try
{ Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
String sql="select course_name,course_code from courses;" ;
String joined = "SELECT c.course_code, c.course_name, u.name FROM courses c LEFT JOIN user_courses uc ON c.course_code = uc.course_code LEFT JOIN users u ON u.email = uc.email;";
PreparedStatement stmt=con.prepareStatement(joined);
ResultSet rs=stmt.executeQuery();
String sqlt="select name,email from users where role='teacher';" ;
PreparedStatement stlt=con.prepareStatement(sqlt);
ResultSet rt=stlt.executeQuery();
if(rs.next()==false)
{ out.println("No Records in the table");
} else if(rt.next()==false){
	out.println("No Records in the table");
}else
{%>
<jsp:include page="components/Navbar.jsp" />
<h2 class="text-2xl text-center text-white my-2 font-bold">Assign Course</h2>
<div class="flex justify-center">
<table class="w-2/3 text-left text-white dark:text-gray-400 bg-gray-800 rounded-xl">
<thead class="text-lg uppercase">
<tr>
<th scope="col" class="px-6 py-3">
Course code
</th>
<th scope="col" class="px-6 py-3">
Course Name
</th>
<th scope="col" class="px-6 py-3">
Assigned Teacher
</th>
<th scope="col" class="px-6 py-3">
Assign Teacher
</th>
</tr>
</thead>
<tbody>
<% do {%>
<form action="assign" method="post">
<tr class="hover:bg-gray-700">
<td class="px-6 py-4">
<input disabled class="bg-transparent text-white" name="course_code" value="<%=rs.getString(1)%>" />
</td>
<td class="px-6 py-4">
<input disabled class="bg-transparent text-white" name="course_name" value="<%=rs.getString(2)%>" />
<!-- <%= rs.getString(2)%> -->
</td>
<td class="px-6 py-4">
<input disabled class="bg-transparent text-white" name="course_teacher" value="<%=rs.getString(3)%>" />
</td>
<td class="px-6 py-4">
<input type="hidden" class="bg-transparent text-white" name="course_code" value="<%=rs.getString(1)%>" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="user_email" id="user" onchange="this.form.submit()" class="bg-gray-50 border border-blue-400 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 bg-gray-800 border-blue-400 text-white">
<option selected>Select a teacher</option>
<c:forEach items="${userList}" var="user">
<option value="${user.email}">${user.name}</option>
</c:forEach>
</select>
</td>
</tr>
</form>
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
