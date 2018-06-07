package cn.it.shop.action;

import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
//此Action仅仅用来转发请求,不调用业务逻辑
@Controller
public class SendAction extends ActionSupport {

	public String execute() {

		return "send";
	}
}
