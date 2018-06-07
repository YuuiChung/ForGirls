<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <%@include file="/public/head.jspf"%>
	  <style type="text/css">
		  .searchbox {margin-top:-3px;}
	  </style>
	  <script type="text/javascript">
		  $(function(){
				// 吧当前dom-->query-->easyui对象
				$('#dg').datagrid({
					// 通过后台获取相应的数据,仅仅支持json格式
				    url:'category_queryJoinAccount.action',
				    idField:"id",  // id字段为标识字段,那么此字段状态将会被dg记录下来
				    // 请求远程数据时发送额外的参数
				    queryParams:{type:""},
				    fitColumns:true,  /* 真正的自动展开/收缩列的大小 */
				    striped:true,  /* 显示 奇偶行变色 */
				  	nowrap:true,   /* 则在同一行中显示数据 */
				  	loadMsg:'加载数据的提示信息',
				  	sortName:'id', /* 支持排序的名称 */
				    sortOrder:'asc',
				    rownumbers:true, // 是否显示行编号
				  	remoteSort:false,  /* 必须禁止使用远程排序 */
				    singleSelect:false,
				 	checkOnSelect:false,
				 	/* 分页相关参数配置 */
				 	pagination:true,
				 	pageNumber:1,
				 	pageSize:5,
				 	pageList:[5,10,15,20],
				 	toolbar: [{
						iconCls: 'icon-edit',
						text:'更新类别',
						handler: function(){
							var rows=$("#dg").datagrid("getSelections");
							if(rows.length==1){
								// 发送ajax请求判断是否有权限信息
								$.post("send_category_update.action",null,function(result){
									if(result=="fail"){
										parent.$.messager.confirm('权限不足提示','权限不足,是否注销重新登陆?',function(r){    
							    		    if (r){    
							    		        window.open("alogin.jsp","_top");    
							    		    }    
							    		});
									}else{
										parent.$('#win').window({    
										    width:300,    
										    height:210,
										    title:'更新类别',
										    cache:false,
										    content:result
										});
									}
								},"text");
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
						text:'添加类别',
						handler: function(){
							// 发送ajax请求判断是否有权限信息
							$.post("send_category_save.action",null,function(result){
								if(result=="fail"){
									parent.$.messager.confirm('权限不足提示','权限不足,是否注销重新登陆?',function(r){    
						    		    if (r){    
						    		        window.open("alogin.jsp","_top");    
						    		    }    
						    		});
								}else{
									parent.$('#win').window({    
									    width:270,    
									    height:180,
									    title:'添加类别',
									    cache:false,
									    content:result
									});
								}
							},"text");
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除类别',
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
									    //alert(ids.substring(0,ids.length-1));
									    // 4: 发送请求提交删除信息
									    $.post("category_deleteByIds.action",{ids:ids},function(result){
									    	if(result=="fail"){
									    		parent.$.messager.confirm('权限不足提示','权限不足,是否注销重新登陆?',function(r){    
									    		    if (r){    
									    		        window.open("alogin.jsp","_top");    
									    		    }    
									    		});  
									    	}else{
									    		// 删除成功,重新刷新dg页面
									    		$("#dg").datagrid("clearChecked");
									    		$("#dg").datagrid("reload");
									    	}
									    },"text");
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
				        /* sortName:'id', sortOrder:'desc', remoteSort:false, sortable:true */
						{field:'id',title:'编号',width:100,sortable:true}
				  	]],
				    // 用来设置列的参数
				    columns:[[    
				        /*  field设置字段的名称,与json中的key捆绑 ,title: 列标题   */
				        {field:'type',title:'类别名称',width:100,formatter:function(value,row,index){
				        	return "<span title=" + value + ">" + value + "</span>";
				        }},    
				        {field:'hot',title:'热点',width:300,align:'center',formatter:function(value,row,index){
				        	//console.info(typeof(value));
				        	if(value){
				        		return "<input type='checkbox' value='true' checked='checked' disabled='disabled' />"
				        	}else{
				        		return "<input type='checkbox' value='true' disabled='disabled' />"
				        	}
				        }},
				        {field:'account.login',title:'管理员',width:300,
				        	// 此函数用来设置单元格的样式
				        	/*
				        	styler:function(value,row,index){
				        		if(row.account!=null && row.account.login=='admin'){
				        			// 返回的样式自动交给style属性
				        			return 'background-color: red';
				        		}
				        	},*/
				        	/* 用来格式化将要显示的值  */
				        	formatter: function(value,row,index){
				        		//console.info("value:" + value + ",row:" + row + ",index:" + index);
				        		if(row.account!=null){
				        			return row.account.login;
				        		}
				        	}
				        } 
				    ]]    
				});
				// 设置搜索框
				$('#ss').searchbox({ 
					// 在用户按下搜索按钮或回车键的时候调用searcher函数
					searcher:function(value,name){ 
						// 调用dataGride的查询方法(查询第一页)
						//alert(value + "," + name);  // load 如果有参数将会取代 queryParams属性中指定的参数信息
						$('#dg').datagrid('load',{type:value});
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
