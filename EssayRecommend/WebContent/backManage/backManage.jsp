<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0" />
<title>论文推荐系统后台管理</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/backManage.css" rel="stylesheet" />
<script src="../bootstrap/js/jquery-1.11.2.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/backManage.js"></script>
</head>
<body>
<div class="container">
	<header>
   		<h1>论文推荐系统后台管理</h1>
  	</header>
     <!--class="navbar navbar-inverse class="navbar-inner"" -->
    <div class="navbar navbar-inverse">
    <div class="navbar-inner">
		<ul class="nav nav-pills" target="mainContent">
        	<li><a href="UserManage?pageNo=1" target="mainContent">用户管理</a></li>
        	<li><a href="PublicationManage?pageNo=1" target="mainContent">论文管理</a></li>
       		<li><a href="DownloadManage?pageNo=1" target="mainContent">下载管理</a></li>
            <span class="showuser">
        		欢迎您，管理员：${sessionScope.manager.username}&nbsp;<a href="backLogout.action">退出</a>
        	</span>
        </ul>    
    </div>   	
  	</div>
    
    <article class="content">
    	<iframe name="mainContent" frameborder="0" height="100%" width="100%"></iframe>
    </article>
    <footer>
  		<address>
  		Copyright@lzjtu 2014-2015<br>甘肃省兰州市安宁区安宁西路88号兰州交通大学
    </address>
  </footer>
</div>
</html>
