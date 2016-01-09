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
<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>基础模板</title>  

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
        <div class="table_head">首页</div>
        <table width=100%  height="548" border="0" bgcolor="#E1EBF5" cellpadding="0" cellspacing="0">
  <tr>
    <th height="40" colspan="5" scope="row">&nbsp;</th>
  </tr>
  <tr>
    <th width="4%" rowspan="2" scope="row">&nbsp;</th>
    <td width="45%" height="295"><img src="file:///D|/&#21387;&#38136;&#26426;.png" width="445" height="329"></td>
    <td width="4%" rowspan="2">&nbsp;</td>
    <td width="45%"><img src="file:///D|/&#27880;&#22609;&#26426;.png" width="468" height="331"></td>
    <td width="2%" rowspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td height="142">
    <c:forEach var="YZequip" items="${YZequip}" varStatus="status">
    <p><strong>${YZequip.equip_name}：${YZequip.current_state}</strong></p>
    </c:forEach></td>
    
    <td>
     <c:forEach var="ZSequip" items="${ZSequip}" varStatus="status">
     <p><strong>${ZSequip.equip_name}：${ZSequip.current_state}</strong></p>
    </c:forEach>
    </td>
  </tr>
  <tr>
    <th height="30" colspan="5" scope="row">&nbsp;</th>
  </tr>
</table>                            
       
       
        </div>
 
  
  </div>
  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>




