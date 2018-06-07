package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Privilege;

public interface PrivilegeService extends BaseService<Privilege> {
	// 返回权限的集合,支持树状结构显示
	public List<Privilege> queryForTree();
}
