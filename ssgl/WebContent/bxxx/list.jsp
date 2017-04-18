<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function bxxxDelete(id){
		if(confirm("确认要删除这条记录吗？")){
			$.post("${pageContext.request.contextPath}/bxxx?action=delete",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/bxxx?action=list";
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
	<form action="${pageContext.request.contextPath}/bxxx?action=list" method="post">
	    <div class="input-group" style="width: 300px">
		      <input type="text" class="form-control" name="s_bxr"  value="${s_bxxx.bxr }" placeholder="请输入要查询的报修人...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
	    </div>
    </form>
  </div>
  <div class="col-md-6" >
    <button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/bxxx?action=preSave'">添加</button>
  </div>
</div>
<div>
	<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
		<tr>
		  	<th>序号</th>
		  	<th>报修宿舍</th>
		  	<th>报修内容</th>
		  	<th>联系方式</th>
		  	<th>报修地点</th>
		  	<th>报修人</th>
		  	<th>状态</th>
		  	<th>报修时间</th>
		  	<th>操作</th>
		  </tr>
		  <c:forEach var="bxxx" items="${bxxxList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${bxxx.bxss }</td>
		  		<td>${bxxx.bxnr}</td>
		  		<td>${bxxx.lxfs }</td>
		  		<td>${bxxx.bxdd }</td>
		  		<td>${bxxx.bxr }</td>
		  		<td>${bxxx.bxzt }</td>
		  		<td>${bxxx.bxsj }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/bxxx?action=preSave&id=${bxxx.id }'">修改</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="bxxxDelete(${bxxx.id })">删除</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



