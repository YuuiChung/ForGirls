package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.User;
/*
 * MethodFilterInterceptor--->AbstractInterceptor--->Interceptor
 * MethodFilterInterceptor: 支持方法过滤的功能  intercept用来进行方法过滤的
 * doIntercept 才是用来执行具体的页面逻辑
 *   
 * 
 * */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	public String login() {
		model = userService.login(model);
		if (model == null) {
			// 登陆失败,重新跳转到登陆页面
			session.put("error", "登录失败");
			return "ulogin";
		} else {
			// 登陆成功,跳转到首页
			session.put("user", model);
			// 根据需求是否被过滤器拦截器选择跳转到不同页面
			if (session.get("goURL") == null) {
				return "index";
			} else {
				return "goURL";
			}
		}
	}
}
