package cn.it.shop.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import cn.it.shop.dao.BaseDao;
@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	private Class clazz;
	@Resource
	protected SessionFactory sessionFactory;

	public BaseDaoImpl() {
		System.out.println("this代表的是当前调用构造方法的对象：" + this);
		System.out
				.println("获取当前this对象的父类信息：" + this.getClass().getSuperclass());
		System.out.println("获取当前this的对象信息（包括泛型信息）:"
				+ this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		String hql = "DELETE  " + clazz.getSimpleName() + "  WHERE id = :id";
		getSession().createQuery(hql).setInteger("id", id).executeUpdate();
	}

	@Override
	public T getId(int id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public List<T> query() {
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

}
