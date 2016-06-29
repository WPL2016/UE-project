<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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

<script src="resources/jquery-ui.js"></script>

<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>电能消耗</title>  

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


<script>
 $(function() {

            $.datepicker.regional["zh-CN"] = { closeText: "关闭", prevText: "&#x3c;上月", nextText: "下月&#x3e;", currentText: "今天", monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"], monthNamesShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"], dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"], dayNamesShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六"], dayNamesMin: ["日", "一", "二", "三", "四", "五", "六"], weekHeader: "周", dateFormat: "yy-m-d", firstDay: 1, isRTL: !1, showMonthAfterYear: !0, yearSuffix: "年" }

                         

            $.datepicker.setDefaults($.datepicker.regional["zh-CN"]);
 })
</script>

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

<script>
$(document).ready(function(){
    $("#starttime").datepicker({showWeek:true, firstDay:1,  changeMonth:true,
	      changeYear:true,});
    $("#endtime").datepicker({showWeek:true, firstDay:1,  changeMonth:true,
	      changeYear:true,});
})
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
                                                                                                         
          <div class="table_head">电能消耗状态</div>
          <table width="100%" height="798" border="0" cellpadding="0" cellspacing="0">        
          <tr><td>
          
          <label>选择起始时间:</label>
 <input type="text" id="starttime" style="width:70px;height:15px;font-size-3;z-index:1000;position:relative" ></input>
            <label>选择结束时间:</label>
 <input type='text' id='endtime' style='width:70px;height:15px;font-size-3;z-index:1000;position:relative'></input>

      <select style='width:80px;height:25px;font-size-3' id="timechoice">
         	          <option value="0">按日汇总</option><option value="1">按月汇总</option><option value="2">按年汇总</option></select>
        <c:forEach var="equip_tab" items="${electricequip}">
	      <input type="checkbox" id="equip_selected" name="equip_selected" value="${equip_tab.equip_num}">${equip_tab.equip_name}</input> </c:forEach>
             <input type="button" id="search" onClick="drawBar(),drawPie()">查询</input>
           </td></tr>
          
               <tr bgcolor="#E1EBF5">
                   <th height="35" colspan="10" scope="row"><div align="center"><strong><span class="style1"> 设备电能消耗查询</span></strong></div></th>
                   <td colspan="2">&nbsp;</td>
                   <td width="50">&nbsp;</td>
               </tr>

<tr><td colspan="13">
 <table id="jqGrid"></table>
 <div id="jqGridPager"></div>
</td></tr>

 
  <tr bgcolor="#E1EBF5">
    <td height="257" colspan="13" align="center">
        <div id="linechart" style="width:80%; height:500px"></div>
        <div id="piechart" style="width:80%; height:500px"></div>
    </td>
  </tr> 
  
  
</table>                                                                                                    
        </div>
    </div>
 
  <!-- 插入底部 -->  
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  

<script type="text/javascript">        

$(document).ready(function () {
     		  
	pageInit();
        	
        		});


        		function pageInit(){
        		  var lastsel;
        		  var chk_value =[];  
        		  jQuery("#jqGrid").jqGrid(
        		      {
        		        url : "showenergy_tab?starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"&timechoice="+$("#timechoice").val()+"&equip_selected="+chk_value,
        		        datatype : "json",
        		        colNames : [  '设备名称', '电能消耗时间','电能消耗值(千瓦时)'],
        		        colModel : [ 

        		                     {name : 'name',index :'name',width : 90,align : "center",sortable :false,editable : false,key:true},
        		                     {name : 'time',index : 'time',width : 150,align : "center",sortable :false,editable : false}, 
        		                     {name : 'val',index : 'val',width : 90,align : "center",sortable :false,editable : false},        		                 
        		                  

        		                            		                     
        		                   ],
        		                   
        		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
        	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
        	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
        	        
        		        loadonce:true,
        		        //当加载出错时提供错误信息
        		      //  loadError: function(xhr,status,error){  
        		      //  	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


        		        caption:"", height : 80,align : "center",

        		       

        		        prmNames: { id: "equip_num" },
        		        rowNum : 20,
        		        height:300,
        		        rowList : [ 20, 40, 60 ],
        		        pager : '#jqGridPager',
        		        multiselect:true,
        		        sortname :'name',
        		        viewrecords : true,
        		        sortorder : "desc",
        		        autowidth:true,
        		        onSelectRow : function(id) {
        		          if (id && id !== lastsel) {
        		            jQuery('#jqGrid').jqGrid('restoreRow', lastsel);
        		            jQuery('#jqGrid').jqGrid('editRow', id, true);
        		            lastsel = id;
        		          }
        		        },
        		      //  editurl : "editequip_tab",
        		       
        		      });
        		  
        		   $('#jqGrid').navGrid('#jqGridPager',
        	                // the buttons to appear on the toolbar of the grid
        	                { edit: false, add: false, del: false, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
        	              
        	                // options for the Search Dailog
        	                {
        	                	multipleSearch:true,
        	                	multipleGroup:true,
        	                	recreateForm: true,
        	                	closeAfterSearch: true,       	            
        	                	errorTextFormat: function (data) {
        	                        return '搜索失败，请重新尝试!'+ data.responseText
        	                    }
        	                 }
        	                );
        		   $("#search").click(function(){
        			   var chk_value =[];  
        			   $('input[name=equip_selected]:checked').each(function(){   
        			      chk_value.push($(this).val());
        			              });
        			   $("#jqGrid").setGridParam({url : "showenergy_tab?starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"&timechoice="+$("#timechoice").val()+"&equip_selected="+chk_value,datatype:'json', page:1}).trigger('reloadGrid')});
        		  
        		          		          		 
        			    	
        		}
        		
        	
          		          		          		 
          		
        		
   </script>
  
 
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
            	
            drawBar();
            drawPie();
             }
            
           

            function drawBar() {
                // 基于准备好的dom，初始化echarts图表
                //var myChart = ec.init(document.getElementById('linechart')); 
                var dom=document.getElementById('linechart');
                var myChart=require('echarts').init(dom);


                var value=[];
                var label=[];
               //设置图的选项

                var option = {                		                  		
                title : {
                  	        text: '设备电能消耗总量(千瓦时)',
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
                
                 var chk_value =[];   
           $('input[name=equip_selected]:checked').each(function(){   
              chk_value.push($(this).val());
                      });
                
                
               $.ajax({  
            	   data:"starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"&timechoice="+$("#timechoice").val()+"&equip_selected="+chk_value,
        	       
    	       //data:"name="+$("#name").val(),  
    	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新，所以有POST
    	       type:"POST", 
    	       async : false,
    	       dataType: "json",  
    	       url:"energylinedata",  
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
            
            function drawPie() {
                // 基于准备好的dom，初始化echarts图表
            	 // myChart = ec.init(document.getElementById('piechart'));            	
            	  var dom=document.getElementById('piechart');
             var myChart=require('echarts').init(dom);
            	  var option = {
            	      title : {

            	        text: '所选设备电能消耗比例',

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

            	  var chk_value =[];   
                  $('input[name=equip_selected]:checked').each(function(){   
                     chk_value.push($(this).val());
                             });

            	  //myChart.setOption(option);
                  $.ajax({  
                	 data:"starttime="+$("#starttime").val()+"&endtime="+$("#endtime").val()+"&timechoice="+$("#timechoice").val()+"&equip_selected="+chk_value,
            	         
           	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
           	       type:"POST", 
           	       async : false,
           	       dataType: "json",  
           	       url:"energypiedata",  
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




