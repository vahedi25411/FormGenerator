<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Add Textbox Element</title>
</head>

<body  style="margin-top: 0px; margin-bottom: 0px; margin-right: 0px;margin-left: 0px;font-family: -apple-system,system-ui,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif" >

<div style="width:100%;height:100px;background-color: #6f5499;margin-left:0;    background-image: linear-gradient(to bottom,#563d7c 0,#6f5499 100%);font-color:red;">
	<div style="top: 25px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 30px;color:white;">Form Generator Project
	</div>
	<div style="top: 50px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 12px;color:white;">${menu}
	</div>
</div>
<form:form modelAttribute="textbox">
<table border="1" cellspacing=0 cellpadding=5 bordercolor="#D3D3D3" style="margin-top: 20px; margin-bottom: 0px; margin-right: 10px;margin-left: 10px;">
	<tr>
		<th style="text-align:right">Title : </th>
		<td><form:input path="title"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Name : </th>
		<td><form:input path="name"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Is Required : </th>
		<td><form:checkbox path="isRequired"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Is Enabled : </th>
		<td><form:checkbox path="isEnabled"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Has Multiple Answer :</th>
		<td><form:checkbox path="isMultipleAnswerAllowed"/></td>
	</tr>			
	<tr>
		<th style="text-align:right">Default Value :</th>
		<td><form:input path="defaultValue"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Max Length :</th>
		<td><form:input path="maxLength"/></td>
	</tr>
	<tr>
		<th style="text-align:right">Width : </th>
		<td><form:input path="size"/></td>
	</tr>

					           					           
</table>
	<br>
	<input type="hidden" name="formId" value="${formId} "/>
	<input type="hidden" name="pageId" value="${pageId} "/>
&nbsp;&nbsp;  	<input type="submit" name="add" value="add">           
</form:form>
</body>
</html>