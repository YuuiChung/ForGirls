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
				// 配置验证
				$("[name='name']").validatebox({    
				    required: true,
				    missingMessage:"角色名称必须填写",
				});
				$("[name='detail']").validatebox({    
				    required: true,
				    missingMessage:"详细介绍不能为空",
				});
				// 页面加载的时候禁止验证
				$("#ff").form("disableValidation");
				// 注册提交事件
				$("#save").click(function(){
					// 开启验证
					$("#ff").form("enableValidation");
					// 实现表单提交功能,默认是ajax提交,在提交之前会自动验证
					$("#ff").form("submit",{    
					    url:"role_save.action",
					    success:function(){    
					    	$("#ff").form("disableValidation");
					     	// 当前窗体先找到 父窗体(layout) 然后通过layout找相应 iframe中 dg
							var iframe = parent.$.find("iframe[title='角色管理']")[0];
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
			<label for="name">角色名称:</label> 
			<input type="text" name="name" />
		</div>
		<div>
			<label for="detail">详细介绍:</label> 
			<textarea rows="2" cols="30" name="detail"></textarea>
		</div>
			<a id="save" href="#" class="easyui-linkbutton">添加</a>
		</div>
	</form>
  </body>
</html>
