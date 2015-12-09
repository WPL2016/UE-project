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
             <div class="table_head">材料使用情况</div>
             <div>
                  <table id="jqGrid"></table>
                  <div id="jqGridPager"></div>
                                  
                  <table id="jqGrid1"></table>
                  <div id="jqGridPager1"></div>
                  
                  <table id="jqGrid2"></table>
                  <div id="jqGridPager2"></div>
            </div>
       </div>
    
  <script type="text/javascript"> 
        $(document).ready(function () {
        		  pageInit();
        		  pageInit1();
        		  pageInit2();
        		});
        		function pageInit(){
        		  var lastsel;
        		  jQuery("#jqGrid").jqGrid(
        		      {
        		        url : "showjqgrid",
        		        datatype : "json",
        		        colNames : [  'rowid','Date', 'Client', 'Amount', 'Tax', 'Notes' ],
        		        colModel : [ 
        		                    {name : 'id',index : 'id',width : 90,sortable : false,editable : false},
        		                    {name : 'name',index : 'name',width : 100,sortable : false,editable : true},        		                          		                    
        		                     {name : 'email',index : 'email',width : 80,align : "right",sortable : false,editable : true}, 
        		                     {name : 'address',index : 'address',width : 80,align : "right",sortable : false,editable : true},        		  
        		                     {name : 'reason',index : 'reason',width : 150,sortable : false,editable : true}, 
        		                     {name : 'telephone',index : 'telephone',width : 90,sortable : false,editable : true}, 
        		                   ],
        		        caption:"原材料使用状况", height : 80,align : "center",
        		        rowNum : 20,
        		        height:300,
        		        rowList : [ 20, 40, 60 ],
        		        pager : '#jqGridPager',
        		        sortname : 'name',
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
        		        editurl : "editjqgrid",
        		       
        		      });
        		  
        		   $('#jqGrid').navGrid('#jqGridPager',
        	                // the buttons to appear on the toolbar of the grid
        	                { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
        	                // options for the Edit Dialog
        	                {
        	                    editCaption: "The Edit Dialog",
        	                    recreateForm: true,
        						checkOnUpdate : true,
        						checkOnSubmit : true,
        	                    closeAfterEdit: true,
        	                    errorTextFormat: function (data) {
        	                        return 'Error: ' + data.responseText
        	                    }
        	                },
        	                // options for the Add Dialog
        	                {
        	                    closeAfterAdd: true,
        	                    recreateForm: false,
        	                    errorTextFormat: function (data) {
        	                        return 'Error: ' + data.responseText
        	                    }
        	                },
        	                // options for the Delete Dailog
        	                {
        	                    errorTextFormat: function (data) {
        	                        return 'Error: ' + data.responseText
        	                    }
        	                });
        		          		          		 
        		}
        		
        		
        		function pageInit1(){
          		  var lastsel;
          		  jQuery("#jqGrid1").jqGrid(
          		      {
          		        url : "showjqgrid",
          		        datatype : "json",
          		        colNames : [  'rowid','Date', 'Client', 'Amount', 'Tax', 'Notes' ],
          		        colModel : [ 
          		                    {name : 'id',index : 'id',width : 90,sortable : false,editable : false},
          		                    {name : 'name',index : 'name',width : 100,sortable : false,editable : true},        		                          		                    
          		                     {name : 'email',index : 'email',width : 80,align : "right",sortable : false,editable : true}, 
          		                     {name : 'address',index : 'address',width : 80,align : "right",sortable : false,editable : true},        		  
          		                     {name : 'reason',index : 'reason',width : 150,sortable : false,editable : true}, 
          		                     {name : 'telephone',index : 'telephone',width : 90,sortable : false,editable : true}, 
          		                   ],
          		        caption:"新料使用状况",           
          		        rowNum : 20,
          		        height:300,
          		        rowList : [ 20, 40, 60 ],
          		        pager : '#jqGridPager1',
          		        sortname : 'name',
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
          		        editurl : "editjqgrid",
          		       
          		      });
          		  
          		   $('#jqGrid1').navGrid('#jqGridPager1',
          	                // the buttons to appear on the toolbar of the grid
          	                { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
          	                // options for the Edit Dialog
          	                {
          	                    editCaption: "The Edit Dialog",
          	                    recreateForm: true,
          						checkOnUpdate : true,
          						checkOnSubmit : true,
          	                    closeAfterEdit: true,
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                },
          	                // options for the Add Dialog
          	                {
          	                    closeAfterAdd: true,
          	                    recreateForm: false,
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                },
          	                // options for the Delete Dailog
          	                {
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                });
          		          		          		 
          		}  		
          		
          		
          		function pageInit2(){
          		  var lastsel;
          		  jQuery("#jqGrid2").jqGrid(
          		      {
          		        url : "showjqgrid",
          		        datatype : "json",
          		        colNames : [  'rowid','Date', 'Client', 'Amount', 'Tax', 'Notes' ],
          		        colModel : [ 
          		                    {name : 'id',index : 'id',width : 90,sortable : false,editable : false},
          		                    {name : 'name',index : 'name',width : 100,sortable : false,editable : true},        		                          		                    
          		                     {name : 'email',index : 'email',width : 80,align : "right",sortable : false,editable : true}, 
          		                     {name : 'address',index : 'address',width : 80,align : "right",sortable : false,editable : true},        		  
          		                     {name : 'reason',index : 'reason',width : 150,sortable : false,editable : true}, 
          		                     {name : 'telephone',index : 'telephone',width : 90,sortable : false,editable : true}, 
          		                   ],
          		        caption:"回炉料使用情况", 
          		        rowNum : 20,
          		        height:300,
          		        rowList : [ 20, 40, 60 ],
          		        pager : '#jqGridPager2',
          		        sortname : 'name',
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
          		        editurl : "editjqgrid",
          		       
          		      });
          		  
          		   $('#jqGrid2').navGrid('#jqGridPager2',
          	                // the buttons to appear on the toolbar of the grid
          	                { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
          	                // options for the Edit Dialog
          	                {
          	                    editCaption: "The Edit Dialog",
          	                    recreateForm: true,
          						checkOnUpdate : true,
          						checkOnSubmit : true,
          	                    closeAfterEdit: true,
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                },
          	                // options for the Add Dialog
          	                {
          	                    closeAfterAdd: true,
          	                    recreateForm: false,
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                },
          	                // options for the Delete Dailog
          	                {
          	                    errorTextFormat: function (data) {
          	                        return 'Error: ' + data.responseText
          	                    }
          	                });
          		          		          		 
          		}  		
   </script>
   

  
  
  <!-- 插入底部 -->     
  <div>
  <%@ include file="./component/2_foot.jsp"%>
  </div>  
  
</body>
</html>




