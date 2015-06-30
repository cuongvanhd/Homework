/**
 * Copyright(C) 2015 Media Brige Company
 * UserDao.java
 */
package com.vancuong.dao;

import java.util.List;

import com.vancuong.entities.User;

/**
 * @author Cuong
 *
 */
public interface UserDao extends BaseDao {

	/**
	 * Method using to get all list user from database
	 * 
	 * @return list user
	 */
	public List<User> listUser();
}
