package com.gzln.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzln.sys.entity.SysUser;

/**
 * 系统用户类的服务层，//对应LnUserMapper
 * 
 * @author JunOneWolf //必须字段
 * @time 2020/5/16 //必须字段
 * @version 1.0.0 //必须字段
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * 创建用户，注意，必要的参数必须有用户名
	 * 
	 * @param dataMap
	 * @throws RuntimeException 异常包括用户名必须唯一，或是插入失败
	 */
	void createUser(Map<String, String> dataMap) throws RuntimeException;

	/**
	 * 获取用户数据，注意必须数据脱敏，//超级管理员不使用这种数据获取方式
	 * 
	 * @param userId 用户id
	 * @return
	 * @throws RuntimeException 异常包括用户不存在，
	 */
	SysUser getUserInfoByUserId(String userId) throws RuntimeException;
}
