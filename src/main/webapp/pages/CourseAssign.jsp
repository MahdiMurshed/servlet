
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome to my display page</title>
</head>
<body>
<%
try
{
  
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_db","root","12345678");
  String sql = "select course_name,course_code from courses;";
  PreparedStatement stmt = con.prepareStatement(sql);
  ResultSet rs = stmt.executeQuery();
  String sqlt = "select name,email from users where role='teacher';";
  PreparedStatement stlt = con.prepareStatement(sqlt);
  ResultSet rt = stlt.executeQuery();
  if(rs.next()==false)
  {
    out.println("No Records in the table");
  }
  else
  {%>
  
  <table border="1">
  <tr><th>Course Name</th><th>Course id</th><th>Assign</th></tr>
  <% 
    do
    {%>
    
    <tr><td><%= rs.getString(1)%></td><td><%= rs.getString(2)%></td><<td><form action="assign" method="post"><input type="submit" name="button1" value="Button 1" /></form></td></tr>
    
    <%}while(rs.next());
  }
  
}
catch(Exception e)
{
System.out.println(e.getMessage());
e.getStackTrace();
}

%>
</table>
</body>
</html>