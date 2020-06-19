package com.bea.order.service.impl;

import com.bea.order.dao.SysLogDao;
import com.bea.order.model.SysLog;
import com.bea.order.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	
	@Override
	public void add(SysLog sysLog) {
		sysLogDao.add(sysLog);
	}
	
	@Override
	public List<SysLog> findAll() {
		return sysLogDao.findAll();
	}
}
