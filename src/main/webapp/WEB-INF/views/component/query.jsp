<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<style type="text/css">
<!--
.style1 {
	color: #FF6600;
	font-size: 24px;
}
.style2 {font-weight: bold}
.style3 {
	font-family: "黑体";
	font-size: 20px;
	font-weight: bold;
}
-->
</style>
</head>

<body>
<table width="944" height="798" border="1" cellpadding="0" cellspacing="0">
  <tr bgcolor="#E1EBF5">
    <th height="35" colspan="10" scope="row"><div align="left"><strong><span class="style1"> 设备能耗查询</span></strong></div></th>
    <td colspan="2">&nbsp;</td>
    <td width="50">&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th width="44" height="39" scope="row"><div align="left"></div></th>
    <th width="87" scope="row"><strong>选择时间段</strong></th>
    <th width="92" bgcolor="#FFFFFF" scope="row"><strong>2015-10-10</strong></th>
    <th width="27" scope="row"><strong>至</strong></th>
    <th width="99" bgcolor="#FFFFFF" scope="row"><strong>2015-12-23</strong></th>
    <th width="14" scope="row">&nbsp;</th>
    <th width="75" scope="row"><div align="left"><strong>选择设备</strong></div></th>
    <th width="113" bgcolor="#FFFFFF" scope="row"><form action="" method="post" name="form1" class="style2"  >
      <div align="center">
        <select name="select" style="font-size:20px; width:100px; height:28px;">
        </select>
      </div>
    </form></th>
    <th width="86" scope="row"><div align="left"><strong>选择产品</strong></div></th>
    <th width="113" bgcolor="#FFFFFF" scope="row"><form action="" method="post" name="form2">
      <strong>      <select name="select2" style="font-size:20px; width:100px; height:28px;">
	    
    </select>
      </strong>
    </form></th>
    <td width="70"><strong>频率设定</strong></td>
    <td width="46"><form name="form3" method="post" action="">
      <select name="select3" style="font-size:20px; width:40px; height:28px;">
      </select>
    </form></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" colspan="2" scope="row"><form name="form4" method="post" action="">
      <input type="submit" name="Submit" value="查询总能耗值" style="font-size:20px; width:150px; height:30px;">
    </form></th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" colspan="2" scope="row"><div align="left"><span class="style3">总能耗值为</span></div></th>
    <th height="32" bgcolor="#FFFFFF" scope="row">&nbsp;</th>
    <th height="32" colspan="2" scope="row"><form name="form5" method="post" action="">
      <input type="submit" name="Submit2" value="查询能耗统计表" style="font-size:20px; width:150px; height:30px;">
    </form></th>
    <th height="32" colspan="3" scope="row"><form name="form6" method="post" action="">
      <input type="submit" name="Submit3" value="查询能耗折线图" style="font-size:20px; width:150px; height:30px;">
    </form></th>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="18" colspan="10" scope="row">&nbsp;</th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="26" colspan="10" scope="row"><span class="style3">压铸能耗设备统计表</span></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="275" colspan="10" scope="row"><img src="file:///D|/3DA.tmp.jpg" width="663" height="272" align="middle"></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" scope="row">&nbsp;</th>
    <th height="25" colspan="2" scope="row">&lt;&lt;点击查看全部</th>
    <td colspan="2"><form name="form7" method="post" action="">
      <input type="submit" name="Submit4" value="导出统计图">
    </form></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="25" colspan="10" class="style3" scope="row">压铸设备能耗统计图</th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="257" colspan="10" scope="row"><img src="file:///D|/7A64.tmp.jpg" width="665" height="269"></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" scope="row">&nbsp;</th>
    <th height="32" colspan="2" scope="row">&lt;&lt;点击查看全部</th>
    <td colspan="2"><input type="submit" name="Submit42" value="导出统计图"></td>
    <td>&nbsp;</td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="32" colspan="10" scope="row"><div align="center"></div></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
