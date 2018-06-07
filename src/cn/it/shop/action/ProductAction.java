package cn.it.shop.action;

import java.io.ByteArrayInputStream;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.PageModel;
import cn.it.shop.model.Product;
@Controller
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	private String ids;
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public void save() {
		String pic = fileUpload.uploadFile(getFileImage());
		System.out.println(pic);
		model.setPic(pic);
		model.setDate(new Date());
		productService.save(model);

	}

	public void update() {
		productService.update(model);

	}

	public String get() {
		Product product = productService.getId(model.getId());
		request.put("product", product);
		return "detail";
	}

	public String deleteByIds() {
		productService.deleteByIds(ids);
		System.out.println("删除的id为：" + ids);
		inputStream = new ByteArrayInputStream("true".getBytes());

		return "stream";

	}

	
	public String queryJoinCategory() {
		System.out.println(model.getName() + "," + page + "," + rows);
		// root中配置 pageModel
		pageModel = new PageModel<Product>();
		pageModel.setTotal(productService.getCount(model.getName()));
		pageModel.setRows(productService.queryJoinCategory(model.getName(),
				page, rows));
		return "pageModel";

	}

}
