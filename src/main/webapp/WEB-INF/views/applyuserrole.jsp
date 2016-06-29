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
<title>申请角色</title>  

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
       
			<div class="horiz_blank" style="height:50px"></div>
			<div class="table_head">申请角色</div>
			<form id="applyuserrole" method="post"  action="applyuserrole" >
			<table id="customers">
			<tr><td class="blank"></td><td class="blank"></td><td class="blank"></td></tr>
			<tr><td align="center" class="blank"></td>
			    <td align="center" class="blank">选择申请角色类型: 
			       <select style='width:180px;height:25px;font-size-3' id="role_type" name="role_type">
         	             <option value="经理">经理</option>
         	             <option value="现场操作人员">现场操作人员</option>
         	             <option value="产品测试人员">产品测试人员</option>
         	             <option value="设备维护人员">设备维护人员</option>
         	              <option value="仓库管理人员">仓库管理人员</option>
         	             <option value="其他">其他</option>
         	       </select>
			    </td>
			
			    <td>
	               <input class="button blue" type="submit" value="新建">
	            </td></tr>
			<tr><td class="blank"></td><td class="blank"></td><td class="blank"></td></tr>
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