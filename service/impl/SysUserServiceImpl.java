package com.gzln.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzln.sys.entity.SysUser;
import com.gzln.sys.mapper.SysUserMapper;
import com.gzln.sys.service.SysUserService;

/**
 * 系统用户类的服务层，//对应LnUserMapper
 * 
 * @author JunOneWolf //必须字段
 * @time 2020/5/16 //必须字段
 * @version 1.0.0 //必须字段
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String AGE = "age";

	/**
	 * 这些错误类型可以抽出来
	 */
	private static final String IS_NULL = "为空";
	private static final String OUT_OF_LENGTH = "的长度不允许超过";
	private static final String ERROR_OF_TYPE = "数据类型出错";
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public void createUser(Map<String, String> dataMap) throws RuntimeException {

		// 必须要参数校验
		checkNullAndOutSize(dataMap, ID, true, SysUser.ID_MAX_LENGTH);
		checkNullAndOutSize(dataMap, NAME, true, SysUser.NAME_MAX_LENGTH);

		// 非必要参数校验
		checkNullAndOutSize(dataMap, EMAIL, false, SysUser.EMAIL_MAX_LENGTH);
		checkNullAndOutSize(dataMap, AGE, false, SysUser.AGE_MAX_LENGTH);

		SysUser user = new SysUser();
		user.setUserId(dataMap.get(ID));
		user.setName(dataMap.get(NAME));
		user.setEmail(dataMap.get(EMAIL));
		Object ageObj = dataMap.get(AGE);
		if (ageObj instanceof Integer) {
			user.setAge((Integer) ageObj);
		} else {
			throw new RuntimeException(AGE + ERROR_OF_TYPE);
		}
		sysUserMapper.insert(user);
	}

	private static void checkNullAndOutSize(Map<String, String> dataMap, String dataName, boolean isMust, int length)
			throws RuntimeException {
		String value = dataMap.get(dataName);
		if (StringUtils.isEmpty(value)) {
			if (isMust) {
				throw new RuntimeException(dataName + IS_NULL);
			}
			return;
		}
		if (value.length() > length) {
			throw new RuntimeException(dataName + OUT_OF_LENGTH + length);
		}
	}

	@Override
	public SysUser getUserInfoByUserId(String userId) throws RuntimeException {
		SysUser user = sysUserMapper.selectById(userId);
		if (user == null) {
			return null;
		}
		String email = user.getEmail();
		// 数据脱敏，包括手机号，详细地址，邮箱地址，可参考abcdf@qq.com替换为abc**@**.com
		email = changeEmail(email);
		// TODO 自定义的邮箱脱敏
		user.setEmail(email);
		return user;
	}

	/**
	 * 邮箱脱敏的例子，可借鉴
	 */
	public static String changeEmail(String email) {
		// TODO 注意，这里一段代码不可以直接使用，还需要数据处理，代码优化
		email = "abcdf@qq.com";

		int befortIndex = email.indexOf("@");
		if (email.endsWith("#") || befortIndex <= 0) {
			// 不合理的邮箱地址，不可能@开头或结尾,return
		}
		String befortStr = email.substring(0, email.indexOf("@"));
		if (befortStr.length() < 4) {
			befortStr = "****";
		} else {
			befortStr = befortStr.substring(0, befortStr.length() / 2) + "****";
		}
		// 因为不会@结尾，所以不会越界异常
		String lastStr = email.substring(befortIndex + 1);
		if (lastStr.length() < 4) {
			lastStr = "****";
		} else {
			lastStr = "****" + lastStr.substring(lastStr.indexOf("."));
		}

		email = befortStr + "@" + lastStr;
		System.out.println(email);
		return email;
	}
}
