package com.bea.order.dao;

import com.bea.order.model.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface UsersDao {
	
	Users findByUsername(String username) throws Exception;
	
	List<Users> findAll() throws Exception;
	
	void add(Users users) throws Exception;
	
	Users findById(String id);
	
	void addUsersRole(@Param("userId") String userId, @Param("roleId") String roleId);
}
