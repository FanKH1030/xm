package com.bea.order.service.impl;

import com.bea.order.dao.RoleDao;
import com.bea.order.dao.UsersDao;
import com.bea.order.model.Role;
import com.bea.order.model.Users;
import com.bea.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		try {
			Users users = usersDao.findByUsername(username);
			System.out.println(users);
			// 处理自己得用户Users对象，封装成UserDetails
//            userDetails = new User(users.getUsername(), "{noop}" + users.getPassword(), getAuthority(users.getRoles()));
			userDetails = new User(users.getUsername(), users.getPassword(), users.getStatus() == 1, true, true, true, getAuthority(users.getRoles()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userDetails;
	}
	
	private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		for (Role role : roles) {
			SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
			list.add(grantedAuthority);
		}
		
		return list;
	}
	
	@Override
	public List<Users> findAll() throws Exception {
		return usersDao.findAll();
	}
	
	@Override
	public void add(Users users) throws Exception {
		String encodePassword = bCryptPasswordEncoder.encode(users.getPassword());
		users.setPassword(encodePassword);
		usersDao.add(users);
	}
	
	@Override
	public Users findById(String id) throws Exception {
		return usersDao.findById(id);
	}
	
	@Override
	public Users findUserByIdAndAllRole(String id) throws Exception {
		Users rusultUser = usersDao.findById(id);
		List<Role> roleList = roleDao.findOtherRoles(id);
		rusultUser.setRoles(roleList);
		return rusultUser;
	}
	
	@Override
	public void addRoleToUser(String userId, String[] roleIds) throws Exception {
		for (String roleId : roleIds) {
			usersDao.addUsersRole(userId, roleId);
		}
	}
}
