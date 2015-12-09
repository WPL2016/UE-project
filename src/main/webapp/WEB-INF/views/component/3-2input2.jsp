<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>无标题文档</title>
<script type="text/javascript" src="resources/jquery-2.1.3.js"></script>  
<script type="text/javascript" src="resources/jquery-2.1.3.min.js"></script>  
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
<table  height="788" width="100%" border="0" cellpadding="0" cellspacing="0">
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
    <th height="275" colspan="10" scope="row"><img width="100%"  src="resources/OEE.png"></th>
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
    <th height="257" colspan="10" scope="row"><div id="linechart" style="width:100%;height:500px"></div><div id="piechart" style="width:100%;height:500px"></div></div></th>
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
    <th height="32" colspan="10" scope="row"><div align="center"></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

<!-- ECharts文件引入 -->
  
    <script src="resources/echarts/build/dist/echarts.js"></script>
    
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'resources/echarts/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
                'echarts/chart/line',
                'echarts/chart/pie',
                
            ],
            DrawCharts
            );
            function DrawCharts(ec) {
            drawBar(ec);
            drawPie(ec);
             }

            function drawBar(ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('linechart')); 
                
                var option = {                		                  		
                title : {
                  	        text: '上月FPY统计值(%)',
                  	        subtext: '折线图（Line Chart）',
                  	        x:'center'
                  	      },	
                    tooltip: {
                        show: true
                    },
                    legend: {
                    	orient : 'vertical',
                        x : 'left',
                        data:['第一周','第二周','第三周','第四周']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    calculable:true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ["星期一","星期二","星期三","星期四","星期五","星期六"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"第一周",
                            "type":"bar",
                            "data":[95, 20, 40, 10, 10, 20]
                        },
                        {
                            "name":"第二周",
                            "type":"bar",
                            "data":[56, 76, 34, 65, 76, 75]
                        },
                        {
                            "name":"第三周",
                            "type":"bar",
                            "data":[24, 78, 90, 89, 76,78]
                        },
                        {
                            "name":"第四周",
                            "type":"bar",
                            "data":[67, 98, 87, 32, 12, 43]
                        }
                        
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
            
            function drawPie(ec) {
                // 基于准备好的dom，初始化echarts图表
            	  myChart = ec.init(document.getElementById('piechart')); 
            	  
            	  var option = {
            	      title : {
            	        text: 'FPY不合格原因统计',
            	        subtext: '饼图（Pie Chart）',
            	        x:'center'
            	      },
            	      tooltip : {
            	        trigger: 'item',
            	        formatter: "{a} <br/>{b} : {c} ({d}%)"
            	      },
            	      legend: {
            	        orient : 'vertical',
            	        x : 'left',
            	        data:['工人操作失误','机器故障','原材料不合格','运输损坏']
            	      },
            	      toolbox: {
            	        show : true,
            	        feature : {
            	          mark : {show: true},
            	          dataView : {show: true, readOnly: false},
            	          restore : {show: true},
            	          saveAsImage : {show: true}
            	        }
            	      },
            	      calculable : true,
            	      series : [
            	        {
            	          name:'饼图实例',
            	          type:'pie',
            	          radius : '55%',
            	          center: ['50%', '60%'],
            	          data:[
            	                {value:100, name:'工人操作失误'},
            	                {value:200, name:'机器故障'},
            	                {value:300, name:'原材料不合格'},
            	                {value:400, name:'运输损坏'}]
            	        }
            	      ]
            	    };
            	  
            	  // 为echarts对象加载数据 
            	  myChart.setOption(option); 

            }
               
           
       
       
        
        
    </script>

</body>
</html>
