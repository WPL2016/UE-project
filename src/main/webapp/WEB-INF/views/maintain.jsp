<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Insert title here</title>  



<link rel="stylesheet" type="text/css"  media="screen"  href="resources/jqGrid/css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen"   href="resources/jqGrid/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css" media="screen"  href="resources/jqGrid/css/ui.jqgrid-bootstrap-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"  href="resources/jqGrid/css/jquery-ui.css" />
<script type="text/ecmascript" src="resources/jquery-2.1.3.min.js"></script>

 <script src="resources/jqGrid/js/i18n/grid.locale-cn.js" type="text/ecmascript"></script>
  
 <script src="resources/jqGrid/js/jquery.jqGrid.min.js" type="text/ecmascript"></script>
 <script src="resources/jqGrid/plugins/grid.addons.js" type="text/ecmascript"></script>

 

</head>

<body>
 <%@ include file="./component/1_head.jsp"%> 
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript">
    var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});	
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
                url: 'autoajax',
				// we set the changes to be made at client side using predefined word clientArray
                editurl: 'contact/saveContact',
                datatype: "json",
                colModel: [
                    {
						label: 'Customer ID',
                        name: 'id',
                        width: 75,
						key: true,
						editable: false,
						editrules : { required: true}
                    },
                    {
						label: 'Company Name',
                        name: 'name',
                        width: 140,
                        editable: true // must set editable to true if you want to make the field editable
                    },
                    {
						label : 'Phone',
                        name: 'telephone',
                        width: 100,
                        editable: true
                    },
                    {
						label: 'Postal Code',
                        name: 'email',
                        width: 80,
                        editable: true
                    },
                    {
						label: 'City',
                        name: 'address',
                        width: 140,
                        editable: true
                    }
                ],
				sortname: 'id',
				sortorder : 'asc',
				loadonce: true,
				viewrecords: true,
                width: 780,
                height: 200,
                rowNum: 10,
                pager: "#jqGridPager"
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
                    recreateForm: true,
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
        });

    </script>


   </script>

</body>
</html>



