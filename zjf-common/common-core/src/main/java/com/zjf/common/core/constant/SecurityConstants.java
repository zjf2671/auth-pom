package com.zjf.common.core.constant;

/**
 * @author Harry
 */
public interface SecurityConstants {
	/**
	 * 前缀
	 */
	String PROJECT_PREFIX = "zjf_";

	/**
	 * oauth 相关前缀
	 */
	String OAUTH_PREFIX = "oauth:";

	/**
	 * 角色前缀
	 */
	String ROLE = "role_";

	/***
	 * 资源服务器默认bean名称
	 */
	String RESOURCE_SERVER_CONFIGURER = "oauth2ResourceServerConfigurerAdapter";

	/**
	 * 用户ID字段
	 */
	String DETAILS_USER_ID = "user_id";

	/**
	 * 用户名字段
	 */
	String DETAILS_USERNAME = "username";

	/**
	 * 用户部门字段
	 */
	String DETAILS_DEPT_ID = "dept_id";

	/**
	 * 协议字段
	 */
	String DETAILS_LICENSE = "license";

	/**
	 * 项目的license
	 */
	String PROJECT_LICENSE = "made by zjf";

	/**
	 * jwt signing key
	 */
	String JWT_SIGNING_KEY = "harryKey";


}
