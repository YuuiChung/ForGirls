package cn.it.shop.service;

import java.util.List;
import java.util.Set;

import cn.it.shop.model.Role;

/**
 * 
 * @Title: CategoryService.java
 * @Package cn.it.shop.service
 * @Description: TODO(角色的业务逻辑)
 * @author http://www.itcast.cn/ 传智播客
 * @date 2014-7-7 下午2:32:40
 * @version V1.0
 */
public interface RoleService extends BaseService<Role> {
	
	public List<Role> query(String name, int page, int rows);
	
	public Long count(String name);
	
	public void deleteByIds(String ids);
	
	public Role getJoinPrvilege(int id);
	
	public int[] getRoleId(Set<Role> roleSet);
}
