<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var ssh=$("#ssh").val();
		var sslx=$("#sslx").val();
		var ssdd=$("#ssdd").val();
		var cws=$("#cws").val();
		var xzrs=$("#xzrs").val();
		if(ssh==null||ssh==""){
			$("#error").html("宿舍号不能为空！");
			return false;
		}
		if(sslx==null||sslx==""){
			$("#error").html("宿舍类型不能为空！");
			return false;
		}
		if(ssdd==null||ssdd==""){
			$("#error").html("宿舍地点不能为空！");
			return false;
		}
		if(cws==null||cws==""){
			$("#error").html("床位数不能为空！");
			return false;
		}
		if(xzrs==null||xzrs==""){
			$("#error").html("现住人数不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		$("#ssxh").val("");
		$("#ssh").val("");
		$("#sslx").val("");
		$("#ssdd").val("");
		$("#cws").val("");
		$("#xzrs").val("");
		$("#ssz").val("");
		$("#jcqk").val("");
		$("#sspf").val("");
		
	}
</script>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    	<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/ssxx?action=save" onsubmit="return checkForm()" >
		  <div class="form-group">
		    <label  class="col-md-2 control-label">宿舍序号：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="ssxh"  name="ssxh" style="width: 300px;"  value="${ssxx.ssxh }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">宿舍号：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="ssh"  name="ssh" style="width: 300px;"  value="${ssxx.ssh }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">宿舍类型：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="sslx"  name="sslx" style="width: 300px;"  value="${ssxx.sslx }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">地点：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="ssdd"  name="ssdd" style="width: 300px;"  value="${ssxx.ssdd }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">床位数：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="cws"  name="cws" style="width: 300px;"  value="${ssxx.cws }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">现住人数：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="xzrs"  name="xzrs" style="width: 300px;"  value="${ssxx.xzrs}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">宿舍长：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="ssz"  name="ssz" style="width: 300px;"  value="${ssxx.ssz }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">奖惩情况：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="jcqk"  name="jcqk" style="width: 300px;"  value="${ssxx.jcqk}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">宿舍评分：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="sspf"  name="sspf" style="width: 300px;"  value="${ssxx.sspf}">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" id="id" name="id" value="${ssxx.ssxh }"/>
		      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
		      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
		      <font color="red" id="error"></font>
		    </div>
		  </div>
		</form>
  </div>
</div>

