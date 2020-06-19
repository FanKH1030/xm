package com.bea.order.service.impl;

import com.bea.order.dao.PermissionDao;
import com.bea.order.model.Permission;
import com.bea.order.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	public List<Permission> findAll() throws Exception {
		return permissionDao.findAll();
	}
	
	@Override
	public void add(Permission permission) throws Exception {
		permissionDao.add(permission);
	}
	
}
