package com.bea.order.service;

import com.bea.order.model.Role;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface RoleService {
	
	List<Role> findAll() throws Exception;
	
	void add(Role role) throws Exception;
	
	Role findRoleByIdAndAllPermission(String id);
	
	void addPermissionToRole(String roleId, String[] permissionIds);
}
