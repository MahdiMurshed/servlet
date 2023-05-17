<!-- 
Description: This JSP file contains profile elements of users.
Author: Mahdi Murshed & Tahsina Bintay Azam
Date: 2023-05-09
-->
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
   <section class="py-20 h-[80vh] flex justify-center items-center">
      <div class="container mx-auto px-4">
        <h1 class="text-5xl font-bold mb-8">Welcome to your profile!</h1>
        <p class="text-lg mb-8">Discover what you can do with this website! :)</p>
      </div>
    </section>
    
  </body>
</html>
