<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
        <!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
        
    </head>
    <body>
    	<div align="center">
	        <h1>Equip_tab List</h1>
	        <h3><a href="equip_tab/newEquip_tab">New Equip_tab</a></h3>
	        <table border="1">
	        <tr>
	        	<th>Equip_num</th>
	        	<th>Equ_equip_num</th>
	        	<th>Equip_name</th>
	        	<th>Equip_sup</th>
	        	<th>Equip_recorder_num</th>
             </tr>
	        	
				<c:forEach var="equip_tab" items="${listEquip_tab}" varStatus="status">
	        	<tr>
	        		<td>${equip_tab.equip_num}</td>
	        		<td>${equip_tab.equ_equip_num}</td>
					<td>${equip_tab.equip_name}</td>
					<td>${equip_tab.equip_sup}</td>
					<td>${equip_tab.equip_recorder_num}</td>
					<td>
						<a href="equip_tab/editEquip_tab?equip_num=${equip_tab.equip_num}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="equip_tab/deleteEquip_tab?equip_num=${equip_tab.equip_num}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
