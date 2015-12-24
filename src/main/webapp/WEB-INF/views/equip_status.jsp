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

<script src="resources/jquery-ui.js"></script>
<!--重写jqgrid的样式，修改toolbar的高度  -->
<style>
.ui-jqgrid .ui-userdata {
    height: 60px; /* default value in ui.jqgrid.CSS is 21px */
}
</style>


<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>基础模板</title>  



<script type="text/javascript">  
<!--ajax访问时发送csrf token，以防止ajax访问被crsf过滤器拦截   -->
$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});	
   });
   
$(document).ready(operStateAjax);
$(document).ready(operStateTimeAjax);
$(document).ready(dynamStateAjax);
$(document).ready(preSetStateAjax);
setInterval(operStateAjax,1333000);
setInterval(operStateTimeAjax,1333000);
setInterval(dynamStateAjax,1333000);
setInterval(preSetStateAjax,1333000);


 function operStateAjax(){
	  $.ajax({  
     	// data:"name="+$("#name").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'json',  
	        url:"showequip_oper_stat_tab", 
	        async:true,
	        error:function(data){  
	            //alert("出错了！！:"+data[0].name);  
	        },  
	        success:function(data){  
	        	//alert("这是提示！！:"+data[0].name);  
	        	var records=0;
	        	var alertreason;
	        	var alerttime;
	        	var stopreason;
	        	var stoptime;
	        	var a =document.createElement('link');
                a.type='text/css';
                a.rel='stylesheet';
           
                document.head.appendChild(a);
	           var htmlstr="<table id='customers'><tr><td class='title' colspan='4'>压铸机运行状态</td></tr><tr>"+
	           "<td>当前状态</td><td colspan='3' class='value'>"+data[0].stat_name+"</td></tr><tr>"+
	           "</tr><tr><td>最新状态转变点</td></tr><tr>"
	           $.each(data,function(idx,obj){
	        	   
	        	   if(obj.stat_name=="报警") {
	        		   //alert("报警了"+obj.stat_name+""+idx+""+obj.stat_time);
	        		   alertreason=obj.stat_reason;
        	           alerttime=obj.stat_time;}
	        	   else{
	        		  // alert(obj.stat_name+""+idx);
	        		  //alert(obj.stat_name+""+obj.stat_reason+""+records+""+obj.stat_time+""+data[idx].stat_name);
	        		 htmlstr=htmlstr+"<td>"+obj.stat_name+"</td><td class='value'>"+obj.stat_time+"</td>";
	        		 records++;
	        		 if(obj.stat_name=="停机") stopreason=obj.stat_reason;
	        		 if (records%2==0)  htmlstr=htmlstr+"</tr><tr>";}
	        	 
	        	    
	        	  
	    
	           })
	          // var htmlstr="</table>"
	          // htmlstr=htmlstr+data.msg;
	         
	          if(records%2!=0){ htmlstr=htmlstr+"<td>报警</td><td class='value'>"+alerttime+"</td></tr>";}
	          else {htmlstr=htmlstr+"</tr><tr><td>报警</td><td class='value'>"+alerttime+"</td></tr>";} 
	          htmlstr=htmlstr+"<tr><td>停机原因</td><td colspan='4' class='reason'>"+stopreason+"</td></tr>";
	          htmlstr=htmlstr+"<tr><td>报警原因</td><td colspan='4' class='reason'>"+alertreason+"</td></tr></table>";
	           $("#cloneTr0").html(htmlstr);
	                        
	                               
	    }  
     })
 }
 
 function operStateTimeAjax(){
	  $.ajax({  
    	 //data:"name="+$("#name").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'json',  
	        url:"todayequip_oper_stat_tab", 
	        async:true,
	        error:function(data){  
	            alert("出错了！！:"+data[0].name);  
	        },  
	        success:function(data){  
	        	//alert("这是提示！！:"+data.totalalerttime);  
	        	
	        	
	         //  var a =document.createElement('link');
             //  a.type='text/css';
             // a.rel='stylesheet';
          
             //  document.head.appendChild(a);
	           var htmlstr="";
	           htmlstr=htmlstr+"<table id='customers'>"+
	           "<tr><td>今日累计停机时间</td><td class='value'>"+data.totalstoptime+"</td><td>今日累计开机时间</td><td class='value'>"+data.totalstarttime+"</td></tr>"+
	           "<tr><td>今日累计待机时间</td><td class='value'>"+data.totalwaittime+"</td><td>今日累计报警时间</td><td class='value'>"+data.totalalerttime+"</td></tr>";
	           htmlstr=htmlstr+"</table>";
	           $("#cloneTr1").html(htmlstr);
	                        
	                               
	    }  
    })
}
 
 
 function dynamStateAjax(){
	  $.ajax({  
    	 //data:"name="+$("#name").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'json',  
	        url:"showequip_dyn_para_tab", 
	        async:true,
	        error:function(data){  
	            //alert("出错了！！:"+data[0].name);  
	        },  
	        success:function(data){  
	        	//alert("这是提示！！:"+data[0].name);  
	        	var records=0;
	        	var alertreason;
	        	var alerttime;
	        //	var a =document.createElement('link');
            //   a.type='text/css';
             //  a.rel='stylesheet';
          
             //  document.head.appendChild(a);
	           var htmlstr="<table id='customers'><tr><td class='title' colspan='4'>压铸机动态参数</td></tr><tr>"
	        	   $.each(data,function(idx,obj){
		        	   
		        	  
		        	   
		        		  // alert(obj.stat_name+""+idx);
		        		  //alert(obj.stat_name+""+obj.stat_reason+""+records+""+obj.stat_time+""+data[idx].stat_name);
		        		 htmlstr=htmlstr+"<td>"+obj.equip_para_tab.para_name+"</td><td class='value'>"+obj.equip_dyn_para_tab.dyn_para_val+"  "+obj.equip_para_tab.para_unit+"</td>";
		        		 records++;
		        		
		        		 if (records%2==0)  htmlstr=htmlstr+"</tr><tr>";
		        	 
		        	    
		        	  
		    
		           })
	          // var htmlstr="</table>"
	          // htmlstr=htmlstr+data.msg;
	         
	         
	          htmlstr=htmlstr+"</tr></table>";
	           $("#cloneTr2").html(htmlstr);
	                        
	                               
	    }  
    })
}
 
 function preSetStateAjax(){
	 $.ajax({  
    	 //data:"name="+$("#name").val(),  
	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	       type:"POST",  
	       dataType:'json',  
	        url:"showequip_pres_para_tab", 
	        async:true,
	        error:function(data){  
	            //alert("出错了！！:"+data[0].name);  
	        },  
	        success:function(data){  
	        	//alert("这是提示！！:"+data[0].name);  
	        	
	        	var records=0;
	        	var a =document.createElement('link');
              // a.type='text/css';
             //  a.rel='stylesheet';
          
              // document.head.appendChild(a);
	           var htmlstr="<table id='customers'><tr><td class='title' colspan='4'>压铸机动态参数</td></tr><tr>"
	        	   $.each(data,function(idx,obj){
		        	   
	        		   //alert(obj.equip_pres_para_tab.pres_para_val);
		        	   
		        		  // alert(obj.stat_name+""+idx);
		        		  //alert(obj.stat_name+""+obj.stat_reason+""+records+""+obj.stat_time+""+data[idx].stat_name);
		        		 htmlstr=htmlstr+"<td>"+obj.equip_para_tab.para_name+"</td><td class='value'>"+obj.equip_pres_para_tab.pres_para_val+"  "+obj.equip_para_tab.para_unit+"</td>";
		        		 records++;
		        		
		        		 if (records%2==0)  htmlstr=htmlstr+"</tr><tr>";
		        	 
		        	    
		        	  
		    
		           })
	          // var htmlstr="</table>"
	          // htmlstr=htmlstr+data.msg;
	         
	         
	          htmlstr=htmlstr+"</tr><tr><td class='title' colspan='4'>设备维护保养记录</td></tr></table>";
	          
	           $("#cloneTr3").html(htmlstr);
	                        
	                               
	    }  
   })
}
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
        <div class="table_container0">    
         <div class="table_head">压铸机设备状态</div> 
         <table id="customers">         
         <tr><td><div id="cloneTr0"></div></td></tr>
         </table>
         <table id="customers">         
         <tr><td><div id="cloneTr1"></div></td></tr>
         </table>
          <table id="customers">         
         <tr><td><div id="cloneTr2"></div></td></tr>
         </table>
     <table id="customers">         
         <tr><td><div id="cloneTr3"></div></td></tr>
         </table>
                  <div>
                  <table id="jqGrid"></table>
                  <div id="jqGridPager"></div>
                  </div>
       </div>
      <div class="blank_btw_table"></div>
     
      <div class="table_container1">
           <div class="table_head">设备OEE分析</div>
           
           <table width="100%" height="798" border="0" cellpadding="0" cellspacing="0">
             
               <tr bgcolor="#E1EBF5">
                   <th height="26" colspan="10" scope="row"><span class="style3">压铸设备OEE统计表</span></th>
                   <td colspan="2">&nbsp;</td>
                   <td>&nbsp;</td>
               </tr>
               <tr bgcolor="#E1EBF5" align="center"> 
                   <td height="275"  colspan="13" align="center" >
                        <div style="width:80%">
                            <table id="jqGrid1"></table>
                            <div id="jqGridPager1"></div>
                            
                        </div>
                    </td>
                   
               </tr>
  <tr bgcolor="#E1EBF5">
    
  </tr>
 
  
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
        		  pageInit1();
        		  
        		});
        		function pageInit(){
        		  var lastsel;
        		  jQuery("#jqGrid").jqGrid(
        		      {
        		        url : "showemaint_reg_tab",
        		        datatype : "json",
        		        colNames : [  '维修编号', '维修日期', '维修人员', '维修设备', '维修内容' ],
        		        colModel : [ 
        		                     
        		                     {name : 'maint_reg_num',index :'maint_reg_num',width:80,sortable :true,editable :false,key:true},
        		                     {name : 'maint_reg_date',index : 'maint_reg_date',width:100,sortable : true,editable : false,formatter: 'date', formatoptions: { newformat: 'Y/m/d' }, editable: false, searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker();}}}, 
        		                          		                 
        		                     {name : 'maint_reg_per_num',index : 'maint_reg_per_num',width:80,sortable : true,editable : false},        		  
        		                     {name : 'maint_reg_obj_num',index : 'maint_reg_obj_num',width:80,sortable : true,editable :false}, 
        		                     {name : 'maint_reg_cont',index : 'maint_reg_cont',width:320,sortable : true,editable : false}, 
        		                   ],
        		                   
        		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
        	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
        	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
        	        
        		        loadonce:true,
        		        //当加载出错时提供错误信息
        		      
        		        //caption:"原材料使用状况", //height : 80,align : "center",
        		       
        		        prmNames: { id: "maint_reg_num" },
        		        rowNum : 20,
        		        height:300,
        		        rowList : [ 20, 40, 60 ],
        		        pager : '#jqGridPager',
        		        //multiselect:true,
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
        		        editurl : "editequip_tab",
        		       
        		      });
        		  
        		   $('#jqGrid').navGrid('#jqGridPager',
        				// the buttons to appear on the toolbar of the grid
         	                { edit: false, add: false, del: false, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
         	                // options for the Edit Dialog
         	                {
         	                },
         	                // options for the Add Dialog
         	                {       
         	                                   	               
         	                },
         	                // options for the Delete Dailog
         	                {

         	                },
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
        		
        		 

        		 
        		  
        		 
        		          		          		 
        			    	
        		}
        		
        		function pageInit1(){
          		  var lastsel;
          		  jQuery("#jqGrid1").jqGrid(
          		      {
          		        url : "showequip_tab",
          		        datatype : "json",
          		        colNames : [  '设备编号', '辅助设备', '辅助设备编号', '设备记录编号', '设备名称' ],
          		        colModel : [ 
          		                     
          		                     {name : 'equip_num',index :'equip_num',width : 90,sortable :true,editable :false,key:true},
          		                     {name : 'equ_equip_num',index : 'equ_equip_num',width : 80,sortable : true,editable :false}, 
          		                     {name : 'equip_sup',index : 'equip_sup',width : 90,sortable : true,editable : false},        		                 
          		                     {name : 'equip_recorder_num',index : 'equip_recorder_num',width : 80,sortable : true,editable : false},        		  
          		                     {name : 'equip_name',index : 'equip_name',width : 150,sortable : true,editable : false}, 
          		                     
          		                   ],
          		                   
          		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
          	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
          	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
          	        
          		        loadonce:true,
          		        //当加载出错时提供错误信息
          		        loadError: function(xhr,status,error){  
          		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  

          		        //caption:"原材料使用状况", //height : 80,align : "center",
          		       
          		        prmNames: { id: "equip_num" },
          		        rowNum : 20,
          		        height:300,
          		        rowList : [ 20, 40, 60 ],
          		        pager : '#jqGridPager1',
          		       // multiselect:true,
          		        sortname :'name',
          		        viewrecords : true,
          		        sortorder : "desc",
          		        autowidth:true,
          		        toolbar : [ true,"top",1000],

          		        onSelectRow : function(id) {
          		          if (id && id !== lastsel) {
          		            jQuery('#jqGrid1').jqGrid('restoreRow', lastsel);
          		            jQuery('#jqGrid1').jqGrid('editRow', id, true);
          		            lastsel = id;
          		          }
          		        },
          		        editurl : "editequip_tab",
          		       
          		      });
          		  
          		   $('#jqGrid1').navGrid('#jqGridPager1',
          	                // the buttons to appear on the toolbar of the grid
          	                { edit: false, add: false, del: false, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
          	                // options for the Edit Dialog
          	                {
          	                },
          	                // options for the Add Dialog
          	                {       
          	                                   	               
          	                },
          	                // options for the Delete Dailog
          	                {

          	                },
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
          		 
          		   $("#t_jqGrid1")
         	      .append(
         	          "<table><tr><td><label>选择设备:</label></td><td><select style='width:140px;height:25px;font-size:-3'>"+
         	          "<option>五连杆给汤机</option><option>压铸机1号</option></select></td>"+
         	          "<td><label>选择时间分段:</label></td><td><select style='width:140px;height:25px;font-size-3'>"+
         	          "<option>按日汇总</option><option>按周汇总</option><option>按月汇总</option><option>按年汇总</option></select></td></tr>"+
         	          "<tr><td><label>选择起始时间:</label></td><td><input type='text' id='starttime' style='width:140px;height:15px;font-size-3'></input></td><td><label>选择结束时间:</label></td><td><input type='text' id='endtime' style='width:140px;height:15px;font-size-3'></input><td></tr></table>");
         	  $("#starttime", "#t_jqGrid1").click(  $("#starttime").datepicker({
         	      showWeek: true,
         	      firstDay: 1
         	    }))
         	      $("#endtime", "#t_jqGrid1").click(  $("#endtime").datepicker({
         	      showWeek: true,
         	      firstDay: 1
         	    }))
         	   
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
                  	        text: 'OEE分析折线图图',
                  	        //subtext: '折线图（Line Chart）',
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
                    series : [{},{}]
                };
             
                  
               
                //通过ajax从后台获取图表所需数据               
               $.ajax({  
    	       //data:"name="+$("#name").val(),  
    	       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新，所以有POST
    	       type:"POST", 
    	       async : false,
    	       dataType: "json",  
    	       url:"echartlinedata",  
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
            	        text: 'OEE分析饼图',
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
           	       url:"echartpiedata",  
           	       error:function(data){  
           	            //alert("出错了！！:"+data[0].name);  
           	        },  
           	        success:function(data){     	          
           	            var label=[];
               	        var value=[];
               	        var values=[];
           	            
           	        	  
           	        	 //  option.legend.data = data.legend;  
                            	        
                   	 label=data.series[0].label;
                   	 value=data.series[0].data;
                   	 $.each(label,function(idx,obj){
                   	values[idx]={'name':label[idx],'value':value[idx]}; 
                   	 })
                	
                	               
           	        	
                   	 	
                   	 option.legend.data = data.legend;	
           	         option.series[0].data = values;
           	         option.series[0].type = data.series[0].type;
                   
           	        }
                 }) 
            	  // 为echarts对象加载数据 
            	 myChart.setOption(option); 

            }
               
    
       
        
        
    </script>
    
  
</body>
</html>




