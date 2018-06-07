<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
	  <style type="text/css">
	  	form > div{
	  		padding-bottom: 10px;
	  	}
	  </style>
	  <script type="text/javascript">
	  		$(function(){
	 			/*完成数据的回显 */ 
	  			var rows=parent.$("iframe[title='账户管理']").get(0).contentWindow.$("#dg").datagrid("getSelections");
	  			// 对表单的数据进行填充
	  			$('#ff').form('load',{
	  				id:rows[0].id,
	  				name:rows[0].name,
	  				login:rows[0].login
	  			});
	  			// 触发提交事件
	  			$("#submit").click(function(){
	  				// ajax 提交表单数据
	  				$('#ff').form("submit",{
						url:"account_updateHql.action",
						success:function(){
							// 重置表单
							$("#ff").form("reset");
							// 关闭窗体
							parent.$("#win").window("close");
							// 刷新dg结果,重新加载当前行
							parent.$("iframe[title='账户管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
	  			});
	  		});
	  </script>
  </head>
  <body>
  	<form id="ff" method="post">   
	    <div>   
	        <label for="login">账户名称:</label>
	        <input type="text" name="login" />   
	    </div>   
	    
	    <div>   
	        <label for="name">真实姓名:</label>
	          <input type="text" name="name" />   
	    </div>   	    
	    <div>
	    	<a id="submit" href="#" class="easyui-linkbutton">更新账户</a> 
	    	<input type="hidden" name="id" id="id" />
	    </div>
	</form>  
  </body>
</html>
