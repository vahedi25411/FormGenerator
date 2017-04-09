<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Add Member</title>
</head>
<body  style="margin-top: 0px; margin-bottom: 0px; margin-right: 0px;margin-left: 0px;font-family: -apple-system,system-ui,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif" >
<div style="width:100%;height:100px;background-color: #6f5499;margin-left:0;    background-image: linear-gradient(to bottom,#563d7c 0,#6f5499 100%);font-color:red;">
	<div style="top: 25px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 30px;color:white;">Form Generator Project
	</div>
	<div style="top: 50px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 12px;color:white;">${menu}
	</div>
</div>

<form:form modelAttribute="member">
<table border="1" cellspacing=0 cellpadding=5 bordercolor="#D3D3D3" style="margin-top: 20px; margin-bottom: 0px; margin-right: 10px;margin-left: 10px;">
	<tr>
    	<th>Email Id:</th>
    	<td><form:input path="email"/></td>
    </tr>	
	<tr>
    	<th>First Name:</th>
    	<td><form:input path="firstName"/></td>
    </tr>
  	<tr>
  		<th>Middle Name:</th>
    	<td><form:input path="middleName"/></td>
    </tr>
    <tr>
    	<th>Last Name:</th>
    	<td><form:input path="lastName"/></td>
    </tr>
    <tr>
    	<th>Password:</th>
    	<td><form:password path="passcode" /></td>
    </tr>
    <tr>
    	<th colspan="2">Enter Your Address:</th>
    </tr>
    <tr>
		<th>House Number:</th>
		<td><form:input path="address.house"/></td>
	</tr>
	<tr>
		<th>Street Number:</th>
		<td><form:input path="address.street"/></td>
	</tr>
	<tr>
		<th>Area:</th>
		<td><form:input path="address.area"/></td>
	</tr>
	<tr>
		<th>City:</th>
		<td><form:input path="address.city"/></td>
	</tr>
	<tr>
		<th>Zip Code:</th>
		<td><form:input path="address.zip"/></td>
	</tr>
	<tr>
		<th>State:</th>
		<td><form:input path="address.state"/></td>
	</tr>
	<tr>
		<th>Country:</th>
		<td><form:input path="address.country"/></td>
	</tr>
</table>          
&nbsp;&nbsp;
  	<input type="submit" class="btn btn-success" 
           name="add" value="Save">
</form:form>
<br>

           
<br><br>
</body>
</html>