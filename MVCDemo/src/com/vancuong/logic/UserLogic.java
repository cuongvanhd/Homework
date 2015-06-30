/**
 * Copyright(C) 2015 Media Brige Company
 * UserLogic.java
 */
package com.vancuong.logic;

import java.util.List;

import com.vancuong.entities.User;

/**
 * Class UserLogic store basic method user
 * 
 * @author Cuong
 *
 */
public interface UserLogic {

	/**
	 * Method using to get all list user from database
	 * 
	 * @return list user
	 */
	public List<User> listUser();
}
