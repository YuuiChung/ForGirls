package cn.it.shop.dao;

import java.util.List;

import cn.it.shop.model.Privilege;

public interface PrivilegeDao extends BaseDao<Privilege> {
	// 返回权限的集合,支持树状结构显示
	public List<Privilege> queryForTree();
}
