package cn.it.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import cn.it.shop.util.FileUpload;
import cn.it.shop.util.ProductTimerTask;

public class InitDataListener implements ServletContextListener {

	private FileUpload fileUpload;
	private ApplicationContext context;
	private ProductTimerTask productTimerTask;

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

	@Override  // jsp ----> html (静态化)
	public void contextInitialized(ServletContextEvent event) {
		context = WebApplicationContextUtils.getWebApplicationContext(event
				.getServletContext());
		productTimerTask = (ProductTimerTask) context
				.getBean("productTimerTask");
		fileUpload = (FileUpload) context.getBean("fileUpload");
		productTimerTask.setApplication(event.getServletContext());
		// 设置定时器
		new java.util.Timer(true).schedule(productTimerTask, 0, 60 * 60000);
		// 项目启动时加载银行图标
		event.getServletContext().setAttribute("bankName",
				fileUpload.getBankImage());
	}

}
