package com.data.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FileName: BaseDaoImpl
 *
 * @author gcg
 **/
public class BaseDaoImpl<T> extends SqlSessionDaoSupport {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 拼接查询字符串
	 * @param name 对应id
	 * @return 查询字符串
	 */
	String getSqlName(String name) {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getName());
		sb.append(".");
		sb.append(name);
		return sb.toString();
	}

}