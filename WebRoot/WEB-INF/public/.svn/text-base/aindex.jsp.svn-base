<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	 <style type="text/css">
	        /*
	  		#menu{
	  			border: 1px solid red;
	  			width: 200px;
	  		} */
	  		#menu ul{
	  			list-style-type: none;
	  			padding: 0px;
	  			margin: 0px;
	  		}
	  		#menu ul li{
	  			border-bottom: 1px solid #008792;
	  		}
	  		#menu ul li a{
		  		/* 先把a标签转化为块级标签  */
		  		display: block;
		  		padding: 5px;
		  		text-decoration: none;
		  		/*border-left: 12px solid #008792;*/
	  		}
	  		#menu ul li a:hover{
	  			background-color: #008792;
	  			color: #fff;
	  		}
	  </style>
	<script type="text/javascript" src="${shop}/js/public/aindex.js"></script>
</head>
<!-- css的方式创建 layout -->
<body class="easyui-layout">
	<!-- data-options:用来设置 ui组件的参数 -->
	<div data-options="region:'north',title:'欢迎来到易购商城后台管理系统',split:true" style="height:150px;padding: 10px;">
		 你好: ${sessionScope.account.username} 角色为:${sessionScope.account.authorities}
        <a href="j_spring_security_logout">注销</a>
	</div>
	<div data-options="region:'west',title:'系统菜单',split:true" style="width:180px;">
		<!-- 用来显示折叠菜单  采用css的方式创建  easyui-组件名称 -->
		<div id="menu" class="easyui-accordion" data-options="fit:true">
			<div title="基本菜单">
				<ul>
					<li><a title="send_product_query.action" href="#">商品管理</a></li>
					<li><a title="send_category_query.action" href="#">类别管理</a></li>
				</ul>
			</div>
			<div title="角色权限">
				<ul>
					<li><a title="send_account_query.action" href="#">账户管理</a></li>
					<li><a title="send_role_query.action" href="#">角色管理</a></li>
				</ul>		
			</div>
			<div title="销售管理" data-options="selected:true">
				<ul>
					<li><a title="send_sole_sole.action" href="#">报表统计</a></li>
				</ul>		
			</div>
		</div>
	</div>
	
	<div data-options="region:'center',title:'控制面板'" style="padding:1px;background:#fff;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">   
		    <div title="系统参数信息" style="padding:5px;">   
		                         此处显示服务器的参数信息
		    </div>
		</div>  
	</div>
	
	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
	
</body>
</html>
