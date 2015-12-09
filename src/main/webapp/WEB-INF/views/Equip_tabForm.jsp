<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Equip_tab</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Equip_tab</h1>
		<form:form action="saveEquip_tab" method="post" modelAttribute="equip_tab">
		<table>

			<tr>
				<td>设备编号:</td>
				<td><form:input path="equip_num" /></td>
			</tr>
			<tr>
				<td>辅助设备编号:</td>
				<td><form:input path="equ_equip_num" /></td>
			</tr>
			<tr>
				<td>设备名称:</td>
				<td><form:input path="equip_name" /></td>
			</tr>
			<tr>
				<td>设备供应商:</td>
				<td><form:input path="equip_sup" /></td>
			</tr>
			<tr>
				<td>设备录入人编号:</td>
				<td><form:input path="equip_recorder_num" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>