<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<jsp:useBean id="bone" class="pk1.MySqlLoginBean">
	
<jsp:setProperty name="bone" property="id" value="${param.empId}"/>
<jsp:setProperty name="bone" property="imageLoc" value="${param.empImg}"/>
<jsp:setProperty name="bone" property="date" value="${param.empDob}"/>
<jsp:setProperty name="bone" property="name" value="${param.empName }"/>
<jsp:getProperty name="bone" property="store" value="15"/>

</jsp:useBean>  
  
Saved the record