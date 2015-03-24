<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>下载历史</title>

	
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="css/bootstrap-main.css" media="screen" >
	<link rel="stylesheet" href="css/main.css">


	<!-- JavaScript -->
	<script src="bootstrap/js/jquery-1.11.2.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</head>

<body class="home">
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="index.html"><img src="images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a href="home.jsp">首页</a></li>
					<li><a href="about.html">发现论文</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="sidebar-left.html">下载历史</a></li>
							<li class="active"><a href="sidebar-right.html">信息管理</a></li>
						</ul>
					</li>
					<li><a href="contact.html">联系我们</a></li>
					<c:choose>
              			<c:when test="${empty sessionScope.user }">            	
              			<li><a class="btn" href="signin.jsp">登录 / 注册</a></li>
              			</c:when>
              			<c:otherwise>
              			<li><span class="showuser"><a class="btn" href="" >${sessionScope.user.username }</a></span></li>
              			</c:otherwise>
              		</c:choose>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	
	<header id="head" class="secondary"></header>
	
	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="home.jsp">首页</a></li>
			<li class="active">下载历史</li>
		</ol>

		<div class="showResult">
			<div class="col-md-3 show">
				<h3>关键词</h3>
			</div>
			<div class="col-md-9">
				<ul>
					<c:forEach items="${requestScope.pubList }" var="publication">
						<li>
						<table class="table table-hover cc">
							<tr><td><a href="ShowAction?p_id=${publication._id }">${publication.title}</a></td></tr>
							<tr><td>${publication.doi}</td></tr>
							<tr><td>${publication.authors}</td></tr>
							<tr><td>${publication.keywords}</td></tr>		
						</table>
						</li>
					</c:forEach>
				</ul>
			</div>
			<nav class="col-md-offset-5">
					<ul class="pagination">
						<c:choose>
							<c:when test="${param.pageNo!=1 }">
								<li><a href="${url }?pageNo=${param.pageNo-1 }">Prev</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">Prev</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="x" begin="${pageNo<3?1:pageNo-2 }"
							end="${requestScope.pageCount>pageNo+3?pageNo+3:requestScope.pageCount }">
							<c:choose>
								<c:when test="${x!=param.pageNo }">
									<li><a href="${url }?pageNo=${x }"><c:out
												value="${x }" /></a></li>
								</c:when>
								<c:otherwise>
									<li class="active"><a href="#"><c:out value="${x }" />
											<span class="sr-only">(current)</span></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${param.pageNo!=requestScope.pageCount }">
								<li><a href="${url }?pageNo=${param.pageNo+1 }">Next</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled"><a href="#">Next</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
					<span>共${requestScope.total }篇文献</span>
				</nav>
		</div>
		</div>
	<!-- /container -->
	<div class="footer">
			<div class="container">
				<div class="row">
					
					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="simplenav">
								<a href="#">首页</a> | 
								<a href="about.html">发现</a> |
								<a href="sidebar-right.html">下载历史</a> |
								<a href="contact.html">联系我们</a> |
								<b><a href="signup.html">注册</a></b>
							</p>
						</div>
					</div>

					<div class="col-md-6 widget">
						<div class="widget-body">
							<p class="text-right">
								Copyright &copy; 2014, 欧阳志凡.兰州交通大学
							</p>
						</div>
					</div>

				</div> <!-- /row of widgets -->
			</div>
		</div>

</body>
</html>