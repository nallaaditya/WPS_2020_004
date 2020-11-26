<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.sun.xml.internal.bind.CycleRecoverable.Context"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert an Image into MySQL Database</title>
    </head>
    <body>
         <%
Connection conn=null;
PreparedStatement pstmt = null;
ResultSet rs=null;
String url="jdbc:mysql://localhost:3306/employee";
FileInputStream fis=null;

String id=(request.getParameter("empId"));
String name=request.getParameter("empName");
Date date=Date.valueOf("empDob");
String myloc=request.getParameter("empImg");


try{
Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
conn=DriverManager.getConnection(url, "root", "");
File image= new File(myloc);
pstmt = conn.prepareStatement("insert into employees(id, ,image,dob,name) " + "values(?,?,?,?)");
pstmt.setString(1, id);
pstmt.setString(4, name);
pstmt.setDate(3, date);
fis=new FileInputStream(image);
pstmt.setBinaryStream(2, (InputStream) fis, (int) (image.length()));
int count = pstmt.executeUpdate();
if(count>0)
{
out.println("insert successfully");
}
else
{
out.println("not successfully");
}
}
catch(Exception ex)
{
ex.printStackTrace();
}
finally{
try{
if(rs!=null){
rs.close();
rs= null;
}
if(pstmt !=null)
{
pstmt.close();
pstmt=null;
}
if(conn!=null)
{
conn.close();
conn=null;
}
}
catch(Exception e)
{
e.printStackTrace();
}
}
%>
    </body>
</html>