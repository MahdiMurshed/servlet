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
        <h1 class="text-5xl font-bold mb-8">Welcome to the Website</h1>
        <p class="text-lg mb-8">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam gravida lacus est, sed tincidunt purus consequat sit amet. Sed at malesuada velit.</p>
      </div>
    </section>
    
  </body>
</html>
