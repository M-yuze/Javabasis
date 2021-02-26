package com.gzln.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzln.sys.entity.SysUser;

/**
 * 系统用户类的操作类，//对应LnUserMapper
 * 
 * @author JunOneWolf //必须字段
 * @time 2020/5/16 //必须字段
 * @version 1.0.0 //必须字段
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

	/**
	 * 通过电话查找用户	//电话字段未唯一，返回必然是多个用户，不然肯定处理出错//mapper.xml未处理。
	 * @param phoneNumber
	 * @return
	 */
	List<SysUser> findByPhone(@Param("phoneNumber") String phoneNumber);
	
	
}
