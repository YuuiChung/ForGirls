package cn.it.shop.service;

import java.util.List;

import cn.it.shop.model.Account;

public interface AccountService extends BaseService<Account> {

	// 自身业务逻辑
	public Account login(Account account);

	public List<Account> query(String name, int page, int rows);

	public Long count(String name);
	
	public void deleteByIds(String ids);
	
	public void updateHql(Account account);
	
	public Account getJoinRole(int id);
}
