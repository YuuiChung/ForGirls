package cn.it.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import cn.it.shop.dao.UrlDao;
import cn.it.shop.model.Url;

/**
 * 
 * @Title: UrlDaoImpl.java
 * @Package cn.security.dao.impl
 * @Description: TODO(通过URL地址获取相应权限然后在获取相应的角色集合)
 * @author 广州传智播客
 * @date 2014-7-23 上午9:45:38T
 * @version V1.0
 */
@Repository("urlDao")
public class UrlDaoImpl extends BaseDaoImpl<Url> implements UrlDao{
	
	private Map<String, Url> urlMap=new HashMap<String, Url>();
	
	@PostConstruct  // 获取所有的 url地址 与 URL对象 的映射关键
	public void getAllRoles(){
		Session session = sessionFactory.openSession();
		 String hql="FROM Url u JOIN FETCH u.privilege up JOIN FETCH up.roleSet";
		List<Url> urlLists=(List)session.createQuery(hql).list();
		for(Url o:urlLists){
			System.out.println("所属地址为:" + o.getUrl() + ", 对应的角色集合为:" + o.getPrivilege().getRoleSet());
			urlMap.put(o.getUrl(),o);
		}
		session.close();
	}

	// 通过URL地址获取相应权限然后在获取相应的角色集合
	public Url getRoleByUrl(String url){
		return urlMap.get(url);
	}
}
