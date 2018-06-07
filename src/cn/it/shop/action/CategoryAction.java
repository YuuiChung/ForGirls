package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.Account;
import cn.it.shop.model.Category;
import cn.it.shop.model.PageModel;
@Controller
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {

	public void save() {
		categoryService.save(model);
		/*System.out.println(model);
		// 在此处吧session中的account获取之后交给 model.setAccount();
		Account account=new Account();
		account.setId(1);
		model.setAccount(account);
		categoryService.save(model);*/
	}

	public void update() {
		categoryService.update(model);
	}

	public String query() {
		jsonList = categoryService.query();

		return "jsonList";
	}
	
	public String deleteByIds() {
		categoryService.deleteByIds(ids);
		System.out.println("删除的id为：" + ids);
		inputStream = new ByteArrayInputStream("true".getBytes());

		return "stream";

	}
	
	public String queryJoinAccount() {
		System.out.println(model.getType() + "," + page + "," + rows);
		// root中配置 pageModel
		pageModel=new PageModel<Category>();
		pageModel.setTotal(categoryService.getCount(model.getType()));
		pageModel.setRows(categoryService.queryJoinAccount(model.getType(), page, rows));
		return "pageModel";

	}

}
