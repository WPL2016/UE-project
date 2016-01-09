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


<link rel="stylesheet" type="text/css" media="screen" href="resources/jqGrid/themes/cupertino/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/jqGrid/themes/cupertino/theme.css" />
<script src="resources/jquery-ui.js"></script>
<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>用户信息修改</title>  

<script type="text/javascript">  
<!--ajax访问时发送csrf token，以防止ajax访问被crsf过滤器拦截   -->
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});	
   });
   $document.ready(function registerresult(){
	 
	   
   });
   
</script>  
<script>
 $(function() {

            $.datepicker.regional["zh-CN"] = { closeText: "关闭", prevText: "&#x3c;上月", nextText: "下月&#x3e;", currentText: "今天", monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"], monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"], dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"], dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"], dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"], weekHeader: "周", dateFormat: "yy-m-d", firstDay: 1, isRTL: !1, showMonthAfterYear: !0, yearSuffix: "年" }

                         

            $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
 })
</script>
 <script>

  $(function() {

    $( "#datepicker" ).datepicker();

  });

  </script>
<script type="text/javascript">  
                    function validate_info(register)  
                   {  
                       if(register.username.value=="")  
                        {  
                            alert("账号不能为空！");  
                            return false;  
                        }  
                     
                       
                       if(register.person_name.value=="")  
                       {  
                           alert("真实姓名不能为空！");  
                           return false;  
                       }  
                       if(register.user_dep.value=="")  
                       {  
                           alert("必须填写部门！");  
                           return false;  
                       }  
                       if(register.user_tel.value=="")  
                       {  
                           alert("电话不能为空！");  
                           return false;  
                       }  
                       if(register.user_duty.value=="")  
                       {  
                           alert("职位不能为空！");  
                           return false;  
                       }  
                      
                       return true;  
                   }   
                     
                 
                     
</script>  


</head>
<body>
  <!-- 插入头部 -->
 
  
  <%@ include file="./component/1_head.jsp"%> 
 
   <div class="horiz_container" >
   <div class="blank_bf_table"></div>
        <div class="table_container2">
        <div class="table_head">修改用户信息</div>
        <form:form id="register" method="post" modelAttribute="users" action="edituserinfo" onsubmit="return validate_info(this);" >
        <table id="customers">
        <tr><td class="blank"></td><td class="blank"></td></tr>
        <tr>
          <td style="padding-left:30px">账号</td>
		 <td>		
		  		<form:input path="username" size="30" readonly="true"/><span style="color:red;">*</span>
		  		
          </td>
         </tr>
        
         <tr>
           <td style="padding-left:30px">真实姓名</td>
		 <td>		
		  		<form:input path="person_name" size="30" /><span style="color:red;">*</span>
		  		
          </td>
          </tr>
          <tr>
           <td style="padding-left:30px">所在部门</td>
		 <td>		
		  		<form:input path="user_dep" size="30" /><span style="color:red;">*</span>
		  		
          </td>
          </tr>
          <tr>    
           <td style="padding-left:30px">电话</td>
		 <td>		
		  		<form:input path="user_tel" size="30"/><span style="color:red;">*</span>
		  		
          </td> 
          </tr>
          
           <tr>    
           <td style="padding-left:30px" >生日</td>
		 <td>		
		  		<form:input path="birth_day" id="datepicker"  readonly="true" size="30"/>
          </td> 
          </tr>
          
            <tr>    
           <td style="padding-left:30px">职位</td>
		 <td>		
		  		<form:input path="user_duty" size="30"/><span style="color:red;">*</span>
		  		
          </td> 
          </tr>
            <tr>    
           <td style="padding-left:30px">邮箱</td>
		 <td>		
		  		<form:input path="email" size="30"/>
          </td> 
          </tr>
          <tr>
           <td></td><td><input type="submit" value="修改"></td>
          </tr>
           <tr><td class="blank"></td><td class="blank"></td></tr>
        </table>
        </form:form>
        </div>
   </div>
  
  
  <!-- 插入底部 -->     
  <div>

  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>




