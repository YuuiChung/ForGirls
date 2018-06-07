package cn.it.shop.service;

import java.util.List;
import cn.it.shop.model.Category;

public interface CategoryService extends BaseService<Category> {

	// 进行分页查询
	public List<Category> queryJoinAccount(String type, int page, int size);

	// 根据关键字查询总记录数
	public Long getCount(String type);

	// 多记录删除
	public void deleteByIds(String ids);

	// 查询出热点类别
	public List<Category> queryByHot(boolean hot);
}
