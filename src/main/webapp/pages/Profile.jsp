<%
   if(session.getAttribute("email")==null){
	   response.sendRedirect("landing.jsp");
   }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Profile</title>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body class="bg-gradient-to-r from-gray-700 via-gray-900 to-black text-white">
    <jsp:include page="components/Navbar.jsp" />
    <p>Welcome this is profile page</p>
  </body>
</html>
