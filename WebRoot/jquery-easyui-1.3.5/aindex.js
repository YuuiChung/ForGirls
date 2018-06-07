$(function(){  // js文件内部是不能使用 jstl变量的 ${shop}
	// 1: 注册 a标签单击事件  [] 是属性选择器
	$("a[title]").click(function(){
		// 2: 获取当前a标签的属性值 
		var text=$(this).text();
		var href=$(this).attr("title");
		if($("#tt").tabs('exists',text)){
			// 当前选项卡已经存在,切换即可
			$("#tt").tabs('select',text);
		}else{
			$.post(href,null,function(result){
				if(result=="fail"){
					parent.$.messager.confirm('权限不足提示','权限不足,是否注销重新登陆?',function(r){    
		    		    if (r){    
		    		        window.open("alogin.jsp","_top");    
		    		    }    
		    		});
				}else{
					// 创建新的选项卡
					$("#tt").tabs('add',{
						title: text,
						content:"<iframe title=" + text + " src= " + href + " width='100%' height='100%' frameborder='0' />",
						closable:true
					});
				}
			},"text");
		}
	});
});