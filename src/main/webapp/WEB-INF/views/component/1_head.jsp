<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<link href="/design.css" rel="stylesheet"  type="text/css" />		
<link rel="stylesheet" type="text/css" href="resources/div.css" />



</head>

<body>
  <table width="100%" height="111" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <th width="343" ><img src="resources/UELOGO.jpg" width="343" height="111px"></th>
    <th  style="background-color:#2285CE;heigh:111px; text-align:right; color:#FFFFFF;font-size: 24px;font-family: '黑体';font-weight: bold; ">
    <% 
    String user="";
    String logout="";
    try{
       user=request.getUserPrincipal().getName();
       logout="注销";
  
        %>
        <%=user%><a href="logout" style="color:#ffffff;font-size: 24px;font-family: '黑体';font-weight: bold; "><%=logout %> &nbsp&nbsp&nbsp&nbsp</a>
    <% 
      } catch(Exception e){}
    %>
    </th>
  </tr>
</table>
<!--  
<div  id="fixed_equip" >

 <div class="equip_container"  >  
            
             
              <div class="equip">压铸机号</div>
        
        </div>
        </div>   
 <script type="text/javascript" >
function equipFixed(id){
var obj = document.getElementById(id);
var _getHeight = obj.offsetTop;

window.onscroll = function(){
changePos2(id,_getHeight);
}
}
function changePos2(id,height){
var obj = document.getElementById(id);
var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
if(scrollTop < height){
obj.style.position = 'relative';
}else{
obj.style.position = 'fixed';
}
}
</script>
<script type="text/javascript">
window.onload = function(){
equipFixed('fixed_equip');
}
</script>
                     -->
</body>

</html>
