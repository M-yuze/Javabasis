package com.gzln.sys.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.druid.util.StringUtils;
import com.gzln.sys.entity.SysUser;
import com.gzln.sys.service.SysUserService;

/**
 * 系统用户类的控制层，必须要处理异常和版本跳转的业务，//对应UserControl
 * 
 * @author JunOneWolf //必须字段
 * @time 2020/5/16 //必须字段
 * @version 1.0.0 //必须字段
 */
@Controller
public class UserControl {
	/**
	 * 是否超级管理
	 */
	private static final String IS_MANAGE = "IS_MANAGE";

	private static final String TRUE = "true";
	private static final String SUCCESS = "SUCCESS";
	/**
	 * 所有的注入对象，都要用private使用，最小化作用域原则
	 */
	@Autowired
	private SysUserService sysUserService;

	/**
	 * 所有的开放接口必须要有额外的参数，允许空，不然不向下兼容，不稳定(所有的大厂都是这么设置的，华为，阿里)。
	 * 
	 * @param userId
	 * @param extra
	 * @return
	 */
	@GetMapping
	public SysUser getUserById(String userId, Map<String, Object> extra) {
		if (extra != null) {
			Object isManage = extra.get(IS_MANAGE);
			if (isManage instanceof String) {
				String isManageStr = (String) isManage;
				if (!StringUtils.isEmpty(isManageStr) && isManageStr.equalsIgnoreCase(TRUE)) {
					// TODO 检测用户权限是否管理，调用service的另一个获取用户数据(有过敏数据)
				}
			}
		}
		try {
			// 异常一定要处理，不能给用户看，
			SysUser user = sysUserService.getUserInfoByUserId(userId);
			return null;
		} catch (RuntimeException e) {
			// 细化的返回用户不存在，或是用户
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping
	public String createUser(String username, Map<String, Object> extra) {

		return SUCCESS;
	}
}
