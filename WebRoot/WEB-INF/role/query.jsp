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
				    url:'role_query.action',
				    idField:"id",  // id字段为标识字段,那么此字段状态将会被dg记录下来
				    // 请求远程数据时发送额外的参数
				    queryParams:{name:""},
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
						text:'更新与授权',
						handler: function(){
							var rows=$("#dg").datagrid("getSelections");
							if(rows.length==1){
								parent.$('#win').window({    
								    width:350,    
								    height:400,    
								    content:"<iframe src='send_role_update.action' width='100%' height='100%' frameborder='0' />",
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
						iconCls: 'icon-add',
						text:'添加角色',
						handler: function(){
							parent.$('#win').window({    
								width:300,    
							    height:200,
							    title: '添加角色',
							    content:"<iframe src='send_role_save.action' width='100%' height='100%' frameborder='0' />",
							});
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除角色',
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
									    // 3: 获取要删除的 id值   1,2,3===> String ids  delete from category where id in (1,2,3)
									    var ids="";
									    for(var i=0;i<rows.length;i++){
									    	ids += rows[i].id + ",";
									    }
									    ids=ids.substring(0,ids.length-1);
									    // 4: 发送请求提交删除信息
									    $.post("role_deleteByIds.action",{ids:ids});
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
				        {field:'name',title:'角色名称',width:100},    
				        {field:'detail',title:'详细介绍',width:300,align:'center'}
				    ]]    
				});
				// 设置搜索框
				$('#ss').searchbox({ 
					searcher:function(value,name){ 
						$('#dg').datagrid('load',{name:value});
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
