<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>日生产计划</title>  

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
        	
 


</head>
<body>
        <div class="blank_btw_menu_content"></div>
        <!--内容主体的div,请根据具体内容决定div的样式，table_container0最小，1次之，2最大，也可自行在div.css定义你自己想要的样式，要设置成左浮动以保证div水平排列-->     
        <div class="table_container2">
         <form:form id="dayplan" method="post"  action="dayplandecom" >
         <input type="hidden" name="produce_plan_num"  value="${produce_plan_num}">
         <table id="customers">
	        	<tr>
	        	<th>日期</th>
	        	<th>数量</th>
	        	</tr>
	        	
	        	
				<c:forEach var="listday_plan_tab" items="${listday_plan_tab}" varStatus="status">
	        	<tr>
	        		
					<td align="center">${listday_plan_tab.plan_date}<input name="plan_date"  type="hidden" value="${listday_plan_tab.plan_date}"/></td>
					<td align="center"><input name="plan_quan"  value="${listday_plan_tab.plan_quan}"/></td>							
	        	</tr>
				</c:forEach>	 
				<tr><td><input type=submit value="提交"></td><td>计划总数:&nbsp&nbsp&nbsp  ${total}</td></tr>       	
			</table>
			</form:form>
        </div>
 
  

  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>
