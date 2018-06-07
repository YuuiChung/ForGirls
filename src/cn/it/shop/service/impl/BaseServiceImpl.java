package cn.it.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import cn.it.shop.dao.AccountDao;
import cn.it.shop.dao.BaseDao;
import cn.it.shop.dao.CategoryDao;
import cn.it.shop.dao.ForderDao;
import cn.it.shop.dao.PrivilegeDao;
import cn.it.shop.dao.ProductDao;
import cn.it.shop.dao.RoleDao;
import cn.it.shop.dao.SorderDao;
import cn.it.shop.dao.UrlDao;
import cn.it.shop.dao.UserDao;
import cn.it.shop.service.BaseService;

@Service("baseService")
@SuppressWarnings("unchecked")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

	private Class clazz;
	protected BaseDao baseDao;
	@Resource
	protected AccountDao accountDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected ForderDao forderDao;
	@Resource
	protected ProductDao productDao;
	@Resource
	protected SorderDao sorderDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected RoleDao roleDao;
	@Resource
	protected PrivilegeDao privilegeDao;
	@Resource
	protected UrlDao urlDao;

	public BaseServiceImpl() {
		// 如果子类调用当前构造方法,this代表的是子类对象
		System.out.println("this代表的是当前调用构造方法的对象：" + this);
		System.out
				.println("获取当前this对象的父类信息：" + this.getClass().getSuperclass());
		System.out.println("获取当前this的对象信息（包括泛型信息）:"
				+ this.getClass().getGenericSuperclass());
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
		// 此处 dao还有没有实例化, 不能实现给baseDao的赋值操作
//		System.out.println("baseDao:" + baseDao);
//		System.out.println("categoryDao:" + categoryDao);
	}

	@PostConstruct   // init方法是在构造方法与set注入之后执行, 也就是XML的: init-method=""
	public void init() {
		// 1: 根据具体的泛型, 获取相应的Field字段, categoryDao
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase()
				+ clazzName.substring(1) + "Dao";
		try {
			Field clazzField = this.getClass().getSuperclass()
					.getDeclaredField(clazzDao);
			// 2: 获取baseDao Filed字段
			Field baseField = this.getClass().getSuperclass()
					.getDeclaredField("baseDao");
			// 3: 把categoryDao的值赋值给baseDao
			baseField.set(this, clazzField.get(this));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("baseDao:" + baseDao);
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
		baseDao.delete(id);
	}

	@Override
	public T getId(int id) {
		return (T) baseDao.getId(id);
	}

	@Override
	public List<T> query() {
		return baseDao.query();
	}

}
