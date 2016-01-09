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
<script type="text/javascript">
function roleModify(){  
	var chk_value =[];   
	$('input[name=role_select]:checked').each(function(){   
	 chk_value.push($(this).val());
	});	
	$.ajax({  
    	 data:"roles="+chk_value+"&username="+$("#username").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'text',  
	       url:"edituserrole", 
	       async:true,
	       error:function(data){  
	            alert("出错了！请重新尝试！");  
	        },  
	        success:function(data){  
	        	alert("修改成功！");
	         
	                        
	                               
	    }  
    })
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
             <div class="table_head">请选择要赋予用户${username}的角色</div>   
                  <input type="hidden" name="username" id="username" value="${username} "   />
                  <table id="customers">
                 <tr><td class="blank"></td></tr>
                  <tr><td align="center">              
				   <c:forEach var="roles" items="${roles}" varStatus="status">
	        	   
	        	   <span class="check_box"><input type="checkbox" id="role_select" name="role_select" value="${roles.role_id}" checked="checked"/>${roles.role_name}</span>
				  
				   </c:forEach>	
				
				   <c:forEach var="noroles" items="${noroles}" varStatus="status">
	        	  
	        	  <span class="check_box"><input type="checkbox" id="role_select"  name="role_select" value="${noroles.role_id}" />${noroles.role_name}</span>
				  
				  </c:forEach>	       	
			      </td>
			      </tr>
			      <tr><td class="blank"></td></tr>
			      <tr><td align="center">
			      <input type="button" class="button blue" id="modify" onclick="roleModify()" value="修改"/>
			      </td></tr>
			      <tr><td class="blank"></td></tr>
			      </table>
        </div>
  </div>
  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>















































