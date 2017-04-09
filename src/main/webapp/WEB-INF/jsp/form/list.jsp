<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>

</head>
<body  style="margin-top: 0px; margin-bottom: 0px; margin-right: 0px;margin-left: 0px;font-family: -apple-system,system-ui,BlinkMacSystemFont,Segoe UI,Roboto,Helvetica Neue,Arial,sans-serif" >
<div style="width:100%;height:100px;background-color: #6f5499;margin-left:0;    background-image: linear-gradient(to bottom,#563d7c 0,#6f5499 100%);font-color:red;">
	<div style="top: 25px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 30px;color:white;">Form Generator Project
	</div>
	<div style="top: 50px; left: 20px;position:relative;font-family:Helvetica Neue,Helvetica,Arial,sans-serif;font-size: 12px;color:white;">${menu}
	</div>
</div>
<table border="1" cellspacing=0 cellpadding=5 bordercolor="#D3D3D3" style="margin-top: 20px; margin-bottom: 0px; margin-right: 10px;margin-left: 10px;">
<thead >
	<tr>
		<th>ID</th>
		<th>Title</th>
		<th>Description</th>
		<th>Create Date</th>
		<th>Last Modify Date</th>
		<th>Owner</th>
		<th>Manage</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${forms}" var="form">
	<tr>
		<td>${form.id}</td>
		<td>${form.title}</td>
		<td>${form.description}</td>
		<td>${form.createdDate}</td>
		<th>${form.modifiedDate}</th>
		<td>${form.ownedBy.email}</td>
		<td>
			<a href="preview.html?formId=${form.id}"><button type="button" class="btn btn-info">Preview</button></a>
			<a href="edit.html?id=${form.id}"><button type="button" class="btn btn-primary">Edit</button></a>
			<a href="delete.html?formId=${form.id}"><button type="button" class="btn btn-primary">Delete</button></a>
			<a href="../page/list.html?formId=${form.id}"><button type="button" class="btn btn-warning">Pages</button></a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br/>
&nbsp;&nbsp;<a href="add.html">Add new form</a>
</body>
</html>