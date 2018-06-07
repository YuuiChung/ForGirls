<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <%@include file="/public/head.jspf"%>
	  <style type="text/css">
		  	.searchbox {
				margin-top:-3px;
			}
	  </style>
	  <script type="text/javascript">
		  $(function(){
				$('#dg').datagrid({
					// 通过后台获取相应的数据,仅仅支持json格式
				    url:'account_queryForPage.action',
				    idField:"id",  // id字段为标识字段,那么此字段状态将会被dg记录下来
				    // 请求远程数据时发送额外的参数
				    queryParams:{login:""},
				    fitColumns:true,  /* 真正的自动展开/收缩列的大小 */
				    striped:true,  /* 显示 奇偶行变色 */
				  	nowrap:true,   /* 则在同一行中显示数据 */
				  	loadMsg:'加载数据的提示信息',
				    rownumbers:true, // 是否显示行编号
				    singleSelect:false,
				 	/* 分页相关参数配置 */
				 	pagination:true,
				 	pageNumber:1,
				 	pageSize:5,
				 	pageList:[5,10,15,20],
				 	toolbar: [{
						iconCls: 'icon-edit',
						text:'更新',
						handler: function(){
							var rows=$("#dg").datagrid("getSelections");
							if(rows.length==1){
								parent.$('#win').window({    
								    width:350,    
								    height:200,    
								    content:"<iframe src='send_account_update.action' width='100%' height='100%' frameborder='0' />",
								});			
							}else{
								$.messager.show({
									title:'提示消息',
									msg:'只能更新一条记录',
									timeout:2000,
									showType:'slide'
								});
							}
						}
					},'-',{
						iconCls: 'icon-edit',
						text:'授予角色',
						handler: function(){
							var rows=$("#dg").datagrid("getSelections");
	    					if(rows.length!=1){
	    						$.messager.show({
	    							title:'操作提示!',
	    							msg:'每次只能更新一条记录',
	    							timeout:2000,
	    							showType:'slide'
	    						});
	    					}else{
		    					parent.$('#win').window({    
		    					    width:350,    
		    					    height:380,
		    					    title:"授予角色",
		    					    // 先查询所有的角色信息数据,在跳转到  给管理员授予角色的页面
		    					    content:"<iframe scrolling='no' src='account_getAccount.action?id=" + rows[0].id  + "' width='100%' height='100%' frameborder='0' />",
		    					    modal:true   
		    					});
	    					}
						}
					},'-',{
						iconCls: 'icon-add',
						text:'添加账户',
						handler: function(){
							parent.$('#win').window({    
								width:270,    
							    height:230,
							    content:"<iframe src='send_account_save.action' width='100%' height='100%' frameborder='0' />",
							});
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除账户',
						handler: function(){
							// 1: 获取被选中的行
							var rows=$("#dg").datagrid("getSelections");
							// 2： 对事件进行判断, 和删除确认
							if(rows.length==0){
								$.messager.show({
									title:'提示消息',
									msg:'至少选择一条记录',
									timeout:2000,
									showType:'slide'
								});
							}else{
								$.messager.confirm('删除确认', '您确认删除选中的数据吗?', function(r){
									if (r){
									    var ids="";
									    for(var i=0;i<rows.length;i++){
									    	ids += rows[i].id + ",";
									    }
									    ids=ids.substring(0,ids.length-1);
									    // 4: 发送请求提交删除信息
									    $.post("account_deleteByIds.action",{ids:ids});
									    // 清除原来被选中的记录
									 	$("#dg").datagrid("clearChecked");
									 	// 5: 刷新当前页数据
									 	$("#dg").datagrid("reload");
									}
								});
							}
						}
					},'-',{
						text:"<input type='text' id='ss' />"
					}],
				    /*冻结列,适合列比较多的情况*/
				  	frozenColumns:[[
				        {field:'xyz',width:50,checkbox:true},    
						{field:'id',title:'编号',width:100,sortable:true}
				  	]],
				    columns:[[    
				        {field:'login',title:'登陆名',width:100},    
				        {field:'name',title:'名称',width:300,align:'center'}
				    ]]    
				});
				// 设置搜索框
				$('#ss').searchbox({ 
					searcher:function(value,name){ 
						$('#dg').datagrid('load',{login:value});
					}, 
					prompt:'变形金刚4' 
				}); 
			});
	  </script>
  </head>
  <body style="margin: 1px;">
  	 <table id="dg"></table>
  </body>
</html>
