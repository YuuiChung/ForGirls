package cn.it.shop.util;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component("accessDecisionManager")
public class RoleAccessDecisionManager implements AccessDecisionManager {

	@Override  // 如果方法执行完毕没有抛出异常,则说明可以放行, 否则抛出异常 AccessDeniedException
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		System.out.println("---------------decide------------------");
		// 如果登陆成功,则信息会存储在Authorities中
		Collection<? extends GrantedAuthority> myRoles = authentication.getAuthorities();
		// 如果前面的 getAttributes() 返回非空,则返回的数据做为形参传入, 如果返回为null 则不会进入decide() 直接放行
		System.out.println("myRole:" + myRoles);
		System.out.println("sysRole:" + configAttributes);
		for(GrantedAuthority myRole:myRoles){
			for(ConfigAttribute urlRole:configAttributes){
				if(myRole.getAuthority().equals(urlRole.getAttribute())){
					// 说明此URL地址符合权限,可以放行
					return;
				}
			}
		}
		System.out.println("-----权限验证失败------");
		throw new AccessDeniedException("权限越界！");
	}

	@Override   // 判断参数是否为期望的参数
	public boolean supports(ConfigAttribute attribute) {
		System.out.println("public boolean supports(ConfigAttribute attribute)");
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("public boolean supports(Class<?> clazz)");
		return true;
	}

}
