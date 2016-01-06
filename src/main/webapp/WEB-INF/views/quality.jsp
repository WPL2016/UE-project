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
<script src="resources/jqGrid/plugins/grid.addons.js" type="text/ecmascript"></script>

<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>质量状态</title>  

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
        <div class="blank_btw_menu_content"></div>
        <!--内容主体的div,请根据具体内容决定div的样式，table_container0最小，1次之，2最大，也可自行在div.css定义你自己想要的样式，要设置成左浮动以保证div水平排列-->     
        <div class="table_container2">
             <div class="table_head">压铸设备产品FPY查询</div>
        <form>
        <table width="100%" height="988" border="0" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
  <tr bgcolor="#E1EBF5">
    <th width="90" height="34" scope="row"><div align="left"></div>      
    <div align="center"><strong>选择时间段</strong></div></th>
    <th width="104" bgcolor="#FFFFFF" scope="row"><strong>2015-10-10</strong></th>
    <th width="28" scope="row"><strong>至</strong></th>
    <th width="99" bgcolor="#FFFFFF" scope="row"><strong>2015-12-23</strong></th>
    <th width="98" scope="row"><div align="center"><strong>选择设备</strong></div></th>
    <th width="131" bgcolor="#FFFFFF" scope="row">
      
      <div align="center">
        <select name="select" style="font-size:20px;width:100%; height:28px;">
        </select>
      </div>
    
    </th>
    <th width="96" scope="row"><div align="center"><strong>选择产品</strong></div></th>
    <th width="119" bgcolor="#FFFFFF" scope="row">
      <strong>      <select name="select2" style="font-size:20px; width:100%; height:28px;">
	    
    </select>
      </strong>
    </th>
    <td width="75"><div align="center"><strong>频率设定</strong></div></td>
    <td width="82">
      
        <div align="center">
          <select name="select3" style="font-size:20px; width:100%; height:28px;">
          </select>
        </div>
    </td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="54" colspan="4" scope="row">
        
        <div align="center">
          <input type="submit" name="Submit" value="查询产品FPY统计表" style="font-size:20px; width:200px; height:30px;">      
          </div>
    </th>
    <th height="54" colspan="3" scope="row">
      
        <div align="center">
          <input type="submit" name="Submit2" value="查询产品FPY统计折线图" style="font-size:20px; width:220px; height:30px;">
          </div>
    </th>
    <th height="54" colspan="3" scope="row">
      
        <div align="center">
          <input type="submit" name="Submit3" value="查询产品FPY统计扇形图" style="font-size:20px; width:220px; height:30px;">
        </div>
    </th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="26" colspan="10" scope="row"><span class="style3">产品FPY统计表</span></th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="176" colspan="10" scope="row">
           <div>
                <table id="jqGrid"></table>
                <div id="jqGridPager"></div>
                <button id="deldata">批量修改（如审核等）</button>
                <button id="deldata1">批量修改1（如审核等）</button>
           </div></th>
    </tr>
      <tr bgcolor="#E1EBF5">
    <th height="25" colspan="8" scope="row"><div align="right">&lt;&lt;点击查看全部 </div></th>
    <td colspan="2">
      <div align="center">
        <input type="submit" name="Submit4" value="导出统计表">
      </div>
    </td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="25" colspan="10" class="style3" scope="row">产品FPY折线统计图</th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="257" colspan="10" scope="row"><div id="linechart" style="width:100%; height:500px"></div></th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="28" colspan="8" scope="row"><div align="right">&lt;&lt;点击查看全部</div></th>
    <td colspan="2"><div align="center">
      <input type="submit" name="Submit42" value="导出折线图">
    </div></td>
  </tr>
   <tr bgcolor="#E1EBF5">
    <th height="25" colspan="10" class="style3" scope="row">产品FPY扇形统计图</th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="257" colspan="10" scope="row"><div id="piechart" style="width:100%; height:500px"></div></th>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="28" colspan="8" scope="row"><div align="right">&lt;&lt;点击查看全部</div></th>
    <td colspan="2"><div align="center">
      <input type="submit" name="Submit42" value="导出饼状图">
    </div></td>
  </tr>
  <tr bgcolor="#E1EBF5">
    <th height="32" colspan="10" scope="row"><div align="center"></div></th>
  </tr>
