<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@include file="/public/head.jspf" %>	
	  <script type="text/javascript">
		  $(function(){
			  $('#tt').tree({    
				    url:'tree_data.json',
				    checkbox:true,
				    // 注册一个事件,在节点展开前触发,false则取消展开操作
				    onBeforeExpand:function(node){
				    	// 关闭所有节点,如果后面返回为true 则会自动展开当前节点
				    	$("#tt").tree("collapseAll");
				    	//return false;
				    }
			  });   
		  });
	  </script>
  </head>
  <body>
  	 <ul id="tt"></ul>
  </body>
</html>
