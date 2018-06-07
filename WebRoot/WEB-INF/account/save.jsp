<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
	  <style type="text/css">
	  	form div{
	  		margin-bottom: 5px;
	  	}
	  </style>
	  <script type="text/javascript">
		  $(function(){	
				// 注册提交事件
				$("#save").click(function(){
					$("#ff").form("submit",{    
					    url:"account_save.action",
					    success:function(){    
					     	// 当前窗体先找到 父窗体(layout) 然后通过layout找相应 iframe中 dg
							var iframe = parent.$.find("iframe[title='账户管理']")[0];
					        iframe.contentWindow.$("#dg").datagrid("reload");
					        parent.$("#win").window("close");
					    }    
					});  
				});
			});
	  </script>
  </head>
  <body>

  	  <form id="ff" method="post">
		<div>
			<label for="login">账户:</label> 
			<input type="text" name="login" />
		</div>
		<div>
			<label for="name">姓名:</label> 
			<input type="text" name="name" />
		</div>
		<div>
			<label for="pass">密码:</label> 
			<input type="password" name="pass" />
		</div>
		</div>
			<a id="save" href="#" class="easyui-linkbutton">添加</a>
		</div>
	</form>
  </body>
</html>
