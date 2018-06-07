package cn.it.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.it.shop.dao.PrivilegeDao;
import cn.it.shop.model.Privilege;

@SuppressWarnings("unchecked")
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

	@Override
	public List<Privilege> queryForTree() {
		// 1: 查询所有父菜单
		String hql="FROM Privilege p WHERE p.parent IS NULL";
		// 2: 查询某个父菜单和它相应子菜单, 在一对多的查询中, 一般会有重复项,则DISTINCT 去除掉
		hql="SELECT DISTINCT p FROM Privilege p LEFT JOIN FETCH p.children WHERE p.id=1";
		// 3: 查询父菜单和它相应的子菜单
		hql="SELECT DISTINCT p FROM Privilege p LEFT JOIN FETCH p.children WHERE p.parent IS NULL";
		return getSession().createQuery(hql).list();
	}
}
