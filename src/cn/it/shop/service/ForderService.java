package cn.it.shop.service;

import java.math.BigDecimal;
import cn.it.shop.model.Forder;
import cn.it.shop.model.Sorder;

public interface ForderService extends BaseService<Forder> {
	// 根据购物项集合 计算购物车的总价格
	public BigDecimal culTotal(Forder forder);
	// 通过订单id更新订单状态
	public void updateStatusById(int id, int sid);

	public Forder updateSorder(Forder forder, Sorder sorder);
}
