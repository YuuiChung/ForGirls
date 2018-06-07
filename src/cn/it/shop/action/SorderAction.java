package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {

	public String addSorder() {
		Product product = productService.getId(model.getProduct().getId());
		if (session.get("forder") == null) {
			session.put("forder", new Forder(new ArrayList<Sorder>()));
		}
		Forder forder = (Forder) session.get("forder");
		sorderService.addSorder(forder, product);
		forder.setTotal(forderService.culTotal(forder));
		session.put("forder", forder);

		return "showCar";
	}

	public String updateSorder() {
		Forder forder = (Forder) session.get("forder");
		forder = forderService.updateSorder(forder, model);
		forder.setTotal(forderService.culTotal(forder));
		session.put("forder", forder);
		inputStream = new ByteArrayInputStream(forder.getTotal().toString()
				.getBytes());

		return "stream";
	}

	public String querySale() {
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
