package cn.it.shop.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import cn.it.shop.model.Account;

public class AccountHttpSessionAttributeListener implements
		HttpSessionAttributeListener {
	private SecurityContext context = null;

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if(event.getName().equals("SPRING_SECURITY_CONTEXT")){
			System.out.println("----session中存储了登陆信息------");
			context=SecurityContextHolder.getContext();
			Account account=(Account)context.getAuthentication().getPrincipal();
			event.getSession().setAttribute("account", account);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		if(event.getName().equals("SPRING_SECURITY_CONTEXT")){
			System.out.println("----session中更新登陆信息------");
			context=SecurityContextHolder.getContext();
			Account account=(Account)context.getAuthentication().getPrincipal();
			event.getSession().setAttribute("account", account);
		}
	}

}
