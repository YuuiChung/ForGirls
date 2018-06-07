package cn.it.shop.service.impl;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import cn.it.shop.model.Url;
import cn.it.shop.service.UrlService;

@Service("urlService")
public class UrlServiceImpl extends BaseServiceImpl<Url> implements UrlService,
		FilterInvocationSecurityMetadataSource {

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// 获取当前URL地址
		FilterInvocation invocation = (FilterInvocation) object;
		String url = invocation.getRequest().getServletPath();
		Url urlObject = urlDao.getRoleByUrl(url);
		if (urlObject != null) {
			return urlObject.getPrivilege().getRoleSet();
		} else {
			return null;
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void getAllRoles() {
		urlDao.getAllRoles();
	}

}
