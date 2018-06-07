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
				    url:'product_queryJoinCategory.action',
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
						text:'更新商品',
						handler: function(){alert("自己实现");	}
					},'-',{
						iconCls: 'icon-add',
						text:'添加商品',
						handler: function(){
							 $.post("send_product_save.action",null,function(result){
								 if(result=="fail"){
									// 对整个屏幕进行锁屏
						    		parent.$.messager.confirm('权限不足提示','权限不足,是否注销重新登陆?',function(r){    
						    		    if (r){    
						    		        window.open("alogin.jsp","_top");    
						    		    }    
						    		});  
						    	}else{
									parent.$('#win').window({    
									    width:500,    
									    height:600,    
									    content:result
									});						    		
						    	}
						    },"text");
						}
					},'-',{
						iconCls: 'icon-remove',
						text:'删除类别',
						handler: function(){
							alert("自己实现");
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
				        {field:'name',title:'商品名称',width:100},    
				        {field:'price',title:'价格',width:300,align:'center'},
				        {field:'remark',title:'简单介绍',width:300,align:'center'},
				        {field:'category.type',title:'所属类别',width:300,
				        	formatter: function(value,row,index){
				        		if(row.category!=null){
				        			return row.category.type;
				        		}
				        	}
				        } 
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
