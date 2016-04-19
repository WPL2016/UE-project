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
         <form:form id="dayplan" method="post"  action="work_plan_decom" >
         <input type="hidden" name="day_plan_num"  value="${day_plan_num}">
         <input type="hidden" name="plan_date"  value="${plan_date}">
         <table id="customers">
	        	
	        	<tr>
	        	<th>班次</th>        	
	        	<th>设备</th>
	        	<th>数量</th>
	        	</tr>
	        			
	        	
			    <c:forEach var="usableequip" items="${usableequip}">
			       <tr>                 
	                   <td rowspan="3">${usableequip.equip_name} <input name="equip_num1"  type="hidden" value="${usableequip.equip_num}"/></td>	                   
	                   <td>1号班</td>	                         	                         
					   <td><input name="plan_quan1" value="${average}"/></td>
				   </tr>   
				   <tr>                 
	                   	                   
	                   <td><input name="equip_num2"  type="hidden" value="${usableequip.equip_num}"/>2号班</td>	                         	                         
					   <td><input name="plan_quan2" value="${average}"/></td>
				   </tr>           
				   <tr>                 
	                   	                   
	                   <td><input name="equip_num3"  type="hidden" value="${usableequip.equip_num}"/>2号班</td>	                         	                         
					   <td><input name="plan_quan3" value="${average}"/></td>
				   </tr>                   
					      
				        
				  </c:forEach>
				    	
				<tr><td>总数： </td><td>${total}</td><td><input type=submit value="分解"></td></tr>       	
			</table>
			</form:form>
        </div>
 
  

  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>
