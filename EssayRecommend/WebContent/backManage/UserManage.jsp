<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0" />
<title>用户管理</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/UserManage.css" rel="stylesheet" />
<script src="../bootstrap/js/jquery-1.11.2.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/backManage.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="container">
   <article class="content">
    <article class="panel panel-default">
    	<section class="panel-heading clearfix">
        	<section class="pull-left">
            	<button class="btn btn-success" data-toggle="modal" data-target="#newPopUp" data-backdrop="static">新建用户</button>
            </section>
        </section>
        <section>
        	<table class="table table-bordered table-hover cc">
            <thead>
            	<tr>
            		<th>ID</th>
                	<th>用户名</th>
 	                <th>邮箱</th>
                	<th>创建日期</th>
                	<th>操作</th>
             	</tr>
            </thead>
            <tbody>
            	<c:forEach items="${requestScope.uList }" var="userlist">
            	<tr>
            		<td>${userlist.user_Id}</td>
            		<td>${userlist.username}</td>
            		<td>${userlist.email}</td>
            		<td>${userlist.createDate}</td>
            		<td>
            		<button class="btn  btn-xs btn-primary"><span class="glyphicon glyphicon-edit"></span>修改</button>
                    <a href="UserDelete?userId=${userlist.user_Id}"><button class="btn  btn-xs btn-warning"><span class="glyphicon glyphicon-remove"></span>
                   	 删除</button></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            </table>
        </section>
        <ul class="list-group">
        	<li class="list-group-item">
             	<ul class="pagination square">
             		<c:choose>
              			<c:when test="${param.pageNo!=1 }">            	
              			<li><a href="${url }?pageNo=${param.pageNo-1 }">Prev</a></li>
              			</c:when>
              			<c:otherwise>
              			<li class="disabled"><a href="#">Prev</a></li>
              			</c:otherwise>
              		</c:choose>
              		<c:forEach var="x" begin="${pageNo<3?1:pageNo-2 }" end="${requestScope.pageCount>pageNo+3?pageNo+3:requestScope.pageCount }">
              		<c:choose>
              			<c:when test="${x!=param.pageNo }">
              			<li><a href="${url }?pageNo=${x }"><c:out value="${x }" /></a></li>
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
            </li>
        </ul>
    </article>
  	</article>
</div>
<div class="modal fade" id="newPopUp">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title" id="H1">创建一个新用户</h4>
            </div>
            <div class="modal-body">
				<form class="form-horizontal" role="form" id="myform" method="post" action="UserAdd">
                     <div class="form-group">
                         <label for="username" class="col-sm-3 control-label">用户名</label>
                         <div class="col-sm-9">
                             <input type="text" class="form-control" name="username" id="username" placeholder="username">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="password" class="col-sm-3 control-label">密码</label>
                         <div class="col-sm-9">
                             <input type="password" class="form-control" name="password" id="password" placeholder="password">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="repassword" class="col-sm-3 control-label">确认密码</label>
                         <div class="col-sm-9">
                             <input type="password" class="form-control" id="repassword" placeholder="repassword">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="email" class="col-sm-3 control-label">邮箱</label>
                         <div class="col-sm-9">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                        </div>
                     </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="btnCreate">创建</button>
                    <button type="button" class="btn btn-warning" id="btnReset">重置</button>
                    <button type="button" class="btn btn-danger" id="btnCancel" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
