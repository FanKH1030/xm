package com.bea.order.dao;

import com.bea.order.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface RoleDao {
	
	List<Role> findByUsersId(String usersId) throws Exception;
	
	List<Role> findAll() throws Exception;
	
	void add(Role role) throws Exception;
	
	List<Role> findOtherRoles(String usersId) throws Exception;
	
	Role findById(String id);
	
	void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
