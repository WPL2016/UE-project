<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>权限管理测试</title>  


</head>
<body>
<a href="logout">注销</a><br/>
<a href="admin/admintest">admin可以访问</a><br/>
<a href="user/usertest">user可以访问</a><br/>
<a href="engineer/engineertest">egineer可以访问</a><br/>
<a href="useroradmin/firsttest">必须同时是user和admin才可以访问</a><br/>
<a href="userandadmin/firsttest">user或者admin都可以访问</a><br/>
<a href="tomanagerole">角色维护</a><br/>
<a href="toasignrole">角色授予</a><br/>
<a href="toassignauthors">角色授权</a><br/>
</body>
</html>




