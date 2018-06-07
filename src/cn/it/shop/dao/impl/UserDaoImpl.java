package cn.it.shop.dao.impl;

import org.springframework.stereotype.Repository;
import cn.it.shop.dao.UserDao;
import cn.it.shop.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User login(User user) {
		String hql = "FROM User u WHERE u.login = :login AND u.pass = :pass";
		return (User) getSession().createQuery(hql)//
				.setString("login", user.getLogin())//
				.setString("pass", user.getPass())//
				.uniqueResult();
	}

}
