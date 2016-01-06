<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="time">2015年11月27日</div>
         </div>   
        <div class="blank_btw_time_menu"></div>       
        
            <div class="menu_head">系统功能菜单</div>
            
<div  id="main0"  class="menu" > 
>首页</div> 

<div id="main1" class="menu"  onclick="document.all.child1.style.display=(document.all.child1.style.display =='none')?'':'none'" > 
>设备状态管理</div> 
<div id="child1"  class="menu"  style="display:none"> 
<a href="toequip">-压铸机设备状态</a> <br>     
<a href="toequip_smelter">-熔炉设备状态</a> <br> 
<a href="toequip_mould">-模具状态</a> <br> 
<a href="toequip_A">-A类易耗品状态</a> <br> 
<a href="tomaintenance">-维护保养记录</a> <br> 
</div> 



<div id="main2" class="menu" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
>质量状态管理 </div> 
<div id="child2"  class="menu" style="display:none"> 
<a href="toquality">-产品质量信息</a> <br> 
<a href="toquality_product">-产品测试信息</a> <br> 
</div>

<div id="main3" class="menu" onclick="document.all.child3.style.display=(document.all.child3.style.display =='none')?'':'none'" > 
>物料状态管理 </div> 
<div id="child3" class="menu" style="display:none;"> 
<a href="toinput1">-原材料使用状态</a> <br> 
<a href="toschedule">-生产进度管理</a> <br> 
</div>


<div id="main4" class="menu" onclick="document.all.child4.style.display=(document.all.child4.style.display =='none')?'':'none'" > 
>能耗状态管理 </div> 
<div id="child4" class="menu" style="display:none"> 
<a href="toinput2">-电能消耗</a> <br> 
<a href="togas">-天然气消耗</a> <br> 
</div>

<div id="main5" class="menu" onclick="document.all.child5.style.display=(document.all.child5.style.display =='none')?'':'none'" > 
>计划信息维护 </div> 
<div id="child5" class="menu" style="display:none;"> 
<a href="#">-生产计划</a> <br> 
<a href="tomaintenance">-维护保养计划</a> <br> 
</div>

<div id="main6" class="menu" onclick="document.all.child6.style.display=(document.all.child6.style.display =='none')?'':'none'" > 
>基本信息维护 </div> 
<div id="child6" class="menu" style="display:none;"> 
<a href="toequip_info">-设备信息</a> <br> 
<a href="toequip_para">-设备参数信息</a> <br> 
<a href="#">-产品信息</a> <br> 
<a href="#">-原材料信息</a> <br> 
<a href="#">-原材料采购信息</a> <br>
<a href="#">-模具信息</a> <br> 
<a href="#">-A类易耗品信息</a> <br> 
</div>

<div id="main7" class="menu" onclick="document.all.child7.style.display=(document.all.child7.style.display =='none')?'':'none'" > 
>系统设置 </div> 
<div id="child7" class="menu" style="display:none;"> 
<a href="toauthority">-权限管理</a> <br> 
<a href="#">-用户管理</a> <br> 
</div>

<div id="main8" class="menu" onclick="document.all.child8.style.display=(document.all.child8.style.display =='none')?'':'none'" > 
>帮助 </div> 




         
   
</body>
</html>
