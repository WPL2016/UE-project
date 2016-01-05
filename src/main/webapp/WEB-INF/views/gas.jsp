<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/jquery-2.1.3.js"></script>  
<script type="text/javascript" src="resources/jquery-2.1.3.min.js"></script>  
<link rel="stylesheet" type="text/css" href="resources/table.css" />
<link rel="stylesheet" type="text/css" href="resources/div.css" />
<link rel="stylesheet" type="text/css"  media="screen"  href="resources/jqGrid/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen"   href="resources/jqGrid/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css" media="screen"  href="resources/jqGrid/css/ui.jqgrid-bootstrap-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"  href="resources/jqGrid/css/ui.jqgrid-bootstrap-ui.theme.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/jqGrid/themes/cupertino/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen" href="resources/jqGrid/themes/cupertino/theme.css" />
<script src="resources/jqGrid/js/i18n/grid.locale-cn.js" type="text/ecmascript"></script>
<script src="resources/jqGrid/js/jquery.jqGrid.min.js" type="text/ecmascript"></script>



<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>天然气消耗</title>  

<script type="text/javascript">  
<!--ajax访问时发送csrf token，以防止ajax访问被crsf过滤器拦截   -->
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
  <!-- 插入头部 -->
  
    
     <%@ include file="./component/1_head.jsp"%> 
   
  
  <!-- 中间层的总体容器，宽度是100% -->
  <div class="horiz_container">
        <!-- 插入左侧菜单空白 --> 
        <div class="blank_bf_menu"></div>    
        <!-- 插入左侧菜单 --> 
        <div class="menu_container">
        <%@ include file="./component/7_content.jsp"%> 
        </div>
        <!--插入菜单与主体内容之间的空白  -->
        <div class="blank_btw_menu_content"></div>
        <!--内容主体的div,请根据具体内容决定div的样式，table_container0最小，1次之，2最大，也可自行在div.css定义你自己想要的样式，要设置成左浮动以保证div水平排列-->     
        
        <div class="table_container2">
                                                                                                         
          <div class="table_head">天然气消耗状态</div>
          <table width="100%" height="798" border="0" cellpadding="0" cellspacing="0">
               <tr bgcolor="#E1EBF5">
                   <th height="35" colspan="10" scope="row"><div align="left"><strong><span class="style1"> 设备天然气消耗查询</span></strong></div></th>
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
                   <th width="113" bgcolor="#FFFFFF" scope="row">
                      <form action="" method="post" name="form1" class="style2"  >
                      <div align="center">
                         <select name="select" style="font-size:20px; width:100px; height:28px;">
                         </select>
                      </div>
                     </form>
                   </th>
                   <th width="86" scope="row"><div align="left"><strong>选择产品</strong></div></th>
                   <th width="113" bgcolor="#FFFFFF" scope="row">
                      <form action="" method="post" name="form2">
                          <strong><select name="select2" style="font-size:20px; width:100px; height:28px;"></select></strong>
                      </form>
                   </th>
                   <td width="70"><strong>频率设定</strong></td>
                   <td width="46">
                        <form name="form3" method="post" action="">
                           <select name="select3" style="font-size:20px; width:40px; height:28px;"></select>
                        </form>
                   </td>
                   <td>&nbsp;</td>
               </tr>
               <tr bgcolor="#E1EBF5">
                   <th height="32" scope="row">&nbsp;</th>
                   <th height="32" colspan="2" scope="row">
                      <form name="form4" method="post" action="">
                        <input type="submit" name="Submit" value="查询总能耗值" style="font-size:20px; width:150px; height:30px;">
                      </form></th>
                   <th height="32" scope="row">&nbsp;</th>
                   <th height="32" colspan="2" scope="row"><div align="left"><span class="style3">总能耗值为</span></div></th>
                   <th height="32" bgcolor="#FFFFFF" scope="row">&nbsp;</th>
                   <th height="32" colspan="2" scope="row">
                      <form name="form5" method="post" action="">
                         <input type="submit" name="Submit2" value="查询能耗统计表" style="font-size:20px; width:150px; height:30px;">
                      </form>
                   </th>
                   <th height="32" colspan="3" scope="row">
                      <form name="form6" method="post" action="">
                         <input type="submit" name="Submit3" value="查询能耗折线图" style="font-size:20px; width:150px; height:30px;">
                      </form>
                   </th>
                   <td>&nbsp;</td>
               </tr>
               <tr bgcolor="#E1EBF5">
                   <th height="18" colspan="10" scope="row">&nbsp;</th>
                   <td colspan="2">&nbsp;</td>
                   <td>&nbsp;</td>
               </tr>
              
               <tr bgcolor="#E1EBF5" align="center"> 
                   <td height="10"  colspan="13" align="center" >
                        <div style="width:80%">
                            <table id="jqGrid"></table>
                            <div id="jqGridPager"></div>
                        </div>
                    </td>
                   
               </tr>

 
  <tr bgcolor="#E1EBF5">
    <td height="257" colspan="13" align="center">
        <div id="linechart" style="width:80%; height:500px"></div>
        <div id="piechart" style="width:80%; height:500px"></div>
    </td>
  </tr>
  
  <tr bgcolor="#E1EBF5">
    <th height="32" colspan="10" scope="row"><div align="center"></div></th>
    <td colspan="2">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>                                                                                                    
        </div>
  
  
  </div>
  <!-- 插入底部 -->  
  
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  
 
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



                var value=[];
                var label=[];
               //设置图的选项

                var option = {                		                  		
                title : {
                  	        text: '设备消耗天然气体积(m³)',
                  	        subtext: '折线图（Line Chart）',
                  	        x:'center'
                  	      },	
                    tooltip: {
                        show: true
                    },
                    //数据注释（对应数据分组的小按钮）
                    legend: {
                    	orient : 'vertical',
                        x : 'left',
                        data:[],
                    },
                    //图标右上方的工具箱设置
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
                    //x轴
                    xAxis : [
                        {
                            type : 'category',
                            data : [],
                        }
                    ],
                    //y轴
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],

                    //数据系列，要显示几个系列酒填几个大括号，不然不会显示多出的系列
                    series : [{},{}],}
                
               
                //通过ajax从后台获取图表所需数据               
               $.ajax({  
    	       //data:"name="+$("#name").val(),  
    	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新，所以有POST
    	       type:"POST", 
    	       async : false,
    	       dataType: "json",  
    	       url:"gaslinedata",  
    	       error:function(data){  
    	            //alert("出错了！！:"+data[0].name);  
    	        },  
    	        success:function(data){     	          
    	        	   option.legend.data = data.legend;  
    	        	   option.xAxis[0].data = data.category;  
    	        	   $.each(data.series,function(idx,obj){
    	        	   //赋值操作
    	        	   option.series[idx].data = data.series[idx].data; 
    	        	   option.series[idx].name = data.series[idx].name; 
    	        	   option.series[idx].type = data.series[idx].type; 
    	        	  //alert(data.series[idx].data[0]);
    	        	   })
    	          
    	          
    	        }
          }) 
               //加载选项
                 myChart.setOption(option); 

            }
            
            function drawPie(ec) {
                // 基于准备好的dom，初始化echarts图表
            	  myChart = ec.init(document.getElementById('piechart'));            	
            	 
            	  var option = {
            	      title : {
            	        text: '所选设备天然气消耗比例',
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
            	        data:[],
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
            	          //type:'pie',
            	          radius : '55%',
            	          center: ['50%', '60%'],
            	          data:[]
            	        }
            	      ]
            	    };

            	  

            	  //myChart.setOption(option);
                  $.ajax({  
           	       data:"name="+$("#name").val(),  
           	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
           	       type:"POST", 
           	       async : false,
           	       dataType: "json",  
           	       url:"gaspiedata",  
           	       error:function(data){  
           	            alert("出错了！！:"+data[0].name);  
           	        },  
           	        success:function(data){     	          
           	            var label=[];
               	        var value=[];
               	        var values=[];
           	             //alert(option.series[0].data);
           	        	 // alert(data);
           	        	 //  option.legend.data = data.legend;  
                            	        
                   	 label=data.series[0].label;
                   	 value=data.series[0].data;
                   	 $.each(label,function(idx,obj){
                   	values[idx]={'name':label[idx],'value':value[idx]}; 
                   	 })
                	
                	 //alert(values);	                   
           	        	
                   	 	
                   	 option.legend.data = data.legend;	
           	         option.series[0].data = values;
           	      option.series[0].type = data.series[0].type;
                   // alert(option.series[0].data); 
           	        }
                 }) 

            	  // 为echarts对象加载数据 
            	 myChart.setOption(option); 

            }
           
       
       
        
        
    </script>
    

      
</body>
</html>




