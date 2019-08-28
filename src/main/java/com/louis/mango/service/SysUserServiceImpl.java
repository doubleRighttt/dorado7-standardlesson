package com.louis.mango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.mango.dao.SysUserMapper;
import com.louis.mango.model.SysUser;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public List<SysUser> findAll() {
		return sysUserMapper.findAll();
	}

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		
		return sysUserMapper.selectByPrimaryKey(id);
	}
	
	
}
