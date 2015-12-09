
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>


<style>div{font-size:18px;color:red; background-color: #E1EBF5; border: 1 solid #FFFFFF; padding: 1}</style>

<div id="main0" style="color:#000000; font-size: 18px; font-family: &quot;ºÚÌå&quot;; font-weight: bold;" onclick="document.all.child1.style.display=(document.all.child1.style.display =='none')?'':'none'" > 
> Ê×Ò³</div> 
<div id="child1" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- ×ÓÄ¿Â¼1</a> <br> 
<a href="#">- ×ÓÄ¿Â¼2</a> <br> 
<a href="#">- ×ÓÄ¿Â¼3</a> <br> 
<a href="#">- ×ÓÄ¿Â¼4</a> 
</div> 

<div id="main1" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child1.style.display=(document.all.child1.style.display =='none')?'':'none'" > 
> Éè±¸×´Ì¬¼à¿Ø</div> 
<div id="child1" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- Ñ¹ÖýÉè±¸×´Ì¬</a> <br> 
<a href="#">- Ä£¾ß×´Ì¬</a> <br> 
<a href="#">- AÀàÒ×ºÄÆ·×´Ì¬</a> <br> 
</div> 

<div id="main2" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> ÖÊÁ¿×´Ì¬¼à¿Ø </div> 
<div id="child2" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- µ±Ç°ÖÊÁ¿×´¿ö</a> <br> 
<a href="#">- FPYÍ³¼Æ</a> <br> 
</div>

<div id="main3" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> ÎïÁÏ×´Ì¬¼à¿Ø </div> 
<div id="child2" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- Éú²ú¼Æ»®¹ÜÀí</a> <br> 
<a href="#">- Ô­²ÄÁÏ×´Ì¬¹ÜÀí</a> <br> 
<a href="#">- Éú²ú½ø¶È¹ÜÀí</a> 
</div>

<div id="main4" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> ÄÜºÄ×´Ì¬¼à¿Ø </div> 
<div id="child2" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- ÈÛÂ¯ÄÜºÄ</a> <br> 
<a href="#">- Ñ¹ÖýÉè±¸ÄÜºÄ</a> <br> 
</div>

<div id="main5" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> ²éÑ¯¼°Í³¼Æ </div> 
<div id="child2" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- ±ê×¼»¯×÷ÒµÁ÷³Ì</a> <br> 
<a href="#">- Ð§ÂÊÍ³¼Æ</a> <br> 
</div>

<div id="main6" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> ÏµÍ³ÉèÖÃ </div> 
<div id="child2" style="display:none; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px; color: #000000;"> 
<a href="#">- ÓÃ»§¹ÜÀí</a> <br> 
<a href="#">- ¹ÜÀíÔ±ÉèÖÃ</a> <br> 
</div>

<div id="main7" style="color:#000000; font-family: &quot;ºÚÌå&quot;; font-weight: bold; font-size: 18px;" onclick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > 
> °ïÖú </div> 
</div>
</body>
</html>