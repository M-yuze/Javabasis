package com.gzln.sys.entity;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzln.common.core.entity.LnRole;
import com.gzln.common.core.entity.LnUser;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统用户类，类似于LnUser //上边出错，是因为这个不在这里定义。
 * 
 * @author JunOneWolf //必须字段
 * @time 2020/5/16 //必须字段
 * @version 1.0.0 //必须字段
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ln_User")
public class SysUser {

	private static final long serialVersionUID = 1L;
	/**
	 * id的最大长度
	 */
	public static final int ID_MAX_LENGTH = 32;
	/**
	 * 名称的最大长度
	 */
	public static final int NAME_MAX_LENGTH = 20;
	/**
	 * 邮件的最大长度
	 */
	public static final int EMAIL_MAX_LENGTH = 255;
	/**
	 * 用户年龄的最大长度
	 */
	public static final int AGE_MAX_LENGTH = 11;
	/**
	 * 用户id，长度32
	 */
	@TableId(value = "user_id", type = IdType.UUID)
	private String userId;
	/**
	 * 名称,长度20
	 */
	private String name;

	/**
	 * 邮件,长度255
	 */
	private String email;

	/**
	 * 用户年龄,长度11
	 */
	private Integer age;

	
	// TODO 待补充
}
