<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>List of Page's Elements </title>
</head>
<body  style="margin-top: 0px; margin-bottom: 0px; margin-right: 0px;margin-left: 0px;font-family: -apple-system,system-ui,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif" >
<div style="width:100%;height:100px;background-color: #6f5499;margin-left:0;    background-image: linear-gradient(to bottom,#563d7c 0,#6f5499 100%);font-color:red;">
	<div style="top: 25px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 30px;color:white;">Form Generator Project
	</div>
	<div style="top: 50px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 12px;color:white;">${menu}
	</div>
	
</div>
<br>
<form action="list.html" method="post">
	<input type="hidden" name="pageId" value="${pageId }">
	<input type="hidden" name="formId" value="${formId }"> 
&nbsp;&nbsp;	<select name="elementType">
		<option value="0">Textbox</option>
		<option value="1">Checkbox</option>
	</select>
	<button type="submit">Add</button>
</form>
<br/>

<table border="1" cellspacing=0 cellpadding=5 bordercolor="#D3D3D3" style="margin-top: 20px; margin-bottom: 0px; margin-right: 10px;margin-left: 10px;">
<thead >
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Name</th>
		<th>is Required</th>
		<th>is Enabled</th>
		<th>has Multiple Answer</th>
		<th>Manage</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${elements}" var="element">
	<tr>
		<td>${element.id }</td>
		<td>${element.title }</td>
		<td>${element.name }</td>
		<td>${element.isRequired }</td>
		<td>${element.isEnabled }</td>
		<td>${element.isMultipleAnswerAllowed}</td>
		<td>  
		<!--  
			<a href="edit.html?elementId=${element.id}"><button type="button" class="btn btn-info">edit</button></a>
			<a href="delete.html?elementId=${element.id}"><button type="button" class="btn btn-info">delete</button></a>
		-->
	
		<c:choose>
			<c:when test="${element.type =='MultipleChoice' }">
				<a href="../choice/list.html?elementId=${element.id}&formId=${formId }&pageId=${pageId }"><button type="button" class="btn btn-info">Choices</button></a>
				<a href="editCheckbox.html?elementId=${element.id}&formId=${formId }&pageId=${pageId }"><button type="button" class="btn btn-info">edit</button></a>
			</c:when>
			<c:when test="${element.type =='Textbox' }">
				<a href="editTextbox.html?elementId=${element.id}&formId=${formId }&pageId=${pageId }"><button type="button" class="btn btn-info">edit</button></a>
			</c:when>
			<c:when test="${element.type =='DateText' }">
				<a href="edit.html"><button type="button" class="btn btn-info">edit</button></a>
			</c:when>			
		</c:choose>
		<a href="delete.html?elementId=${element.id}&formId=${formId }&pageId=${pageId }"><button type="button" class="btn btn-info">delete</button></a>	
		<!--  	
			<a href="view.html?id=${member.id}"><button type="button" class="btn btn-info">View</button></a>
			<a href="edit.html?id=${member.id}"><button type="button" class="btn btn-warning">Edit</button></a>
		-->
		
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br/>
<!--  <a href="add.html">Add new member</a>-->

</body>
</html>