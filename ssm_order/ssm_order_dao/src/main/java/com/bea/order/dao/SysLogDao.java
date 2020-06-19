package com.bea.order.dao;

import com.bea.order.model.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface SysLogDao {
	
	void add(SysLog sysLog);
	
	List<SysLog> findAll();
}
