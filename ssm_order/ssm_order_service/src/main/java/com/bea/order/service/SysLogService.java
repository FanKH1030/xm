package com.bea.order.service;

import com.bea.order.model.SysLog;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface SysLogService {
	
	void add(SysLog sysLog);
	
	List<SysLog> findAll();
}
