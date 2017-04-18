<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function logout(){
	if(confirm('您确定要退出系统吗？')){
		window.location.href="${pageContext.request.contextPath}/yhb?action=logout";
	}
}
</script>
<div class="list-group">
  <a href="#" class="list-group-item active">
    系统菜单
  </a>
  <c:if test="${ currentYhb.yhsf=='管理员'}">
	  <a href="${pageContext.request.contextPath}/xsxx?action=list" class="list-group-item">学生信息管理</a>
	  <a href="${pageContext.request.contextPath}/ssxx?action=list" class="list-group-item">宿舍信息管理</a>
	  <a href="${pageContext.request.contextPath}/fkxx?action=list" class="list-group-item">访客信息管理</a>
	  <a href="${pageContext.request.contextPath}/bxxx?action=list" class="list-group-item">报修信息管理</a>
	  <a href="javascript:logout()" class="list-group-item">安全退出</a>
  </c:if>
  <c:if test="${ currentYhb.yhsf=='学生'}">
	  <a href="${pageContext.request.contextPath}/xsxx?action=showInfo" class="list-group-item">个人信息查看</a>
	  <a href="${pageContext.request.contextPath}/bxxx?action=preSave" class="list-group-item">报修申请</a>
	  <a href="${pageContext.request.contextPath}/bxxx?action=ybxlb" class="list-group-item">已报修列表</a>
	  <a href="javascript:logout()" class="list-group-item">安全退出</a>
  </c:if>
</div>