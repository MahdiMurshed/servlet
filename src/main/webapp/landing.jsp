<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Welcome to MyApp</title>
   <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body class="bg-gradient-to-r from-gray-700 via-gray-900 to-black text-white">
   <section class="py-20 h-[80vh] flex justify-center items-center">
      <div class="container mx-auto px-4">
        <h1 class="text-5xl font-bold mb-8">CourseMania</h1>
        <p class="text-lg mb-8">Our website is designed to manage courses for students and teachers. They both can manage their courses and necessary information related to it easily on our website. Keep Track of your courses for better management!</p> 
         <div id="mobile-menu-2">
                <ul class="flex flex-col mt-4 font-medium lg:flex-row lg:space-x-8 lg:mt-0">
                <li>
                            <a href="/Servlet-Project/signup"
                                class="block py-2 pr-4 pl-3 text-white border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-primary-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Sign Up</a>
                        </li>
                        <li>
                            <a href="/Servlet-Project/login"
                                class="block py-2 pr-4 pl-3 text-white border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-primary-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Log
                                In</a>
                        </li>
                </ul>
                </div>
      </div>
      
    </section>
    
  </body>
</html>