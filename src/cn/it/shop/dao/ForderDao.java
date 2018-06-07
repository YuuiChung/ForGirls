package cn.it.shop.dao;

import cn.it.shop.model.Forder;

public interface ForderDao extends BaseDao<Forder> {

	public void updateStatusById(int id, int sid);

}
