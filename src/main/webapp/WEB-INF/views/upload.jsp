<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="fileupload" method="post"  enctype="multipart/form-data" >
		<table>
			<tr>
				<td>file1:</td>
				<td><form:input path="name" type="file" /></td>
			</tr>
			<tr>
				<td>file2:</td>
				<td><form:input path="email" type="file" /></td>
			</tr>
			<tr>
				<td>file3:</td>
				<td><form:input path="address" type="file" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="上传"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   


