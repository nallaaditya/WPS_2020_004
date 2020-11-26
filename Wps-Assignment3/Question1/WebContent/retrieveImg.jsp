<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="java.sql.PreparedStatement"%>
<%
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
PreparedStatement stmt = null;
ResultSet rs = null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
String query="select * from employees where id = ?";
stmt = con.prepareStatement(query);
int id=Integer.parseInt(request.getParameter("empId"));
stmt.setInt(1,id);
rs = stmt.executeQuery();
int empid;
String empName;
Date empDob;
if (rs.next()) {
empid=rs.getInt(1);
image = rs.getBlob(2);
empName=rs.getString(4);
empDob=rs.getDate(3);
imgData = image.getBytes(1,(int)image.length());
}
else {
out.println("Display Blob Example");
out.println("image not found for given id>");
return;
}
// display the image
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();
out.println("Name:"+empName);
out.println("Id:"+empid);
out.println("Dob:"+empDob.toString());
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} finally {
try {
rs.close();
stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
%>