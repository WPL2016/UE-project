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

<script type="text/javascript">
function roleModify(){  
    $.ajax({  
    	 data:"username="+$("#name").val()+"&",  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'json',  
	        url:"autoajax", 
	        async:true,
	        error:function(data){  
	            alert("出错了！！:"+data[0].name);  
	        },  
	        success:function(data){  
	        	alert("这是提示！！:"+data[0].name);  
	           var htmlstr="<table>手动异步刷新"+
	           "<tr><th>number</th><th>name</th><th>adress</th><th>telephone</th><th>email</th><th>id</th></tr>";
	           $.each(data,function(idx,obj){
	        	 htmlstr=htmlstr+"<tr><td>";
	        	 htmlstr=htmlstr+idx;
	        	 htmlstr=htmlstr+"</td>"+"<td>"+obj.name+"</td><td>"+obj.address+"</td><td>"+obj.telephone+"</td><td>"
	        	 +obj.email+"</td><td>"+obj.id+"</td>"+"</tr>";
	           })
	          // var htmlstr="</table>"
	          // htmlstr=htmlstr+data.msg;
	           htmlstr=htmlstr+"</table>";
	           $("#cloneTr0").html(htmlstr);
	                        
	                               
	    }  
    })
}

</script>
</head>
<body>
<p>选择要赋予用户的角色</p>
 
	        	
	        
				   <c:forEach var="roles" items="${roles}" varStatus="status">
	        	   <input type="checkbox" id="role_select" value="${roles.role_id}" checked="checked">${roles.role_name}</input>
				   </c:forEach>	
				   <c:forEach var="noroles" items="${noroles}" varStatus="status">
	        	  <input type="checkbox" id="role_select" value="${noroles.role_id}" >${noroles.role_name}</input>
				  </c:forEach>	       	
			      <input type="button" id="modify">修改</body>
			   
</html>