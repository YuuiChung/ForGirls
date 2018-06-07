<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="myFn" uri="http://www.shop.com/jstl/my/myFn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<style type="text/css">
		form div{
			margin: 5px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			// 当前窗体先找到 父窗体(layout) 然后通过layout找相应 iframe中 dg
			var iframe = parent.$.find("iframe[title='账户管理']")[0];
			var rows = iframe.contentWindow.$("#dg").datagrid('getSelections');
			// 吧rows中的记录,给相应的form表单元素
			$('#ff').form('load',{
				id:rows[0].id,
				name:rows[0].name,
			    login:rows[0].login
			});
			// 注册提交事件
			$("#update").click(function(){
				$("#ff").form("submit",{    
					// 给角色授权本质是在更新中间表, 但是在hibernate中中间表是没有实体的, 因此只能通过 role.update() 自动级联更新
				    url:"account_grantRole.action",
				    success:function(){    
				        // 清空表单所有数据,包括缺省值
				        parent.$("#win").window("close");
				        iframe.contentWindow.$("#dg").datagrid("reload");
				    }    
				});
			});
		});
	</script>
</head>
<body>
	<form id="ff" method="post">
		<div>
			<label for="login">登陆名:</label> 
			<input type="text" name="login" disabled="disabled" />
		</div>
		<div>
			<label for="name">真实姓名:</label> 
			<input type="text" name="name" disabled="disabled" />
		</div>
		<div>
			当前拥有的角色为: <br />
			<c:forEach items="${requestScope.roleList}" var="role">
				角色名称: <input type="checkbox" name="rids" value="${role.id}" 
				<c:if test="${myFn:contains(role.id,requestScope.myRids)}">
					checked="checked"
				</c:if> />${role.name}<br />
				角色介绍: ${role.detail}<br />
			</c:forEach>
		</div>
		<div>
			<a id="update" href="#" class="easyui-linkbutton">授予角色</a>
			<input type="hidden" name="id" id="id" size="2" />
		</div>
	</form>
</body>
</html>
