package com.bea.order.dao;

import com.bea.order.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface PermissionDao {
	
	List<Permission> findByRoleId(String roleId) throws Exception;
	
	List<Permission> findAll();
	
	void add(Permission permission);
	
	List<Permission> findOtherPermissions(String roleId);
}
