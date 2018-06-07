package cn.it.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.it.shop.model.Privilege;
import cn.it.shop.service.PrivilegeService;

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements
		PrivilegeService {

	@Override
	public List<Privilege> queryForTree() {
		return privilegeDao.queryForTree();
	}

}
