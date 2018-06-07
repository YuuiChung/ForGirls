package cn.it.shop.action;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.it.shop.model.Account;
import cn.it.shop.model.PageModel;
import cn.it.shop.model.Role;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {

	private Integer[] rids;

	public Integer[] getRids() {
		return rids;
	}

	public void setRids(Integer[] rids) {
		this.rids = rids;
	}
	
	public void save() {
		accountService.save(model);
	}
	
	public String query() {
		jsonList = accountService.query();

		return "jsonList";

	}
	
	public void updateHql() {
		System.out.println(model);
		accountService.updateHql(model);
	}

	public void grantRole() {
		// 通过id获取管理员信息
		System.out.println(model);
		model = accountService.getId(model.getId());
		Set<Role> roleSet = null;
		if (rids != null) {
			roleSet = new HashSet<Role>();
			for (int rid : rids) {
				roleSet.add(new Role(rid));
			}
		}
		// 当管理员没有选择角色时候 角色集合为null
		model.setRoleSet(roleSet);
		// 通过更新管理员的方式,级联更新拥有的角色集合
		accountService.update(model);
	}

	public void deleteByIds() {
		accountService.deleteByIds(ids);
	}

	public String queryForPage() {
		pageModel = new PageModel<Account>();
		pageModel.setRows(accountService.query(model.getLogin(), page, rows));
		pageModel.setTotal(accountService.count(model.getLogin()));
		return "pageModel";
	}

	public String getAccount() {
		System.out.println(model.getId());
		// 查询管理员,并且级联查询角色集合
		model = accountService.getJoinRole(model.getId());
		// 根据roleSet获取 所有role.id
		request.put("myRids", roleService.getRoleId(model.getRoleSet()));
		// 查询所有角色信息,并且存储reques域
		request.put("roleList", roleService.query());
		return "grantRole";
	}
}
