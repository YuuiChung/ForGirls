package cn.it.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.it.shop.dao.RoleDao;
import cn.it.shop.model.Role;

/**
 * 
 * @Title: CategoryServiceImpl.java
 * @Package cn.it.shop.service.impl
 * @Description: TODO(实现当前模块的自身业务逻辑)
 * @author 广州传智播客
 * @date 2014-7-8 上午11:43:40
 * @version V1.0
 */
@SuppressWarnings("unchecked")
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public List<Role> query(String name, int page, int rows) {
		String hql = "FROM Role r WHERE r.name LIKE :name";
		Session session = getSession();
		return session.createQuery(hql) //
				.setString("name", "%" + name + "%") //
				.setFirstResult((page - 1) * rows)//
				.setMaxResults(rows) //
				.list();
	}

	@Override
	public Long count(String name) {
		String hql = "SELECT COUNT(r) FROM Role r WHERE r.name LIKE :name";
		Session session = getSession();
		return (Long) session.createQuery(hql) //
				.setString("name", "%" + name + "%") //
				.uniqueResult();
	}
	
	@Override	// 采用HQL语言不支持级联删除(同查询一样,HQL是不支持 lazy的),采用 session.delete取代
	public void deleteByIds(String ids) {
		Session session = getSession();
		for(String id:ids.split(",")){
			session.delete(new Role(Integer.parseInt(id)));
		}
	}

	@Override
	public Role getJoinPrvilege(int id) {
		String hql = "FROM Role r LEFT JOIN FETCH r.privilegeSet WHERE r.id=:id";
		return (Role)getSession().createQuery(hql) //
		  .setInteger("id", id)
		  .uniqueResult();
	}
}
