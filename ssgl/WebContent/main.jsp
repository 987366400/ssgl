<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生宿舍管理系统-主页</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/xsxk.css">
<style type="text/css">
	.navbar-inverse {
		background-color: #337ab7; 
		border-color: #337ab7; 
	}
</style>
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
<%
	if(session.getAttribute("currentYhb")==null){
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		return;
	}

	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="/common/default.jsp";
	}
%>
</head>
<body >
<div class="container">
<div class="row">
	<div class="col-md-12">
		<jsp:include page="/common/head.jsp"/>
	</div>
</div>

<div class="row" style="padding-top: 45px;">
	<div class="col-md-3">
		<jsp:include page="/common/menu.jsp"/>
	</div>
	<div class="col-md-9">
		<div>
			<ol class="breadcrumb">
			  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
			  <li class="active">${modeName }</li>
			</ol>
		</div>
		<jsp:include page="<%=mainPage %>"/>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<jsp:include page="/common/foot.jsp"/>
	</div>
</div>
</div>
</body>
</html>