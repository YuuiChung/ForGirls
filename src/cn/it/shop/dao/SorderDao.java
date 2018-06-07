package cn.it.shop.dao;

import java.util.List;
import cn.it.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {

	public List<Object> querySale(int number);
}
