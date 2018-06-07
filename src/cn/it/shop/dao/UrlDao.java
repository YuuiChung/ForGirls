package cn.it.shop.dao;

import cn.it.shop.model.Url;

public interface UrlDao extends BaseDao<Url> {

	public Url getRoleByUrl(String url);
	
	public void getAllRoles();
}
