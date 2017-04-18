<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function fkxxDelete(id){
		if(confirm("确认要删除这条记录吗？")){
			$.post("${pageContext.request.contextPath}/fkxx?action=delete",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/fkxx?action=list";
					}else{
						alert("不能删除！");
					}
				}
			);
		}
	}
</script>
<div class="row search" >
  <div class="col-md-6">
	<form action="${pageContext.request.contextPath}/fkxx?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_fkxm"  value="${s_fkxx.fkxm }" placeholder="请输入要查询的访客...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/fkxx?action=preSave'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>序号</th>
		  	<th>访客姓名</th>
		  	<th>身份证号</th>
		  	<th>受访人</th>
		  	<th>访问宿舍</th>
		  	<th>开始时间</th>
		  	<th>结束时间</th>
		  	<th>原因</th>
		  	<th>操作</th>
		  </tr>
		  <c:forEach var="fkxx" items="${fkxxList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${fkxx.fkxm }</td>
		  		<td>${fkxx.sfzh}</td>
		  		<td>${fkxx.sfr }</td>
		  		<td>${fkxx.sfss }</td>
		  		<td>${fkxx.kssj }</td>
		  		<td>${fkxx.jssj }</td>
		  		<td>${fkxx.fwyy }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/fkxx?action=preSave&id=${fkxx.id }'">修改</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="fkxxDelete(${fkxx.id })">删除</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



