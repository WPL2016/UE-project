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
<title>产品信息</title>  

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
           <div class="table_head">产品信息表</div>  
                  <table id="customers">
        
          
       </table>
             
             <div>
                  <table id="jqGrid1"></table>
                  <div id="jqGridPager1"></div>
                    
            </div>
       </div>
   
      
      
  
  
  <script type="text/javascript"> 
        $(document).ready(function () {
        		  //pageInit();
        		  pageInit1();
        		 // pageInit2();
        		});
        		/*function pageInit(){
        		  var lastsel;
        		  jQuery("#jqGrid").jqGrid(
        		      {
        		        url : "showmater_tab",
        		        datatype : "json",
        		        colNames : [  '原材料编号', '原材料名称 ','原材料规格', '原材料供应商',  '原材料记录人编号' ],
        		        colModel : [ 

        		                     {name : 'mater_num',index :'mater_num',width : 90,align : "center",sortable :true,editable : true,key:true},
        		                     {name : 'mater_name',index : 'mater_name',width : 150,align : "center",sortable : true,editable : true}, 
        		                     {name : 'mater_stan',index : 'mater_stan',width : 90,align : "center",sortable : false,editable : true},        		                 
        		                     {name : 'mater_sup',index : 'mater_sup',width : 80,align : "center",sortable : true,editable : true},        		  
        		            		 {name : 'mater_recorder_num',index : 'mater_recorder_num',width : 80,align : "center",sortable : true,editable : false},       
        		                            		                     
        		                   ],
        		                   
        		        //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
        	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
        	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
        	        
        		        loadonce:true,
        		        //当加载出错时提供错误信息
        		        loadError: function(xhr,status,error){  
        		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


        		        caption:"", height : 80,align : "center",

        		       

        		        prmNames: { id: "mater_num" },
        		        rowNum : 20,
        		        height:200,
        		        rowList : [ 20, 40, 60 ],
        		        pager : '#jqGridPager',
        		        multiselect:true,
        		        sortname :'mater_name',
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
        		        editurl : "editmater_tab",
        		       
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
	                             data:{"mater_num":""+gr,"column_value":99,"oper":"batch_edit","column_name":"mater_num"},  
	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	                             type:"POST",  
	                             dataType:'json',  
	                             url:"editmater_tab",  
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
	                             data:{"mater_num":""+gr,"column_value":1,"oper":"batch_edit","column_name":"mater_num"},  
	                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
	                             type:"POST",  
	                             dataType:'json',  
	                             url:"editmater_tab",  
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
        		          		          		 
        			    	
        		}*/
        		
        		function pageInit1(){
            		  var lastsel;
            		  jQuery("#jqGrid1").jqGrid(
            		      {
            		        url : "showproduct_tab",
            		        datatype : "json",
            		        colNames : [  '产品编号','产品名称', '原材料编号','产品记录人姓名'],
            		        colModel : [ 
            		                    {name : 'product_num',index : 'product_num',width : 90,align : "center",sortable :true,editable : true,key:true},
            		                    {name : 'product_name',index : 'product_name',width : 100,align : "center",sortable : true,editable : true},        		                          		                    
            		                    {name : 'mater_num',index : 'mater_num',width : 80,align : "right",align : "center",sortable : false,editable : true}, 
            		                    {name : 'product_recorder_num',index : 'product_recorder_num',width : 80,align : "center",sortable : false,editable :false}, 
            		                    
            		                   ],
            		                   //下载数据到本地，可以实现在前端排序、搜索，这种方式好处是这里的排序和搜索都无需后台处理，无需额外代码，而且支持多条件复杂搜索
            	        	        	//缺点是一次导入所有数据，数据量大时会存在一些问题，此时需要在后台实现搜索，只载入符合条件的数据,此外表格不自动刷新，需要reload
            	        	        	//请根据需要选择养已经完成好的前台查询和排序还是自行实现后台排序和搜索  
            	        	        
            	        		        loadonce:true,
            	        		        //当加载出错时提供错误信息
            	        		        loadError: function(xhr,status,error){  
            	        		        	 alert(status + " loading data of " + $(this).attr("id") + " : " + error );    },  


            	        		        caption:"", height : 80,align : "center",

            	        		       

            	        		        prmNames: { id: 'product_num' },
            	        		        rowNum : 20,
            	        		        height:200,
            	        		        rowList : [ 20, 40, 60 ],
            	        		        pager : '#jqGridPager1',
            	        		        multiselect:true,
            	        		        sortname :'product_name',
            	        		        viewrecords : true,
            	        		        sortorder : "desc",
            	        		        autowidth:true,
            	        		        onSelectRow : function(id) {
            	        		          if (id && id !== lastsel) {
            	        		            jQuery('#jqGrid1').jqGrid('restoreRow', lastsel);
            	        		            jQuery('#jqGrid1').jqGrid('editRow', id, true);
            	        		            lastsel = id;
            	        		          }
            	        		        },
            	        		        editurl : "editproduct_tab",
            	        		       
            	        		      });
            	        		  
            	        		   $('#jqGrid1').navGrid('#jqGridPager1',
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
            		                             data:{"product_num":""+gr,"column_value":99,"oper":"batch_edit","column_name":"product_num"},  
            		                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
            		                             type:"POST",  
            		                             dataType:'json',  
            		                             url:"editproduct_tab",  
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
            	        		 
            	        		   /* 批量修改
            	        		   $("#deldata1").click(function() {
            	        			   //alert("Please Select Row to delete!1")
            	        			   var gr = $("#jqGrid1").jqGrid('getGridParam', 'selarrrow');
            	        			   
            	        			    if ((gr != null)&&(gr !="")){
            	        			    	
            	        			   // alert("Please Select Row to delete!2"+gr)
            	        			  
            	        			    //自定义ajax访问实现批量操作
            	        	            $.ajax({  
            		                             data:{"product_num":""+gr,"column_value":1,"oper":"batch_edit","column_name":"product_num"},  
            		                             //用GET方法当请求参数不变时会因部分浏览器缓存而无法更新
            		                             type:"POST",  
            		                             dataType:'json',  
            		                             url:"editproduct_tab",  
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
            	        			   
            	        			    
            	        			   
            	        			    
            	        			  });*/
            	        		 
            	        		  
            	        		 
            	        		          		          		 
            	        			    	
            	        		} 
            				
        		
   </script>
    
    
    
  <!-- 插入底部 -->     
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
  
</body>
</html>




 