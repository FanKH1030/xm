package com.bea.order.service.impl;

import com.bea.order.dao.PermissionDao;
import com.bea.order.dao.RoleDao;
import com.bea.order.model.Permission;
import com.bea.order.model.Role;
import com.bea.order.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Role> findAll() throws Exception {
		return roleDao.findAll();
	}
	
	@Override
	public void add(Role role) throws Exception {
		roleDao.add(role);
	}
	
	@Override
	public Role findRoleByIdAndAllPermission(String id) {
		Role rusultRole = roleDao.findById(id);
		List<Permission> permissionList = permissionDao.findOtherPermissions(id);
		rusultRole.setPermissions(permissionList);
		return rusultRole;
	}
	
	@Override
	public void addPermissionToRole(String roleId, String[] permissionIds) {
		for (String permissionId : permissionIds) {
			roleDao.addPermissionToRole(roleId, permissionId);
		}
	}
	
}
