<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�ޱ����ĵ�</title>
<style type="text/css">
<!--
.style2 {font-family: "����"}
.style3 {
	font-size: 22px;
	font-weight: bold;
}
.style4 {
	font-size: 30px;
	font-family: "��Բ";
	font-weight: bold;
}
.style6 {font-family: "����"; font-weight: bold; }
.style7 {font-size: 24px}
-->
</style>
</head>

<body>



   
<form action="${loginUrl}" method="post"> 
<table width="680" height="401" border="0" cellpadding="0" cellspacing="0">
   
<c:if test="${param.error != null}">        
		<Script Language="JavaScript">
       alert("�û������������");
          </Script>
			
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
			You have been logged out.
		</p>
	</c:if>

  <tr bgcolor="#2285CE">
    <th height="147" colspan="4" class="style4" scope="row">���ռҾ���������ϵͳ<br>
    �û���½</th>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th height="30" colspan="4" scope="row">&nbsp;</th>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th width="159" height="41" scope="row">&nbsp;</th>
    <td width="97"><div align="center" class="style2 style3">�û�����</div></td>
    <td width="245">
      <input type="text"  id="username" name="username" style="width:240px; height:45px;">
    </td>
    <td width="169"><span class="style6"><a href="toregister"> ע���˺�</a></span></td>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th height="45" scope="row">&nbsp;</th>
    <td><div align="center" class="style2 style3">���룺</div></td>
    <td>
      <input type="password" id="password" name="password"  style="width:240px; height:45px;">
   </td>
    <td><span class="style6">�һ�����</span></td>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th height="18" scope="row">&nbsp;</th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th height="52" scope="row">&nbsp;</th>
    <td colspan="2">
      <input type="submit" name="Submit" value="��      ½" style="font-size:24px; font-weight: bold; width:350px; height:50px;">    
      </td>
    <td>&nbsp;</td>
  </tr>
  <tr bordercolor="#E1EBF5" bgcolor="#E1EBF5">
    <th height="37" scope="row">&nbsp;</th>
    <td colspan="2"><div align="center" class="style2 style7"><strong>���ռҾ߹ɷ����޹�˾</strong></div></td>
    <td>&nbsp;</td>
  </tr>
  <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
  
  
</table>
</form>



</body>
</html>
