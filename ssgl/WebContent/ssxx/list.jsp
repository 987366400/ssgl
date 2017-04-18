<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function ssxxDelete(ssxh){
		if(confirm("确认要删除这条记录吗？")){
			$.post("${pageContext.request.contextPath}/ssxx?action=delete",{ssxh:ssxh},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/ssxx?action=list";
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
	<form action="${pageContext.request.contextPath}/ssxx?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_ssh"  value="${s_ssxx.ssh }" placeholder="请输入要查询的宿舍号...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/ssxx?action=preSave'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>序号</th>
		  	<th>宿舍号</th>
		  	<th>类型</th>
		  	<th>地点</th>
		  	<th>床位数</th>
		  	<th>宿舍长</th>
		  	<th>奖惩情况</th>
		  	<th>评分</th>
		  	<th>操作</th>
		  </tr>
		  <c:forEach var="ssxx" items="${ssxxList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${ssxx.ssh }</td>
		  		<td>${ssxx.sslx }</td>
		  		<td>${ssxx.ssdd }</td>
		  		<td>${ssxx.cws }</td>
		  		<td>${ssxx.ssz }</td>
		  		<td>${ssxx.jcqk }</td>
		  		<td>${ssxx.sspf }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/ssxx?action=preSave&ssxh=${ssxx.ssxh }'">修改</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="ssxxDelete(${ssxx.ssxh })">删除</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



