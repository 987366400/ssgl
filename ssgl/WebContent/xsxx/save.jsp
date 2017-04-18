<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var xm=$("#xm").val();
		var xh=$("#xh").val();
		var sjh=$("#sjh").val();
		var xb=$("#xb").val();
		if(xm==null||xm==""){
			$("#error").html("姓名不能为空！");
			return false;
		}
		if(xh==null||xh==""){
			$("#error").html("学号不能为空！");
			return false;
		}
		if(sjh==null||sjh==""){
			$("#error").html("手机号不能为空！");
			return false;
		}
		if(xb==null||xb==""){
			$("#error").html("性别不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		$("#xm").val("");
		$("#xh").val("");
		$("#xb").val("");
		$("#mz").val("");
		$("#cs").val("");
		$("#zy").val("");
		$("#jtdz").val("");
		$("#yzbm").val("");
		$("#jzxm").val("");
		$("#ssh").val("");
		$("#sjh").val("");
		$("#bz").val("");
		$("#sfzhm").val("");
		
	}
</script>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    	<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/xsxx?action=save" onsubmit="return checkForm()" >
		  <div class="form-group">
		    <label  class="col-md-2 control-label">姓名：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="xm"  name="xm" style="width: 300px;"  value="${xsxx.xm }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">学号：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="xh"  name="xh" style="width: 300px;"  value="${xsxx.xh }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">性别：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="xb"  name="xb" style="width: 300px;"  value="${xsxx.xb }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">民族：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="mz"  name="mz" style="width: 300px;"  value="${xsxx.mz }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">专业：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="zy"  name="zy" style="width: 300px;"  value="${xsxx.zy}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">城市：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="cs"  name="cs" style="width: 300px;"  value="${xsxx.cs }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">家庭地址：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="jtdz"  name="jtdz" style="width: 300px;"  value="${xsxx.jtdz}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">邮政编码：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="yzbm"  name="yzbm" style="width: 300px;"  value="${xsxx.yzbm}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">家长姓名：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="jzxm"  name="jzxm" style="width: 300px;"  value="${xsxx.jzxm}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">宿舍号：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="ssh"  name="ssh" style="width: 300px;"  value="${xsxx.ssh}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">身份证号码：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="sfzhm"  name="sfzhm" style="width: 300px;"  value="${xsxx.sfzhm}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">手机号：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="sjh"  name="sjh" style="width: 300px;"  value="${xsxx.sjh}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">备注：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="bz"  name="bz" style="width: 300px;"  value="${xsxx.bz}">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" id="id" name="id" value="${student.id }"/>
		      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
		      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
		      <font color="red" id="error"></font>
		    </div>
		  </div>
		</form>
  </div>
</div>

