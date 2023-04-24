<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <script src="https://cdn.tailwindcss.com"></script>
  </head>

  <body class="bg-gray-900">
    <div class="flex items-center justify-center pt-8">
      <div class="px-8 py-6 mx-4 text-left bg-gray-800 text-white border border-blue-400 shadow-lg rounded-md md:w-1/3 lg:w-1/3 sm:w-1/3">
        <div class="flex justify-center">
          <svg xmlns="http://www.w3.org/2000/svg" class="w-20 h-20 text-blue-600" fill="none" viewBox="0 0 24 24"
            stroke="currentColor">
            <path d="M12 14l9-5-9-5-9 5 9 5z" />
            <path
              d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
              d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
          </svg>
        </div>
        <h3 class="text-2xl  font-bold text-center">Create an Account</h3>
        <form method="post" action="register">
          <div class="mt-4">
            <div>
              <label class="block" for="Name">Name<label>
                  <input type="text" placeholder="Name" name="name"
                    class="w-full bg-gray-800 border-blue-400 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600 focus:bg-gray-800">
            </div>
            <div class="mt-4">
              <label class="block" for="email">Email<label>
                  <input type="text" placeholder="Email" name="email"
                    class="w-full bg-gray-800 border-blue-400 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>
            <div class="mt-4">
              <label for="dept" class="block">Contact</label>
              <input type="text" placeholder="Contact" name="contact"
                    class="w-full bg-gray-800 border-blue-400 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600 focus:bg-gray-800">
                    
            </div>
            <div class="mt-4">
              <label for="type" class="block">Create Account As</label>
              <select id="countries" name="type"
                class="bg-gray-50 border border-blue-400 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 bg-gray-800 border-blue-400 text-white">
                <option selected>Choose a type</option>
                <option value="student">Student</option>
              </select>
            </div>
            <div class="mt-4">
              <label class="block">Password<label>
                  <input type="password" placeholder="Password" name="password"
                    class="w-full bg-gray-800 border-blue-400 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>
            <div class="mt-4">
              <label class="block">Confirm Password<label>
                  <input type="password" placeholder="Password" name="re-password"
                    class="w-full bg-gray-800 border-blue-400 px-4 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600">
            </div>
            <div class="flex">
              <button type="submit" class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900">Create Account</button>
            </div>
            <div class="mt-6 text-grey-dark">
              Already have an account?
              <a class="text-blue-600 hover:underline" href="/Servlet-Project/login">
                Log in
              </a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </body>

  </html>