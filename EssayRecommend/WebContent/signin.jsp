<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>登录</title>

	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="css/bootstrap-main.css" media="screen" >
	<link rel="stylesheet" href="css/main.css">


	<!-- JavaScript -->
	<script src="bootstrap/js/jquery-1.11.2.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
	
	
</head>

<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="home.jsp"><img src="images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a href="home.jsp">首页</a></li>
					<li><a href="discover.jsp">发现论文</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="HistoryAction?pageNo=1">下载历史</a></li>
							<li><a href="viewinformation.jsp">信息管理</a></li>
						</ul>
					</li>
					<li><a href="contact.jsp">联系我们</a></li>
					<li><a class="btn active" href="register.jsp">登录 / 注册</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="home.jsp">首页</a></li>
			<li class="active">登录</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">登录你的账号</h3>
							<p class="text-center text-muted">没有账号，赶紧 <a href="register.jsp">注册</a>!</p>
							<hr>
							
							<form method="post" action="LoginAction">
								<div class="top-margin">
									<label>用户名  <span class="text-danger">*</span></label>
									<input type="text" name="username" class="form-control">
								</div>
								<div class="top-margin">
									<label>密码 <span class="text-danger">*</span></label>
									<input type="password" name="password" class="form-control">
								</div>

								<hr>

								<div class="row">
									<div class="col-lg-8">
										<b><a href="#">忘记密码?</a></b>
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<br>
					<br>
				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->
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
								<b><a href="register.jsp">注册</a></b>
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