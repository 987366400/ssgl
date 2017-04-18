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
		  <c:forEach var="ybxlb" items="${ybxlbList }" varStatus="status">
		  	<tr>
		  	    <td>${status.index+1 }</td>
		  		<td>${ybxlb.bxss }</td>
		  		<td>${ybxlb.bxnr}</td>
		  		<td>${ybxlb.lxfs }</td>
		  		<td>${ybxlb.bxdd }</td>
		  		<td>${ybxlb.bxr }</td>
		  		<td>${ybxlb.bxzt }</td>
		  		<td>${ybxlb.bxsj }</td>
		  		<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/bxxx?action=preSave&id=${ybxlb.id }'">修改</button>&nbsp;
		  				<button type="button" class="btn btn-danger btn-xs" onclick="bxxxDelete(${ybxlb.id })">删除</button></td>
		  	</tr>
		  </c:forEach>
	</table>
	<nav >
		<ul class="pagination">
			${pageCode }
		</ul>
	</nav>
</div>



