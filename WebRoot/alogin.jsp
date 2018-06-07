<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("[name=login]").validatebox({
				required:true,
				missingMessage:'登陆名必填'
			});
			$("[name=pass]").validatebox({
				required:true,
				missingMessage:'密码必填'
			});
			// 关闭验证
			$("#ff").form("disableValidation");
			$('#dd').dialog({    
			    title: '系统后台入口',    
			    width: 270,    
			    height:200,
			    modal: true,
			    buttons:[{
					text:'登陆',
					handler:function(){
						$("#ff").form("enableValidation");
						if($("#ff").form("validate")){
							// 提交登陆请求,如果需要http提交请求,则调用 dom: submit方法
							$("#ff").get(0).submit();  // dom对象的submit方法才是 http请求
						}
					}
				},{
					text:'取消',
					handler:function(){
						alert("取消");					
					}
				}]
			});
		});
	</script>
</head>
<body>
	<div id="dd">
		<form id="ff" method="post" action="${shop}/login.action">
			<div>
				<label for="login">账号:</label> 
				<input type="text" name="login" value="admin" />
			</div>
			<div>
				<label for="pass">密码:</label> 
				<input type="text" name="pass" value="admin" />
			</div>
			<div>
			    <!-- 支持 request session application -->
			    <!-- 去访问 request.getAttribute("error") 但是我们的错误消息是在  struts的requestMap中 
			    	 struts 已经吧 request内置对象给封装  StrutsRequestWrapper (装饰模式)
			    -->
				${requestScope.error}  
			</div>
		</form>
	</div>
</body>
</html>
