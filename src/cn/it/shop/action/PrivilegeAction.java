package cn.it.shop.action;

import cn.it.shop.model.Privilege;
import cn.it.shop.model.Role;

public class PrivilegeAction extends BaseAction<Privilege> {
	
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String queryForTree(){
		System.out.println(role.getId());
		// 查询当前用户的权限信息
		role=roleService.getJoinPrvilege(role.getId());
		System.out.println(role.getPrivilegeSet().size());
		// 所有的权限集合信息
		jsonList=privilegeService.queryForTree();
		// 实现权限信息的回显
		for(Privilege myPrivilege:role.getPrivilegeSet()){
			// 采用自己的权限信息与 系统缺省的权限信息比较,如果成功则系统当前权限被选中
			for(Privilege parent:jsonList){
				boolean isOk=false;
				// 获取当前父菜单的子菜单, 只需要与tree的子菜单比较即可
				for(Privilege children:parent.getChildren()){
					if(myPrivilege.getId().equals(children.getId())){
						children.setChecked(true);
						isOk=true;  // 为了判断第二个for循环的标记
						break;
					}
				}
				if(isOk==true){
					break;
				}
			}
		}
		
		return "jsonList";
	}
}
