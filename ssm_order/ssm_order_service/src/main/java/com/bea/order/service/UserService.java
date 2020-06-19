package com.bea.order.service;

import com.bea.order.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface UserService extends UserDetailsService {
	
	List<Users> findAll() throws Exception;
	
	void add(Users users) throws Exception;
	
	Users findById(String id) throws Exception;
	
	Users findUserByIdAndAllRole(String id) throws Exception;
	
	void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
