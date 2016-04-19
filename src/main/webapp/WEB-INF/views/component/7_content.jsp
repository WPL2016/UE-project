<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<link rel="stylesheet" type=".contentword1/css" href="resources/design.css" />
<link rel="stylesheet" type=".contentword2/css" href="resources/design.css" />

</head>
<body>
        
       
          <div class="blank_btw_time_menu"></div>   
         <div class="time_container">
         <% 
            Calendar calendar= Calendar.getInstance(); 
            calendar.setTime(new java.util.Date());  
            int year = calendar.get(Calendar.YEAR);  
            int month = calendar.get(Calendar.MONTH)+1;  
            int day = calendar.get(Calendar.DAY_OF_MONTH);  
        %>
            <div class="time"><%=year %>年<%=month %>月<%=day %>日</div>
         </div>   
        <div class="blank_btw_time_menu"></div>       
        
            <div class="menu_head">系统功能菜单</div>
            
<div  id="main0"  class="menu" > 
<% HttpSession s = request.getSession();     
%>
<%if(s.getAttribute("user_role_type").equals("超级管理员")){ %>
<div id="child7sa" class="menu"> 
<a href="toasignrole">-角色授予</a> <br> 
<a href="toassignauthors">-权限设置</a> <br> 
<a href="toviewapply">-用户申请处理</a> <br> 
<!--  <a href="toedituserinfo">-个人中心</a> <br> -->

</div>
<%}
else if(s.getAttribute("user_role_type").equals("经理")){%>
<div><a href="tohome">首页</a></div> 
<div id="main1mg" class="menu"  onclick="document.all.child1mg.style.display=(document.all.child1mg.style.display =='none')?'':'none'" > 
>设备状态管理</div> 
<div id="child1mg"  class="menu"  style="display:none"> 
<a href="toequip">-压铸设备状态</a> <br>     
<a href="tomou_use_inf_tab">-模具状态</a> <br> 
<a href="toatype_use_inf_tab">-A类易耗品状态</a> <br> 
<a href="tomaint_reg">-维护保养记录</a> <br> 
</div> 



<div id="main2mg" class="menu" onclick="document.all.child2mg.style.display=(document.all.child2mg.style.display =='none')?'':'none'" > 
>质量状态管理 </div> 
<div id="child2mg"  class="menu" style="display:none"> 
<a href="toquality">-产品质量信息</a> <br> 
<a href="toquality_product">-产品测试信息</a> <br> 
</div>

<div id="main3mg" class="menu" onclick="document.all.child3mg.style.display=(document.all.child3mg.style.display =='none')?'':'none'" > 
>物流状态管理 </div> 
<div id="child3mg" class="menu" style="display:none;"> 
<a href="tomater_use_stock_tab">-原材料使用状态</a> <br> 
<a href="toproduce_prog_tab">-生产状态</a> <br> 
</div>


<div id="main4mg" class="menu" onclick="document.all.child4mg.style.display=(document.all.child4mg.style.display =='none')?'':'none'" > 
>能耗状态管理 </div> 
<div id="child4mg" class="menu" style="display:none"> 
<a href="toenergy">-电能消耗</a> <br> 
<a href="togas">-天然气消耗</a> <br> 
</div>

<div id="main5mg" class="menu" onclick="document.all.child5mg.style.display=(document.all.child5mg.style.display =='none')?'':'none'" > 
>计划信息维护 </div> 
<div id="child5mg" class="menu" style="display:none;"> 
<a href="toproduce_plan_tab">-生产计划</a> <br> 
<a href="towork_plan_tab">-作业计划</a> <br> 
<a href="tomaintenance">-维护保养计划</a> <br> 
</div>
<div id="main6mg" class="menu" onclick="document.all.child6mg.style.display=(document.all.child6mg.style.display =='none')?'':'none'" > 
>基本信息维护 </div> 
<div id="child6mg" class="menu" style="display:none;"> 
<a href="toequip_info">-设备信息</a> <br> 
<a href="toequip_para">-设备参数信息</a> <br> 
<a href="toproduct_tab">-产品信息</a> <br> 
<a href="tomater_tab">-原材料信息</a> <br> 
<a href="tomater_pur_tab">-原材料采购信息</a> <br>
<a href="tomou_tab">-模具信息</a> <br> 
<a href="toatype_tab">-A类易耗品信息</a> <br> 
</div>
<%}
else if(s.getAttribute("user_role_type").equals("现场操作人员")){%>
<div id="child5op" class="menu"> 
<a href="toproduce_plan_tab">-作业计划</a> <br> 
</div>

<%} 
else if(s.getAttribute("user_role_type").equals("产品测试人员")){%>

<div id="child2qt"  class="menu"> 
<a href="toquality_product">-产品测试信息</a><br> 
</div>

<% }
else if(s.getAttribute("user_role_type").equals("设备维护人员")){%>

<div id="child5em" class="menu"> 
<a href="tomaintenance">-维护保养计划</a> <br> 
<a href="toequip_info">-设备信息</a> <br> 
<a href="toequip_para">-设备参数信息</a> <br> 
<a href="tomou_tab">-模具信息</a> <br> 
<a href="toatype_tab">-A类易耗品信息</a> <br> 
</div>
       <!--  
          
        -->
<% }
else if(s.getAttribute("user_role_type").equals("仓库管理人员")){%>
<div id="child5em" class="menu"> 
 <a href="toproduct_tab">-产品信息</a> <br> 
           <a href="tomater_tab">-原材料信息</a> <br> 
           <a href="tomater_pur_tab">-原材料采购信息</a> <br>
</div>
<% }
else {%>
<div class="menu">
<a href="toapplyuserrole">-申请用户角色</a> <br> 
</div> 
<%} %>
</div>

<div id="main8" class="menu" onclick="document.all.child8.style.display=(document.all.child8.style.display =='none')?'':'none'" > 
</div> 

</body>
</html>

