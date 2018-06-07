package cn.it.shop.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.model.Product;

@Repository("productDao")
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "FROM Product p LEFT JOIN FETCH p.category WHERE p.name LIKE :name";
		return getSession().createQuery(hql)//
				.setString("name", "%" + name + "%")//
				.setFirstResult((page - 1) * size)//
				.setMaxResults(size)//
				.list();
	}

	@Override
	public Long getCount(String name) {
		String hql = "SELECT count(p) FROM Product p  WHERE p.name LIKE :name";
		return (Long) getSession().createQuery(hql)//
				.setString("name", "%" + name + "%")//
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql = "DELETE Product WHERE id in (" + ids + ")";
		getSession().createQuery(hql)//
				.executeUpdate();
	}

	@Override
	public List<Product> queryByCid(int cid) {
		String hql = "FROM Product p LEFT JOIN FETCH p.category WHERE p.commend = true AND p.open=true AND p.category.id=:cid ORDER BY p.date DESC";
		return getSession().createQuery(hql).setInteger("cid", cid)//
				.setFirstResult(0)//
				.setMaxResults(4)//
				.list();
	}

}
