<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

<title>EssarRecomend</title>


<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Custom styles for our template -->
<link rel="stylesheet" href="css/bootstrap-main.css" media="screen">
<link rel="stylesheet" href="css/main.css">


<!-- JavaScript -->
<script src="bootstrap/js/jquery-1.11.2.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</head>

<body class="home">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="home.jsp"><img
					src="images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li class="active"><a href="home.jsp">首页</a></li>
					<li><a href="discover.jsp">发现论文</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">个人中心<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="HistoryAction?pageNo=1">下载历史</a></li>
							<li class="active"><a href="viewinformatin.jsp">信息管理</a></li>
						</ul></li>
					<li><a href="contact.jsp">联系我们</a></li>
					<c:choose>
						<c:when test="${empty sessionScope.user }">
							<li><a class="btn" href="signin.jsp">登录 / 注册</a></li>
						</c:when>
						<c:otherwise>
							<li><span class="showuser"><a class="btn" href="">${sessionScope.user.username }</a></span></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>


	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="home.jsp">首页</a></li>
			<li class="active">搜索结果</li>
		</ol>



		<div class="col-md-3 show">
			<h2>相关文章：</h2>
			<ul class="recommendList">
				<c:forEach items="${requestScope.recommendItems }" var="rcommendItem">
					<li><a href="ShowAction?p_id=${rcommendItem.key}">${rcommendItem.value }</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-9">
			<table class="table">
				<tr>
					<td>标题：</td>
					<td>${publication.title }</td>
				</tr>
				<tr>
					<td>作者：</td>
					<td>${publication.authors }</td>
				</tr>
				<tr>
					<td>关键词：</td>
					<td>${publication.keywords }</td>
				</tr>
				<tr>
					<td>DOI：</td>
					<td>${publication.doi }</td>
				</tr>
				<tr>
					<td>摘要：</td>
					<td>${publication.abstracts }</td>
				</tr>
				<tr>
					<td>PDF：</td>
					<td><a href="DownloadFile?filename=${publication._id }.PDF">下载</a></td>
				</tr>
				<tr>
					<td>title：</td>
					<td>${publication.title_English }</td>
				</tr>
				<tr>
					<td>keywords：</td>
					<td>${publication.keywords_English }</td>
				</tr>
				<tr>
					<td>abstracts：</td>
					<td>${publication.abstract_English }</td>
				</tr>
				<tr>
					<td>引用本文：</td>
					<td>${publication.citaarticles }</td>
				</tr>
			</table>
		</div>

	</div>




	<div class="footer">
		<div class="container">
			<div class="row">

				<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="simplenav">
								<a href="home.jsp">首页</a> | 
								<a href="discover.jsp">发现</a> |
								<a href="statement.html">版权声明</a> |
								<a href="contact.jsp">联系我们</a> |
								<b><a href="signup.jsp">注册</a></b>
							</p>
						</div>
				</div>

				<div class="col-md-6 widget">
					<div class="widget-body">
						<p class="text-right">Copyright &copy; 2014, 欧阳志凡.兰州交通大学</p>
					</div>
				</div>

			</div>
			<!-- /row of widgets -->
		</div>
	</div>

</body>
</html>