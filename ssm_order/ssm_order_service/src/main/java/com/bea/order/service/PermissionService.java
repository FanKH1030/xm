package com.bea.order.service;

import com.bea.order.model.Permission;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface PermissionService {
	
	List<Permission> findAll() throws Exception;
	
	void add(Permission permission) throws Exception;
}
