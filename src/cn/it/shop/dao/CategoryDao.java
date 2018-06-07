package cn.it.shop.dao;

import java.util.List;
import cn.it.shop.model.Category;

public interface CategoryDao extends BaseDao<Category> {

	// 进行分页查询
	public List<Category> queryJoinAccount(String name, int page, int size);

	// 根据关键字查询总记录数
	public Long getCount(String name);

	// 多记录删除
	public void deleteByIds(String ids);

	// 查询出热点类别
	public List<Category> queryByHot(boolean hot);
}
