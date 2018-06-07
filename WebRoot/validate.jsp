<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/public/head.jspf" %>
    <script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/jquery-1.8.3.js"></script>
  	<script type="text/javascript" src="${shop }/jquery-easyui-1.3.5/jquery.validate.js"></script>
    
    <style type="text/css">
		form label{
			color: red;
			padding-left: 20px;
			background-image: url("image/error.png");
			background-repeat: no-repeat;
		}
		.success{
            background-image: url("../image/right.png");
			width:20px;
			background-repeat: no-repeat;		}
	</style>
    
    <script type="text/javascript">
    	$(function(){
    		/*
			    定义验证方式,要写在前面,后面会调用
			  	1: 函数名称
			  	2: 函数体(待验证数据,验证对象,参数)
			  	3: 错误消息
			*/
			$.validator.addMethod("phone", function(value,element,param) { 
				  var exp=new RegExp(/^1\d{10}$/);
				  return exp.test(value);
			},"手机号码不正确");
			
			jQuery.validator.addMethod("checkPic", function(value, element,param) {
			    var filepath=$("#image").val();
			    //获得上传文件名
			    var fileArr=filepath.split("\\");
			    var fileTArr=fileArr[fileArr.length-1].toLowerCase().split(".");
			    var filetype=fileTArr[fileTArr.length-1];
			    //切割出后缀文件名
			    if(filetype == "png" || filetype == "gif" || filetype == "jpg"){
			        return true;
			    }else{
			        return false;
			    }
			}, "文件的格式必须为{0}");
    		
    	
    		$("#ff").validate({
    			debug:true,
    			/*//errorClass:'error', 错误消息和文本框 样式同,不友好
				 errorPlacement:function(error,element){
					$(element).parent().next().html(error);
				},
				success:function(label){  // label为存储错误消息的容器
					$(label).html("　")
					$(label).attr("class", "success"); //会把以前的样式移除掉
					//$(label).addClass("success");    //追加样式
					//alert($(label).attr("class"));   //查看目前的样式,多个用空格隔开
				}, */
    			onkeyup:true, /*当丢失焦点的时候才会触发验证请求*/
				rules:{
					name:{
						required:true,
						remote:{
							url:'forder_ajaxCheck.action',
							type:'post'
						}
					},
					pass:{
						required:true,
						rangelength:[6,12]
					},
					pass2:{
						required:true,
						equalTo:'#pass'
					},
					email:{
						required:true,
						email:true
					},
					like:{
						required:true
					},
					phone:{
						phone:true
					},
					image:{
						required:true,
						checkPic: "png|jpeg|jpg|gif"
					},
					address:{
						required:true
					}
				},
    			messages:{
					name:{
						required:"用户名不能为空",
						remote: "用户名不正确"
					},
					pass:{
					   	required:"密码不能为空",
						rangelength:$.validator.format('密码的长度必须为{0}到{1}位')
					},
					pass2:{
						required:"密码确认不能为空"
					},
					email:{
						required:"邮箱不能为空"
					},
					like:{
						required:"请选择一个爱好"
					},
					address:{
						required:"地址不能为空"
					},
					image:{
						required:'必须上传头像',
					}
				}
    			
    		});
    	});
    </script>
   </head>
  
  <body>
  	<ul>
  	  	<li>此案例用于测试验证环境,支持IE和火狐</li>
  	  	<li>在官方有指定的版本, 不同插件需要不同的Jquery版本</li>
  	  	<li>如果提交按钮没有跳转到目标页面,则说明bebug模式启用成功</li>
      	<li>注意,Jquery.js包必须放到jquery.validate.js之前</li>
      	<li>测试了系统提供的常见验证方法</li>
  	  	<li>如果有多个参用数组接受</li>
  	  	<li>密码、文件上传的参数传递,参考源码</li>
  	  	<li>错误消息默认为英文,且自动添加到验证元素的后面</li>
      	<li>添加了错误消息,格式同rules格式一样</li>
  	  	<li>如果在错误消息中要显示参数则$.format()的方式</li>
  	  	<li>添加了自定义方法,注意必须写在验证方法的前面</li>
  	  	<li>onkeyup:false:验证失败后,"键盘按上"事件会触发,关闭即可</li>
  	  	<li>实现了远程验证的功能+Struts输出流的使用</li>
  	  	<li>注意: 默认是get请求在IE的时候会出现get缓存问题.可以改成post请求,提交验证</li>
      	<li>显示默认样式: errorClass:error</li>
	  	<li>配置了默认显示的位置:errorPlacement:function(error,element)</li>
	  	<li>errorElement:'b'</li>
	  	<li>配置了错误和正确的图标</li>
      	<li>260行，有缺省的验证配置</li>
      	<li>352行，有验证方法出错的错误消息</li>
  	 </ul>
      <form id = "ff" action="http://www.hao123.com" method="post">
      	登录名:<input type="text" name="name" /><br/>
      	 密码:<input type="password" name="pass" id="pass" /><br/>
      	 密码确认:<input type="password" name="pass2" /><br/>
      	 邮箱:<input type="text" name="email" /><br/>
      	 爱好:
	      	看书:<input type="checkbox" name="like" />
	      	上网:<input type="checkbox" name="like" />
	      	旅游:<input type="checkbox" name="like" />
	    <br/>
	        头像:<input type="file" name="image" id= "image"/><br/>
	        地址:<select name="address">
	        	<option value="">---请选择---</option>
	        	<option value="1">广东</option>
	        	<option value="2">北京</option>
	        	<option value="3">上海</option>
	        </select>
	    <br/>
	        手机号码:<input type="text" name="phone" /><br>
      	<u><input type="submit" value="提交"></u>
      </form>
  	
  </body>
</html>
