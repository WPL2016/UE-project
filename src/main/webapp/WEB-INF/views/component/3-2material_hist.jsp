<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="resources/list.css" rel="stylesheet" type="text/css"/>
<script src="resources/jquery-1.3.2.js" type="text/javascript"></script>
<script src="resources/Grid.js" type="text/javascript"></script>
<script src="resources/BoxSelect.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	var grid = new Grid({
		titleTable:'titleTable',
		dataTable:'dataTable',
		widths : [30,24,160,,100,160],
		height : 500
	});
	new BoxSelect({
        allId : 'allBox',
        boxName : 'idList'
    });
	
});
</script>
<title>无标题文档</title>
<style type="text/css">
<!--
.style1 {
	font-family: "黑体";
	font-size: 18px;
	color: #FF6600;
}
-->
</style></head>

<body>
<form name="form1" method="post" action="" >
<div style="border:solid 1px #8DB2E3;">
<table id="titleTable" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
	<td class="box"><input type="checkbox" id="allBox"/></td>
    <td>Name</td>
    <td>Password</td>
    <td>Sex</td>
    <td>Age</td>
  </tr>
</table>
<table id="dataTable" cellpadding="0" cellspacing="0">
  <tr class="group"><td colspan="6"><span>分组1</span></td></tr>
  <tr class="row"><td class="num">1</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">2</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">3</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">4</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">5</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="group"><td colspan="6"><span>分组2</span></td></tr>
  <tr class="row"><td class="num">6</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">7</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">8</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">9</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">10</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="group"><td colspan="6"><span>分组3</span></td></tr>
  <tr class="row"><td class="num">11</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">12</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">13</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">14</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">15</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="group"><td colspan="6"><span>分组4</span></td></tr>
  <tr class="row"><td class="num">16</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">17</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">18</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">19</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
  <tr class="row"><td class="num">20</td><td class="box"><input type="checkbox" name="idList" value=""/></td><td><span>BUG多多</span></td><td><span>ORZ</span></td><td><span>男</span></td><td><span>26</span></td></tr>
</table>
</div>
</form>


 
</body>
</html>
