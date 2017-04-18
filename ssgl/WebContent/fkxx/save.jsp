<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function checkForm(){
		var fkxm=$("#fkxm").val();
		var sfzh=$("#sfzh").val();
		var sfr=$("#sfr").val();
		var sfss=$("#sfss").val();
		var kssj=$("#kssj").val();
		var jssj=$("#jssj").val();
		if(fkxm==null||fkxm==""){
			$("#error").html("访客不能为空！");
			return false;
		}
		if(sfr==null||sfr==""){
			$("#error").html("受访人不能为空！");
			return false;
		}
		if(sfss==null||sfss==""){
			$("#error").html("受访宿舍不能为空！");
			return false;
		}
		if(kssj==null||kssj==""){
			$("#error").html("开始时间不能为空！");
			return false;
		}
		if(jssj==null||jssj==""){
			$("#error").html("结束时间不能为空！");
			return false;
		}
		return true;
	}
	
	function resetValue(){
		$("#id").val("");
		$("#fkxm").val("");
		$("#sfzh").val("");
		$("#sfr").val("");
		$("#sfss").val("");
		$("#kssj").val("");
		$("#jssj").val("");
		$("#zt").val("");
		$("#lxfs").val("");
		$("#fwyy").val("");
		
	}
</script>
<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${actionName }</h3>
  </div>
  <div class="panel-body">
    	<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/fkxx?action=save" onsubmit="return checkForm()" >
		  <div class="form-group">
		    <label  class="col-md-2 control-label">访客姓名：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="fkxm"  name="fkxm" style="width: 300px;"  value="${fkxx.fkxm }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">身份证号：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="sfzh"  name="sfzh" style="width: 300px;"  value="${fkxx.sfzh }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-md-2 control-label">受访人：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="sfr"  name="sfr" style="width: 300px;"  value="${fkxx.sfr }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">访问宿舍：</label>
		    <div class="col-md-10">
		      <input type="text" class="form-control" id="sfss"  name="sfss" style="width: 300px;"  value="${fkxx.sfss }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">开始时间：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="kssj"  name="kssj" style="width: 300px;"  value="${fkxx.kssj }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">结束时间：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="jssj"  name="jssj" style="width: 300px;"  value="${fkxx.jssj}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">状态：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="zt"  name="zt" style="width: 300px;"  value="${fkxx.zt }">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-md-2 control-label">联系方式：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="lxfs"  name="lxfs" style="width: 300px;"  value="${fkxx.lxfs}">
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-md-2 control-label">原因：</label>
		    <div class="col-md-10">
			      <input type="text" class="form-control" id="fwyy"  name="fwyy" style="width: 300px;"  value="${fkxx.fwyy}">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="hidden" id="id" name="id" value="${fkxx.id }"/>
		      <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
		      <button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
		      <font color="red" id="error"></font>
		    </div>
		  </div>
		</form>
  </div>
</div>

