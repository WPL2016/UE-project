<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/jquery-2.1.3.js"></script>  
<script type="text/javascript" src="resources/jquery-2.1.3.min.js"></script>  

<link rel="stylesheet" type="text/css" href="resources/table.css" />
<link rel="stylesheet" type="text/css" href="resources/position.css" />
<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
   <meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta http-equiv="viewport" content="width=device-width,initial-scale=1.0"> 
	

<title>Insert title here</title>  
<script type="text/javascript">  
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});	
   });
</script>  


</head>
<body>

    <table id="position">
    <tr><td colspan=4>
    <%@ include file="./component/1_head.jsp"%> 
        </td></tr>
        <tr>
       <td colspan=4 class="equip">
        <div class="total">
         <% int i;
            String s=(String)request.getAttribute("recordnum");
            i=Integer.parseInt(s);
            for(int j=1;j<=i;j++){ %>
              <div class="equip">注塑机<%=j %>号</div>
        <%}%>
        </div></td>
        </tr>
        <tr>
         <td class="time"><div class="time">2015年11月26日</div></td><td class="heli2"></td><td colspan=2 class="heli2"></td>
        </tr>
    <tr>
    <td class="heli1"><div class="menu">系统功能菜单</div><%@ include file="./component/7_content.jsp"%> 
    </td>
    <td class="col"></td>
    <td class="table">

   </td>
   <td class="table">
    <div id="linechart" class="charts"></div>
    <div class="blank"></div>
     <div id="piechart" class="charts"></div>
   </td>
   </tr>
   <tr><td class="heli2" colspan=4></tr>      
   <tr><td colspan=4>
   <%@ include file="./component/2_foot.jsp"%> 
   </td></tr>
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




