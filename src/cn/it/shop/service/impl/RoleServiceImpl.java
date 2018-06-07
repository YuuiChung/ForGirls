package cn.it.shop.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Role;
import cn.it.shop.service.RoleService;

/**
 * 
 * @Title: CategoryServiceImpl.java
 * @Package cn.it.shop.service.impl
 * @Description: TODO(实现当前模块的自身业务逻辑)
 * @author 广州传智播客
 * @date 2014-7-8 上午11:43:40
 * @version V1.0
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements
		RoleService {
	
	@Override
	public List<Role> query(String name, int page, int rows) {
		return roleDao.query(name, page, rows);
	}

	@Override
	public Long count(String name) {
		return roleDao.count(name);
	}
	
	@Override
	public void deleteByIds(String ids){
		roleDao.deleteByIds(ids);
	}

	@Override
	public Role getJoinPrvilege(int id) {
		// TODO Auto-generated method stub
		return roleDao.getJoinPrvilege(id);
	}
	
	@Override
	public int[] getRoleId(Set<Role> roleSet) {
		int[] ids=new int[roleSet.size()];
		int num=0;
		for(Role role:roleSet){
			ids[num++]=role.getId();
		}
		return ids;
	}
}
