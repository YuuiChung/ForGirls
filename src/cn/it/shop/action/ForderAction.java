package cn.it.shop.action;

import java.io.ByteArrayInputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Status;
import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {

//	@Override  此方式在此处不安全
//	public Forder getModel() {
//		// session中已经存储了购物项集合,然后吧配送信息注入到 model中,即可入库
//		model=(Forder)session.get("forder");
//		return model;
//	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String save() {
		/*forderService.save(model);
		session.put("oldForder", session.remove("forder"));*/
		Forder forder=(Forder)session.get("forder");
		
		forder.setAddress(model.getAddress());
		forder.setPhone(model.getPhone());
		forder.setName(model.getName());
		forder.setRemark(model.getRemark());
		forder.setPost(model.getPost());
		forder.setUser((User)session.get("user"));
		forder.setStatus(new Status(1));
		//。。。。。。
		forderService.save(forder);
		session.put("oldForder", session.get("forder"));
		// 此时购物车已经入库, 那么原来session中的购物车就应该清空
		session.put("forder", new Forder());

		return "bank";
	}
	
	public String ajaxCheck(){
		System.out.println(name);
		if (name.equals("admin")) {
			inputStream = new ByteArrayInputStream("true".getBytes());
		} else {
			inputStream = new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
}
