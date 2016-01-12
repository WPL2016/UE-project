<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="resources/jquery-2.1.3.js"></script>  
<script type="text/javascript" src="resources/jquery-2.1.3.min.js"></script>  
<link rel="stylesheet" type="text/css" href="resources/table.css" />
<link rel="stylesheet" type="text/css" href="resources/div.css" />
<link rel="stylesheet" type="text/css" href="resources/button.css" />
<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>权限设置</title>  

<script type="text/javascript">  
<!--ajax访问时发送csrf token，以防止ajax访问被crsf过滤器拦截   -->
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});	
   });
</script>  
 <script type="text/javascript">
        <!--自动隔行换色-->
        $(document).ready(function(){ 
        	$("#customers tr:odd").addClass("gap_change"); 
        })
        	</script>
 <script type="text/javascript">  
                    function validate_info(addrole)  
                   {  
                       if(addrole.role_name.value=="")  
                        {  
                            alert("角色名不能为空！");  
                            return false;  
                        }                     
                       return true;  
                   }   
                     
                 
                     
</script>  
        	
        	

</head>
<body>
  <!-- 插入头部 -->
 
  
  <%@ include file="./component/1_head.jsp"%> 
 
 
  <!-- 中间层的总体容器，宽度是100% -->
  <div class="horiz_container">
        <!-- 插入左侧菜单空白 --> 
        <div class="blank_bf_menu"></div>    
        <!-- 插入左侧菜单 --> 
        <div class="menu_container">
        <%@ include file="./component/7_content.jsp"%> 
        </div>
        <!--插入菜单与主体内容之间的空白  -->
        <div class="blank_btw_menu_content"></div>
        <!--内容主体的div,请根据具体内容决定div的样式，table_container0最小，1次之，2最大，也可自行在div.css定义你自己想要的样式，要设置成左浮动以保证div水平排列-->     
        <div class="table_container2">
        <table id="customers">
	        	<th>No</th>
	        	<th>角色编号</th>
	        	<th>角色名</th>
	        	
	        	<th>操作</th>
	        	
				<c:forEach var="roles" items="${roles}" varStatus="status">
	        	<tr>
	        		<td align="center">${status.index + 1}</td>
					<td align="center">${roles.role_id}</td>
					<td align="center">${roles.role_name}</td>
					
					<td align="center">
						<input type=button class="button blue" onclick="window.location.href('toeditroleauthors?role_id=${roles.role_id}')" value="修改权限">
						&nbsp;&nbsp;&nbsp;&nbsp;
					   <input type=button class="button blue" onclick="window.location.href('deleterole?role_id=${roles.role_id}')" value="删除">
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
			<div class="horiz_blank" style="height:50px"></div>
			<div class="table_head">新建角色</div>
			<form id="addrole" method="post"  action="addrole" onsubmit="return validate_info(this);" >
			<table id="customers">
			<tr><td class="blank"></td><td class="blank"></td></tr>
			<tr><td align="center">输入角色名称: <input name="role_name" id="role_name" type="text"><span style="color:red;">*</span></td><td><input class="button blue" type="submit" value="新建"></td></tr>
			<tr><td class="blank"></td><td class="blank"></td></tr>
			</table>
			 <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
  
			</form>
        </div>
 
  
  </div>
  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>