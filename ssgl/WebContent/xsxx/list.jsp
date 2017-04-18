<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function xsxxDelete(xh){
		if(confirm("确认要删除这条记录吗？")){
			$.post("${pageContext.request.contextPath}/xsxx?action=delete",{xh:xh},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/xsxx?action=list";
					}else{
						alert("该学生有选课记录，不能删除！");
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/xsxx?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_xm"  value="${s_xsxx.xm }" placeholder="请输入要查询的学生名...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/xsxx?action=preSave'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>序号</th>
		  	<th>姓名</th>
		  	<th>学号</th>
		  	<th>民族</th>
		  	<th>城市</th>
		  	<th>家庭地址</th>
		  	<th>宿舍号</th>
		  	<th>手机号</th>
		  	<th>操作</th>
		  </tr>
		  <c:forEach var="xsxx" items="${xsxxList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${xsxx.xm }</td>
		  		<td>${xsxx.xh }</td>
		  		<td>${xsxx.mz }</td>
		  		<td>${xsxx.cs }</td>
		  		<td>${xsxx.jtdz }</td>
		  		<td>${xsxx.ssh }</td>
		  		<td>${xsxx.sjh }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/xsxx?action=preSave&xh=${xsxx.xh }'">修改</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="xsxxDelete(${xsxx.xh })">删除</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



