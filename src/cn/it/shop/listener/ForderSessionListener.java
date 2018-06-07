package cn.it.shop.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import cn.it.shop.model.Forder;

public class ForderSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// 第一访问的时候创建购物车,并且存储到session中
		System.out.println("------sessionCreated------");
		event.getSession().setAttribute("forder", new Forder());
	}

	@Override	// 在session销毁的时候执行(用来实现"最后登陆时间")
	public void sessionDestroyed(HttpSessionEvent event) {
	}

}
