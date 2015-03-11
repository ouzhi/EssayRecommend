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
</head>
<body>
<div class="container">
   <article class="content">
    <article class="panel panel-default">
    	<section class="panel-heading clearfix">
        	<section class="pull-left">
            	<button class="btn btn-success" disabled>下载记录</button>
            </section>
        </section>
        <section>
        	<table class="table table-bordered table-hover cc">
            <thead>
            	<tr>
            		<th>ID</th>
                	<th>下载时间</th>
                	<th>下载IP地址</th>
                	<th>下载论文</th>
                	<th>下载用户</th>
                	<th>操作</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${requestScope.downloadRecordList }" var="downloadRecord">
            	<tr>
            		<td>${downloadRecord.download_Id}</td>
            		<td>${downloadRecord.download_Date}</td>
            		<td>${downloadRecord.download_Ip}</td>
            		<td>${downloadRecord.download_Pub_Id}</td>
            		<td>${downloadRecord.download_User_Id}</td>
            		<td>
            		<button class="btn  btn-xs btn-primary"><span class="glyphicon glyphicon-edit"></span>修改</button>
                    <a href="DownloadRecordDelete?download_Id=${downloadRecord.download_Id}"><button class="btn  btn-xs btn-warning"><span class="glyphicon glyphicon-remove"></span>
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
</body>
</html>
