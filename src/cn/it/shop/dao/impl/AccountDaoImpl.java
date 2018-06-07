package cn.it.shop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import cn.it.shop.dao.AccountDao;
import cn.it.shop.model.Account;

@Repository("accountDao")
@SuppressWarnings("unchecked")
public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	@Override
	public Account login(Account account) {
		String hql = "FROM Account a WHERE a.login=:login AND a.pass=:pass";
		return (Account) getSession().createQuery(hql) //
				.setString("login", account.getLogin()) //
				.setString("pass", account.getPass()) //
				.uniqueResult();
	}

	@Override
	public List<Account> query(String login, int page, int rows) {
		String hql = "FROM Account a WHERE a.login LIKE :login AND a.system=false";
		Session session = getSession();
		return session.createQuery(hql) //
				.setString("login", "%" + login + "%") //
				.setFirstResult((page - 1) * rows)//
				.setMaxResults(rows) //
				.list();
	}

	@Override
	public Long count(String login) {
		String hql = "SELECT COUNT(a) FROM Account a WHERE a.login LIKE :login AND a.system=false";
		Session session = getSession();
		return (Long) session.createQuery(hql) //
				.setString("login", "%" + login + "%") //
				.uniqueResult();
	}

	@Override
	// 采用HQL语言不支持级联删除(同查询一样,HQL是不支持 lazy的),采用 session.delete取代
	public void deleteByIds(String ids) {
		System.out.println("ids:" + ids);
		for (String id : ids.split(",")) {
			getSession().delete(new Account(Integer.parseInt(id)));
		}
	}

	@Override
	public void updateHql(Account account) {
		String hql = "update Account a SET a.name=:name, a.login=:login WHERE a.id=:id";
		getSession().createQuery(hql).setString("name", account.getName()) //
				.setString("login", account.getLogin()) //
				.setInteger("id", account.getId()) //
				.executeUpdate();
	}

	@Override
	public Account getJoinRole(int id) {
		String hql = "FROM Account a LEFT JOIN FETCH a.roleSet WHERE a.id=:id";
		Session session = getSession();
		return (Account) session.createQuery(hql).setInteger("id", id)
				.uniqueResult();
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return (Account)getSession().createQuery("FROM Account a LEFT JOIN FETCH a.roleSet WHERE a.login=:username")
		   .setString("username", username)
		   .uniqueResult();
	}
}
