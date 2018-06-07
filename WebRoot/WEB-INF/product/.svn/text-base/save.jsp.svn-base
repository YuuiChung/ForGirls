<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			// 通过远程加载管理员信息
 			$('#cc').combobox({    
			    url:'category_query.action',    
			    valueField:'id',    
			    textField:'type',
			    editable:false,
			    panelHeight:'auto',
			    required: true,
			    missingMessage:'请选择所属类别'
			});
			// 自定义验证函数,采用jquery.extend扩展机制来实现
			$.extend($.fn.validatebox.defaults.rules, {    
				// key:value  [key:函数名  value:{key:value}]
			    // type: 函数名称, validator: 函数实现体
			    // message: 错误key, value：具体的错误消息
			    type: {    
			        validator: function(value,param){    
			            // alert("value:" + value + ",param:" + param.length);
			            // 获取当前文件的扩展名
			            var ext=value.substring(value.lastIndexOf(".")+1);
			            var params=param[0].split(",");
			            for(var i=0;i<params.length;i++){
			            	if(ext==params[i])
			            		return true;
			            }
			        	return false;
			        },    
			        // {0} 代表传入的第一个参数
			        message: '文件类型必须为:{0}'   
			    }    
			});  
			
			$("[name='name']").validatebox({    
			    required: true   
			});
			$("[name='price']").numberbox({
				required:true,
			    min:0,    
			    precision:2,   // 保留2位小数
			    prefix:'$ '
			});  
			$("[name='image.upload']").validatebox({
				required:true,   // file文本域 validatebox不能实现及时验证. 
				missingMessage:'必须要上传图片',
				// 如果验证的函数有参数,则直接在后面添中括号
				validType:"type['gif,png,jpg']"
			});
			/* 自定义change事件来实现文本域及时验证效果 */
			$("[name='image.upload']").change(function(){
				$(this).validatebox("validate");
			});
			// 开始时要禁止验证
			$("#ff").form("disableValidation");
			$("#submit").click(function(){
  				// 开启验证
  				$("#ff").form("enableValidation");
  				// 验证通过则返回为true
  				if($("#ff").form("validate")){
	  				// ajax 提交表单数据
	  				$('#ff').form("submit",{
						url:"product_save.action",
						success:function(){
							$("#ff").form("reset");
							// 关闭窗体
							parent.$("#win").window("close");
	  						// 刷新dg结果,重新加载当前行
	  						// parent.$("#dg").datagrid("reload");
	  						// 先找到当前页面的父窗体，然后在找parent的iframe(通过属性选择器来区分不同的iframe)
	  						
							// jquery 2.0版本 不支持,可以调用dom相应的方法
							// console.info(parent.$("iframe[title='商品管理']").contents().find("#dg").datagrid("reload"));
			  				// contentWindow 获取iframe页面的window对象
							parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
  				}
  			});
		});
	</script>
</head>

<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="image.upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="category.id" />
	</div>
	<div>
		<label>加入推荐:</label> 
		推荐:<input type="radio" name="commend" checked="checked" value="true" />  
		不推荐:<input type="radio" name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>
</body>
</html>
