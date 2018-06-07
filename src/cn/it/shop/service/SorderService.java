package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Forder;
import cn.it.shop.model.Product;
import cn.it.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {

	public Forder addSorder(Forder forder, Product product);

	public Sorder productToSorder(Product product);

	public List<Object> querySale(int number);
}
