<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" type="text/css" href="resources/table.css" />
        <script type="text/javascript" src="resources/jquery-2.1.3.js"></script>  
        <script type="text/javascript" src="resources/jquery-2.1.3.min.js"></script>  
        <script type="text/javascript">
        <!--自动隔行换色-->
        $(document).ready(function(){ 
        	$("#customers tr:odd").addClass("gap_change"); 
        })
        	</script>

</head>
<body>
<p>选择要赋予角色的用户</p>
  <table id="customers">
	        	<th>No</th>
	        	<th>用户名</th>
	        	<th>启用状态</th>
	        	
	        	<th>操作</th>
	        	
				<c:forEach var="users" items="${users}" varStatus="status">
	        	<tr>
	        		<td align="center">${status.index + 1}</td>
					<td align="center">${users.username}</td>
					<td align="center">${users.enabled}</td>
					
					<td align="center">
						<a href="edituserrole?username=${users.username}">用户角色管理</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
					
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
</body>
</html>