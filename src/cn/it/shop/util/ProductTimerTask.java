package cn.it.shop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Component;
import cn.it.shop.model.Category;
import cn.it.shop.model.Product;
import cn.it.shop.service.CategoryService;
import cn.it.shop.service.ProductService;

@Component
public class ProductTimerTask extends TimerTask {

	@Resource
	private ProductService productService;
	@Resource
	private CategoryService categoryService;

	private ServletContext application;

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		List<List<Product>> bigList = new ArrayList<List<Product>>();
		// 查询热点类别
		for (Category category : categoryService.queryByHot(true)) {
			// 根据热点类别的id获取推荐商品
			bigList.add(productService.queryByCid(category.getId()));
		}
		System.out.println("bigList"+bigList.size());
		// 把查询的bigList交给Application内置对象
		application.setAttribute("bigList", bigList);
	}

}
