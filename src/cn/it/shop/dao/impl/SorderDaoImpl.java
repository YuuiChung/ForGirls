package cn.it.shop.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.model.Sorder;

@Repository("sorderDao")
@SuppressWarnings("unchecked")
public class SorderDaoImpl extends BaseDaoImpl<Sorder> implements SorderDao {

	@Override
	public List<Object> querySale(int number) {
		String hql = "SELECT s.name,sum(s.number) FROM Sorder s JOIN s.product GROUP BY s.product.id";
		return getSession().createQuery(hql)//
				.setFirstResult(0)//
				.setMaxResults(number)//
				.list();
	}

}
