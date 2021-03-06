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

<!-- 添加csrf标记，防止crsf安全过滤器无法识别ajax访问的crsf_token-->
<meta http-equiv="Content-Type" content="text/html; charset=utf8">  
<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>生产计划</title>  
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
 
<script type="text/javascript">
        
			    	 	
                function workPlanDecom(day_plan_num,plan_status){
                	if(plan_status=="1"){
                	window.open ("towork_plan_decom?day_plan_num="+day_plan_num,'newwindow','height=1000,width=1000,top=400,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
                	}
                	else alert("只能分解已经发布且未经分解的计划");
                	}        
			//完成生产计划   	
			function planFinish(id,plan_status) {
			    if((plan_status=="3")||(plan_status=="4")){
				$.ajax({  
			    data:{"produce_plan_num":""+id,"column_value":"5","oper":"batch_edit","column_name":"plan_status"},  
			 //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
		        type:"POST",  
			    dataType:'json',  
			    url:"editproduce_plan_tab",  
			    error:function(data){  
		     //alert("出错了！！:"+data[0].name);  
			    	                },  
			    success:function(data){  
			    	                      	
	         // alert("成功！！:"+data[0].name);
			    	  }
			    	                                             
			    	})   
			    				    
		         alert("操作成功！"); 
			    $("#jqGrid").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
			    }
			    else alert("只能确认执行过的生产计划！");
			    }
			 function workPlanPublish(id,plan_status) {
      		    if(plan_status=="0"){
				 $.ajax({  
                     data:{"work_plan_num":""+id,"column_value":"1","oper":"batch_edit","column_name":"plan_status"},  
                     //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
                     type:"POST",  
                     dataType:'json',  
                     url:"editwork_plan_tab",  
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
			      $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
			      $("#jqGrid3").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
			    	}
			    	else alert("不能重复发布已经发布过的计划！");
			    	}
			   	 function workPlanFinish(id,plan_status) {
		      		 if((plan_status=="3")||(plan_status=="4")){
			   		 $.ajax({  
		                     data:{"work_plan_num":""+id,"column_value":"5","oper":"batch_edit","column_name":"plan_status"},  
		                     //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
		                     type:"POST",  
		                     dataType:'json',  
		                     url:"editwork_plan_tab",  
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
					      $("#jqGrid3").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
					    	}
					    	else alert("只能确认已经执行过的计划！");
					 
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
      <div class="table_container2">
           
                 
                <div class="table_head">日生产计划（发布后）</div>  
                                   
                  <table id="jqGrid1"></table>
                  <div id="jqGridPager1"></div>
                   <div class="table_head">作业计划（发布前）</div>  
                                   
                  <table id="jqGrid2"></table>
                  <div id="jqGridPager2"></div>
                  
                  <div class="table_head">作业计划（发布后）</div>  
                                   
                  <table id="jqGrid3"></table>
                  <div id="jqGridPager3"></div>
                  <!--  
                  <button id="execute">发布</button>
                  <button id="finish">分解成日计划</button>
                  <button id="finish">确认完成</button>
                  -->
            </div>
       </div>
   
      
      
  
  
  <script type="text/javascript"> 
        $(document).ready(function () {
        	
        		  pageInit1();
        		  pageInit2();
        		  pageInit3();
        		});
        		
        		function pageInit1(){
          		  var lastsel;
          		  jQuery("#jqGrid1").jqGrid(
          		      {
          		        url : "showday_plan_tab?plan_status_type=pubed",
          		        datatype : "json",
          		        colNames : [  '日生产计划编号','生产计划编号', '产品名称','产品编号','计划数量', '计划状态 ','计划日期', '制定日期','制定人','操作'],
          		        colModel : [ 
          		                     {name : 'day_plan_num',index :'day_plan_num',width : 150,align : "center",sortable :true,editable : true,key:true},
          		                     {name : 'produce_plan_num',index :'produce_plan_num',width : 150,align : "center",sortable :true,editable : true},
          		                     {name : 'product_name',index :'product_name',width : 150,align : "center",sortable :true,editable : true},
        		                     {name : 'product_num', index :'product_num', width : 150,align : "center",sortable :true,editable : true},        		                
          		                     {name : 'plan_quan',index : 'plan_quan',width : 70,align : "center",sortable : true,editable : true},  
          		                     {name : 'plan_status',index : 'plan_status',width : 150,align : "center",sortable : true,editable : false,formatter:'select', editoptions:{value:'0:未发布;1:已发布;2:已分解;3:执行中;4:执行中断;5:已完成'}},   
          		                     {name : 'plan_date',index : 'plan_date',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
          		                     {name : 'edit_time',index : 'edit_time',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
          		                     {name : 'day_plan_recorder_num',index : 'day_plan_recorder_num',width : 150,align : "center",sortable : true,editable : false},
          		                     {name : 'operate',index : 'operate',width : 300,align : "center",sortable : false,editable : false, formatter: function (value, grid, rows, state) { return "<button onclick='workPlanDecom("+rows.day_plan_num+","+rows.plan_status+")'>分解</button>&nbsp&nbsp&nbsp<button onclick='planFinish("+rows.day_plan_num+","+rows.plan_status+")'>完成</button>" },}
          		                  
          		                     
          		                     
          		                   ],
          		                   
          		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
          	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
          	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
          	        
          		        loadonce:true,
          		        //当加载出错时提供错误信息
          		        loadError: function(xhr,status,error){  
          		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


          		        caption:"", height : 80,align : "center",

          		       

          		        prmNames: { id: "day_plan_num" },
          		        rowNum : 20,
          		        height:300,
          		        rowList : [ 20, 40, 60 ],
          		        pager : '#jqGridPager1',
          		       // multiselect:true,
          		        sortname :'day_plan_num',
          		        viewrecords : true,
          		        sortorder : "desc",
          		        autowidth:true,
          		        onSelectRow : function(id) {
          		          if (id && id !== lastsel) {
          		            jQuery('#jqGrid1').jqGrid('restoreRow', lastsel);
          		            jQuery('#jqGrid1').jqGrid('editRow', id, true);
          		            lastsel = id;
          		          }
          		          
          		        //生成从表
          		        produce_plan_num_sel=id; 	
          		        $("#jqGrid2").setGridParam({datatype:'json', page:1,url:"showwork_plan_tab?day_plan_num="+id+"&plan_status_type=unpub"}).trigger('reloadGrid');
          		        $("#jqGrid3").setGridParam({datatype:'json', page:1,url:"showwork_plan_tab?day_plan_num="+id+"&plan_status_type=pubed"}).trigger('reloadGrid');
          		        },
          		        editurl : "editday_plan_tab",
          		       
          		      });
          		  
          		   $('#jqGrid1').navGrid('#jqGridPager1',
          	                // the buttons to appear on the toolbar of the grid
          	                { edit: true, add: true, del: true, search: true, refresh: true, view: false, position: "left", cloneToTop: false },
          	                // options for the Edit Dialog
          	                {
          	                    editCaption: "编辑记录",
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
          	                             $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
          	                             $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
          	                             $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
          			   var gr = $("#jqGrid1").jqGrid('getGridParam', 'selarrrow');
          			   
          			    if ((gr != null)&&(gr !="")){
          			    
          			   // alert("Please Select Row to delete!2"+gr)
          			  
          			    //自定义ajax访问实现批量操作
          	            $.ajax({  
  	                             data:{"produce_plan_num":""+gr,"column_value":99,"oper":"batch_edit","column_name":"equip_product_relat_num"},  
  	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
  	                             type:"POST",  
  	                             dataType:'json',  
  	                             url:"editproduce_plan_tab",  
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
          			      $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
          			    	            }
          			
          			    	
          			    else {alert("请选择要删除的行")}
          			    
          			    
          			   
          			  });
          		 
          		   //批量修改
          		   $("#execute").click(function() {
          			   //alert("Please Select Row to delete!1")
          			   var gr = $("#jqGrid1").jqGrid('getGridParam', 'selarrrow');
          			   
          			    if ((gr != null)&&(gr !="")){
          			    	
          			   // alert("Please Select Row to delete!2"+gr)
          			  
          			    //自定义ajax访问实现批量操作
          	            $.ajax({  
  	                             data:{"produce_plan_num":""+gr,"column_value":"执行中","oper":"batch_edit","column_name":"plan_status"},  
  	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
  	                             type:"POST",  
  	                             dataType:'json',  
  	                             url:"editproduce_plan_tab",  
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
          			      $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
          			 
          			    	            }
          			    else {alert("请选择要编辑的行")}
          			   
          			    
          			   
          			    
          			  });
          		 
          		   //批量修改
          		   $("#finish").click(function() {
          			   //alert("Please Select Row to delete!1")
          			   var gr = $("#jqGrid1").jqGrid('getGridParam', 'selarrrow');
          			   
          			    if ((gr != null)&&(gr !="")){
          			    	
          			   // alert("Please Select Row to delete!2"+gr)
          			  
          			    //自定义ajax访问实现批量操作
          	            $.ajax({  
  	                             data:{"produce_plan_num":""+gr,"column_value":"已完成","oper":"batch_edit","column_name":"plan_status"},  
  	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
  	                             type:"POST",  
  	                             dataType:'json',  
  	                             url:"editproduce_plan_tab",  
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
          			      $("#jqGrid1").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
          			 
          			    	            }
          			    else {alert("请选择要编辑的行")}
          			   
          			    
          			   
          			    
          			  });
          		       		          		 
          			    	
          		}		
            	        		 
          		function pageInit2(){
            		  var lastsel;
            		  jQuery("#jqGrid2").jqGrid(
            		      {
            		        url : "showwork_plan_tab?plan_status_type=unpub",
            		        datatype : "json",
            		        colNames : [  '作业计划编号','日生产计划编号','产品编号','产品名称','设备编号','设备名称','计划数量', '计划状态 ','计划日期','计划班次', '制定日期','制定人','操作'],
            		        colModel : [ 
            		                     {name : 'work_plan_num',index :'work_plan_num',width : 150,align : "center",sortable :true,editable : true,key:true},
            		                     {name : 'day_plan_num',index :'day_plan_num',width : 150,align : "center",sortable :true,editable : true},   
            		                     {name : 'product_num',index :'product_num',width : 150,align : "center",sortable :true,editable : true}, 
            		                     {name : 'product_name',index :'product_name',width : 150,align : "center",sortable :true,editable : true}, 
            		                     {name : 'equip_num',index :'equip_num',width : 150,align : "center",sortable :true,editable : true}, 
            		                     {name : 'equip_name',index :'equip_name',width : 150,align : "center",sortable :true,editable : true}, 
            		                     
            		                     
            		                     {name : 'plan_quan',index : 'plan_quan',width : 70,align : "center",sortable : true,editable : true},  
            		                     {name : 'plan_status',index : 'plan_status',width : 150,align : "center",sortable : true,editable : false,formatter:'select', editoptions:{value:'0:未发布;1:已发布;2:已分解;3:执行中;4:执行中断;5:已完成'}},   
            		                     {name : 'plan_date',index : 'plan_date',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
            		                     {name : 'plan_shift',index : 'plan_shift',width : 150,align : "center",sortable : true,editable : false},   
            		                     {name : 'edit_time',index : 'edit_time',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
            		                     {name : 'work_plan_recorder_num',index : 'work_plan_recorder_num',width : 150,align : "center",sortable : true,editable : false},
            		                     {name : 'operate',index : 'operate',width : 300,align : "center",sortable : false,editable : false, formatter: function (value, grid, rows, state) { return "<button onclick='workPlanPublish("+rows.work_plan_num+","+rows.plan_status+")'>发布</button>" },}
            		                  
            		                     
            		                     
            		                   ],
            		                   
            		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
            	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
            	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
            	        
            		        loadonce:true,
            		        //当加载出错时提供错误信息
            		        loadError: function(xhr,status,error){  
            		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


            		        caption:"", height : 80,align : "center",

            		       

            		        prmNames: { id: "work_plan_num" },
            		        rowNum : 20,
            		        height:300,
            		        rowList : [ 20, 40, 60 ],
            		        pager : '#jqGridPager2',
            		       // multiselect:true,
            		        sortname :'work_plan_num',
            		        viewrecords : true,
            		        sortorder : "desc",
            		        autowidth:true,
            		        onSelectRow : function(id) {
            		          if (id && id !== lastsel) {
            		            jQuery('#jqGrid2').jqGrid('restoreRow', lastsel);
            		            jQuery('#jqGrid2').jqGrid('editRow', id, true);
            		            lastsel = id;
            		          }
            		        },
            		        editurl : "editwork_plan_tab",
            		       
            		      });
            		  
            		   $('#jqGrid2').navGrid('#jqGridPager2',
            	                // the buttons to appear on the toolbar of the grid
            	                { edit: true, add: true, del: true, search: true, refresh: true, view: false, position: "left", cloneToTop: false },
            	                // options for the Edit Dialog
            	                {
            	                    editCaption: "编辑记录",
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
            	                             $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
            	                             $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
            	                             $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
            			   var gr = $("#jqGrid2").jqGrid('getGridParam', 'selarrrow');
            			   
            			    if ((gr != null)&&(gr !="")){
            			    
            			   // alert("Please Select Row to delete!2"+gr)
            			  
            			    //自定义ajax访问实现批量操作
            	            $.ajax({  
    	                             data:{"produce_plan_num":""+gr,"column_value":99,"oper":"batch_edit","column_name":"equip_product_relat_num"},  
    	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
    	                             type:"POST",  
    	                             dataType:'json',  
    	                             url:"editproduce_plan_tab",  
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
            			      $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
            			    	            }
            			
            			    	
            			    else {alert("请选择要删除的行")}
            			    
            			    
            			   
            			  });
            		 
            		   //批量修改
            		   $("#execute").click(function() {
            			   //alert("Please Select Row to delete!1")
            			   var gr = $("#jqGrid2").jqGrid('getGridParam', 'selarrrow');
            			   
            			    if ((gr != null)&&(gr !="")){
            			    	
            			   // alert("Please Select Row to delete!2"+gr)
            			  
            			    //自定义ajax访问实现批量操作
            	            $.ajax({  
    	                             data:{"produce_plan_num":""+gr,"column_value":"执行中","oper":"batch_edit","column_name":"plan_status"},  
    	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
    	                             type:"POST",  
    	                             dataType:'json',  
    	                             url:"editproduce_plan_tab",  
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
            			      $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
            			 
            			    	            }
            			    else {alert("请选择要编辑的行")}
            			   
            			    
            			   
            			    
            			  });
            		 
            		   //批量修改
            		   $("#finish").click(function() {
            			   //alert("Please Select Row to delete!1")
            			   var gr = $("#jqGrid2").jqGrid('getGridParam', 'selarrrow');
            			   
            			    if ((gr != null)&&(gr !="")){
            			    	
            			   // alert("Please Select Row to delete!2"+gr)
            			  
            			    //自定义ajax访问实现批量操作
            	            $.ajax({  
    	                             data:{"produce_plan_num":""+gr,"column_value":"已完成","oper":"batch_edit","column_name":"plan_status"},  
    	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
    	                             type:"POST",  
    	                             dataType:'json',  
    	                             url:"editproduce_plan_tab",  
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
            			      $("#jqGrid2").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');
            			 
            			    	            }
            			    else {alert("请选择要编辑的行")}
            			   
            			    
            			   
            			    
            			  });
            		       		          		 
            			    	
            		}		   	        		          		          		 
            	        			    	
            		function pageInit3(){
              		  var lastsel;
              		  jQuery("#jqGrid3").jqGrid(
              		      {
              		        url : "showwork_plan_tab?plan_status_type=pubed",
              		        datatype : "json",
              		        colNames : [  '作业计划编号','日生产计划编号','产品编号','产品名称','设备编号','设备名称','计划数量', '计划状态 ','计划日期','计划班次', '制定日期','制定人','操作'],
              		        colModel : [ 
              		                     {name : 'work_plan_num',index :'work_plan_num',width : 150,align : "center",sortable :true,editable : true,key:true},
              		                     {name : 'day_plan_num',index :'day_plan_num',width : 150,align : "center",sortable :true,editable : true},   
              		                     {name : 'product_num',index :'product_num',width : 150,align : "center",sortable :true,editable : true}, 
              		                     {name : 'product_name',index :'product_name',width : 150,align : "center",sortable :true,editable : true}, 
              		                     {name : 'equip_num',index :'equip_num',width : 150,align : "center",sortable :true,editable : true}, 
              		                     {name : 'equip_name',index :'equip_name',width : 150,align : "center",sortable :true,editable : true}, 
              		                     
              		                     
              		                     {name : 'plan_quan',index : 'plan_quan',width : 70,align : "center",sortable : true,editable : true},  
              		                     {name : 'plan_status',index : 'plan_status',width : 150,align : "center",sortable : true,editable : false,formatter:'select', editoptions:{value:'0:未发布;1:已发布;2:已分解;3:执行中;4:执行中断;5:已完成'}},   
              		                     {name : 'plan_date',index : 'plan_date',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
              		                     {name : 'plan_shift',index : 'plan_shift',width : 150,align : "center",sortable : true,editable : false},   
              		                     {name : 'edit_time',index : 'edit_time',width : 130,align : "center",sortable : true,editable : true,searchoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},addoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}},editoptions:{readonly: 'readonly', dataInit:function(el) { $(el).datepicker()}}} ,
              		                     {name : 'work_plan_recorder_num',index : 'work_plan_recorder_num',width : 150,align : "center",sortable : true,editable : false},
              		                     {name : 'operate',index : 'operate',width : 300,align : "center",sortable : false,editable : false, formatter: function (value, grid, rows, state) { return "<button onclick='workPlanFinish("+rows.work_plan_num+","+rows.plan_status+")'>确认完成</button>" },}
              		                  
              		                     
              		                     
              		                   ],
              		                   
              		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
              	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
              	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
              	        
              		        loadonce:true,
              		        //当加载出错时提供错误信息
              		        loadError: function(xhr,status,error){  
              		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


              		        caption:"", height : 80,align : "center",

              		       

              		        prmNames: { id: "work_plan_num" },
              		        rowNum : 20,
              		        height:300,
              		        rowList : [ 20, 40, 60 ],
              		        pager : '#jqGridPager3',
              		       // multiselect:true,
              		        sortname :'work_plan_num',
              		        viewrecords : true,
              		        sortorder : "desc",
              		        autowidth:true,
              		        onSelectRow : function(id) {
              		          if (id && id !== lastsel) {
              		            jQuery('#jqGrid3').jqGrid('restoreRow', lastsel);
              		            jQuery('#jqGrid3').jqGrid('editRow', id, true);
              		            lastsel = id;
              		          }
              		        },
              		        editurl : "editday_plan_tab",
              		       
              		      });
              		  
              		   $('#jqGrid3').navGrid('#jqGridPager3',
              	                // the buttons to appear on the toolbar of the grid
              	                { edit: true, add: true, del: true, search: true, refresh: true, view: false, position: "left", cloneToTop: false },
              	                // options for the Edit Dialog
              	                {
              	                    editCaption: "编辑记录",
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
              	                             $("#jqGrid3").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
              	                             $("#jqGrid3").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
              	                             $("#jqGrid3").setGridParam({datatype:'json', page:1}).trigger('reloadGrid');

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
              		 
              		  
      	              
              		 
              		  
              			    
              			   
              			    
              			 
              		       		          		 
              			    	
              		}		   	        		          		          		 
              	        			    	   		
            				
        		
   </script>
    
    
    
  <!-- 插入底部 -->     
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
  
</body>
</html>




