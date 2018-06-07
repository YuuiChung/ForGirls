package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Account;
import cn.it.shop.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements
		AccountService,UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {		
		return accountDao.loadUserByUsername(username);
	}

	@Override
	public Account login(Account account) {
		return accountDao.login(account);
	}

	@Override
	public List<Account> query(String name, int page, int rows) {
		return accountDao.query(name, page, rows);
	}

	@Override
	public Long count(String name) {
		return accountDao.count(name);
	}
	
	@Override
	public void deleteByIds(String ids){
		accountDao.deleteByIds(ids);
	}

	@Override
	public void updateHql(Account account) {
		accountDao.updateHql(account);
	}

	@Override
	public Account getJoinRole(int id) {
		return accountDao.getJoinRole(id);
	}
}