</table>
</form>>
        </div>
  
  
    
  
  </div>
  <!-- 插入底部 -->     
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
  
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
   
   
   
    <script type="text/javascript"> 
    $(document).ready(function () {
		  pageInit();
		  pageInit1();
		  
		});
		function pageInit(){
		  var lastsel;
		  jQuery("#jqGrid").jqGrid(
		      {
		        url : "showproduct_qual_stat_tab",
		        datatype : "json",
		         
              colNames : [  '质量测试编号', '产品编号', '产品质量测试日期', '产品质量测试结果','产品质量测试内容','产品质量测试人员编号' ],
		        colModel : [ 
		                     
		                     {name : 'product_qual_stat_num',index :'product_qual_asse_num',width : 100,align : "left",sortable :true,editable :true,key:true},
		                     {name : 'product_num',index : 'product_num',width : 100,align : "left",sortable : true,editable : true}, 
		                     {name : 'product_qual_asse_date',index : 'product_qual_asse_date',width : 100,align : "left",sortable : true,editable : true}, 
		                     {name : 'product_qual_asse_res',index : 'product_qual_asse_res',width : 100,align : "left",sortable : true,editable : true}, 
		                     {name : 'product_qual_asse_cont',index : 'product_qual_asse_cont',width : 100,sortable : true,editable : true},        		                     		  
		                     {name : 'product_qual_asse_per_num',index : 'product_qual_asse_per_num',width : 150,sortable : true,editable : true}, 

		                   ],
		                   
		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
	        
		        loadonce:true,
		        //当加载出错时提供错误信息
		        loadError: function(xhr,status,error){  
		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  

		        caption:"产品测试统计记录表", //height : 80,align : "center",
		       
		        prmNames: { id: "product_qual_stat_num" },
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
		        editurl : "editproduct_qual_stat_tab",
		       
		      });
		  
		   $('#jqGrid').navGrid('#jqGridPager',
	                // the buttons to appear on the toolbar of the grid
	                { edit: true, add: true, del: true, search: true, refresh: true, view: false, position: "left", cloneToTop: false },
	                // options for the Edit Dialog
	                {
	                    editCaption: "The Edit Dialog",
	                    recreateForm: true,
						checkOnUpdate : true,
						checkOnSubmit : true,
	                    closeAfterEdit: true,
	                    //出错时返回提示
	                    errorTextFormat: function (data) {
	                    	var message="服务器异常，请稍后尝试！";
	                    	var result=data.statusText;
	                    	if(result=="Not Found") message="无法找到资源，请联系系统管理员！";
	                    	else if(result=="Forbidden") message="您没有权限执行此操作，请联系上级或申请相应权限！";
	                        alert(message);
	                    },
	                //执行完毕进行提示和更新数据  
	                afterComplete:function(xhr){      
	                	         //提示操作结果
	                	                  
	                             alert("操作成功！");
	                             //更新表格数据，因为之前设置了loadonce，所以datatype自动转换成了local，所以一般的reload都无效，
	                             //必须先改回原先的数据数据类型
	                             $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

	                              },
	                },
	                // options for the Add Dialog
	                {
	                	
	                	
	                   // recreateForm: true,
	                   //出错时返回信息
	                    errorTextFormat: function (data) {
	                    	var message="服务器异常，请稍后尝试！";
	                    	var result=data.statusText;
	                    	if(result=="Not Found") message="无法找到资源，请联系系统管理员！";
	                    	else if(result=="Forbidden") message="您没有权限执行此操作，请联系上级或申请相应权限！";
	                        alert(message);
	                   },
	                   
	                 //执行完毕进行提示和更新数据  
	                afterComplete:function(xhr){      
	                	         //提示操作结果
	                	                  
	                             alert("操作成功！");
	                             //更新表格数据，因为之前设置了loadonce，所以datatype自动转换成了local，所以一般的reload都无效，
	                             //必须先改回原先的数据数据类型
	                             $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

	                              },
	                 closeAfterAdd: true,            
	                                   	               
	                },
	                // options for the Delete Dailog
	                {

	                	
	                	errorTextFormat: function (data) {
	                    	var message="服务器异常，请稍后尝试！";
	                    	var result=data.statusText;
	                    	if(result=="Not Found") message="无法找到资源，请联系系统管理员！";
	                    	else if(result=="Forbidden") message="您没有权限执行此操作，请联系上级或申请相应权限！";
	                        alert(message);
	                    },
	                //执行完毕进行提示和更新数据  
	                afterComplete:function(xhr){      
	                	         //提示操作结果
	                	                  
	                             alert("操作成功！");
	                             //更新表格数据，因为之前设置了loadonce，所以datatype自动转换成了local，所以一般的reload都无效，
	                             //必须先改回原先的数据数据类型
	                             $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

	                              },
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
		 
		   //批量修改
		   $("#deldata").click(function() {
			   //alert("Please Select Row to delete!1")
			   var gr = $("#jqGrid").jqGrid('getGridParam', 'selarrrow');
			   
			    if ((gr != null)&&(gr !="")){
			    
			   // alert("Please Select Row to delete!2"+gr)
			  
			    //自定义ajax访问实现批量操作
	            $.ajax({  
                       data:{"equip_num":""+gr,"column_value":99,"oper":"batch_edit","column_name":"product_num"},  
                       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
                       type:"POST",  
                       dataType:'json',  
                       url:"editproduct_qual_stat_tab",  
                       error:function(data){  
                       //alert("出错了！！:"+data[0].name);  
                                           },  
                       success:function(data){  
                      	
                      	 // alert("成功！！:"+data[0].name);
                       }
                                             
                       })   
			    //var selected=gr.split(',');
			    	//   $.each(selected,function(i,n){
					//	 if(selected[i]!="")  $("#jqGrid").jqGrid('delGridRow',n,{}); 
				//$.each(gr,function(key,val){
				//    $("#jqGrid").jqGrid('setRowData',gr[0],{equip_sup:"79800"}).trigger('reloadGrid');   
				//    $("#jqGrid").jqGrid('saveRow', gr[0], {equip_sup:"79800"} );  
				//	 $("#jqGrid").jqGrid('saveRow', gr[0],{equip_sup:"79800"});
		           
			    //	            })
			       alert("操作成功！"); 
			      $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
			    	            }
			
			    else {alert("请选择要删除的行")}
			    
			  });
		 
		   //批量修改
		   $("#deldata1").click(function() {
			   //alert("Please Select Row to delete!1")
			   var gr = $("#jqGrid").jqGrid('getGridParam', 'selarrrow');
			   
			    if ((gr != null)&&(gr !="")){
			    	
			   // alert("Please Select Row to delete!2"+gr)
			  
			    //自定义ajax访问实现批量操作
	            $.ajax({  
                       data:{"equip_num":""+gr,"column_value":1,"oper":"batch_edit","column_name":"product_num"},  
                       //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
                       type:"POST",  
                       dataType:'json',  
                       url:"editproduct_qual_stat_tab",  
                       error:function(data){  
                       //alert("出错了！！:"+data[0].name);  
                                           },  
                       success:function(data){  
                      	 
                      
                      	 //alert("成功！！:"+data[0].name);
                      	
                       }
                                             
                       })   
			    //var selected=gr.split(',');
			    	//   $.each(selected,function(i,n){
					//	 if(selected[i]!="")  $("#jqGrid").jqGrid('delGridRow',n,{}); 
				//$.each(gr,function(key,val){
				//    $("#jqGrid").jqGrid('setRowData',gr[0],{equip_sup:"79800"}).trigger('reloadGrid');   
				//    $("#jqGrid").jqGrid('saveRow', gr[0], {equip_sup:"79800"} );  
				//	 $("#jqGrid").jqGrid('saveRow', gr[0],{equip_sup:"79800"});
		           
			    //	            })
			      alert("操作成功！"); 
			      $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
			 
			    	            }
			    else {alert("请选择要编辑的行")}
			   
			  });
		 	    	
		}
		
        		
        		
   </script>
   
</body>
</html>




