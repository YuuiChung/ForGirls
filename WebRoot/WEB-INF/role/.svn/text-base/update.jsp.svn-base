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
	  			var rows=parent.$("iframe[title='角色管理']").get(0).contentWindow.$("#dg").datagrid("getSelections");
	  			// 对表单的数据进行填充
	  			$('#ff').form('load',{
	  				id:rows[0].id,
	  				name:rows[0].name,
	  				detail:rows[0].detail
	  			});
	  			/* 显示授权的树形菜单,(目前不支持数据回显功能) */
	  			$('#tt').tree({    
	  				// 需要查询当前用户的权限集合
				    url:'privilege_queryForTree.action?role.id=' + $("#id").val(),
				    checkbox:true,
				    cascadeCheck:true,
				    lines:true,
				    onBeforeExpand:function(){
				    	$("#tt").tree("collapseAll");
				    }
				});
	  			// 触发提交事件
	  			$("#submit").click(function(){
	  				// 获取被选中的树形菜单id值
	  				var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
	  				var ids="";
	  				for(var i=0;i<nodes.length;i++){
	  					ids +=nodes[i].id + ",";
	  				}
	  				$("#ids").val(ids.substring(0,ids.length-1));
	  				// ajax 提交表单数据
	  				$('#ff').form("submit",{
						url:"role_update.action",
						success:function(){
							// 重置表单
							$("#ff").form("reset");
							// 关闭窗体
							parent.$("#win").window("close");
							// 刷新dg结果,重新加载当前行
							parent.$("iframe[title='角色管理']").get(0).contentWindow.$("#dg").datagrid("reload");
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
	        <label for="detail">详细描述:</label>
	        <textarea rows="4" cols="20" name="detail"></textarea>
	    </div>   	    
	    <div>   
	        <label for="role">给角色授权:</label>
	        <ul id="tt"></ul>  
	    </div>   	    
	    <div>
	    	<!-- 根据需求此时的提交事件为ajax比较好 -->
	    	<a id="submit" href="#" class="easyui-linkbutton">更新与授权</a> 
	    	<input type="hidden" name="id" id="id" />
	    	<input type="hidden" name="ids" id="ids" />
	    </div>
	</form>  
  </body>
</html>
