<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var bxss=$("#bxss").val();
		var bxnr=$("#bxnr").val();
		var lxfs=$("#lxfs").val();
		var bxdd=$("#bxdd").val();
		var bxr=$("#bxr").val();
		var bxsj=$("#bxsj").val();
		if(bxss==null||bxss==""){
			$("#error").html("报修宿舍不能为空！");
			return false;
		}
		if(bxnr==null||bxnr==""){
			$("#error").html("报修内容不能为空！");
			return false;
		}
		if(lxfs==null||lxfs==""){
			$("#error").html("联系方式不能为空！");
			return false;
		}
		if(bxsj==null||bxsj==""){
			$("#error").html("报修时间不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		$("#id").val("");
		$("#bxss").val("");
		$("#bxnr").val("");
		$("#lxfs").val("");
		$("#bxdd").val("");
		$("#bxr").val("");
		$("#bxzt").val("");
		$("#bxsj").val("");
		
	}
</script>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    	<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/bxxx?action=save" onsubmit="return checkForm()" >
		  <div class="form-group">
		    <label  class="col-md-2 control-label">报修宿舍：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="bxss"  name="bxss" style="width: 300px;"  value="${bxxx.bxss }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">报修内容：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="bxnr"  name="bxnr" style="width: 300px;"  value="${bxxx.bxnr }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">报修人：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="bxr"  name="bxr" style="width: 300px;"  value="${bxxx.bxr }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">报修地点：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="bxdd"  name="bxdd" style="width: 300px;"  value="${bxxx.bxdd }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">联系方式：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="lxfs"  name="lxfs" style="width: 300px;"  value="${bxxx.lxfs }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">报修时间：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="bxsj"  name="bxsj" style="width: 300px;"  value="${bxxx.bxsj}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">状态：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="bxzt"  name="bxzt" style="width: 300px;"  value="${bxxx.bxzt }">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" id="id" name="id" value="${bxxx.id }"/>
		      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
		      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
		      <font color="red" id="error"></font>
		    </div>
		  </div>
		</form>
  </div>
</div>

