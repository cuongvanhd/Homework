/**
 * Copyright(C) 2015 Media Brige Company
 * UserLogicImpl.java
 */
package com.vancuong.logic.impl;

import java.util.List;

import com.vancuong.dao.impl.UserDaoImpl;
import com.vancuong.entities.User;
import com.vancuong.logic.UserLogic;

/**
 * Class UserLogicImpl implements UserLogic
 * 
 * @author Cuong
 *
 */
public class UserLogicImpl implements UserLogic {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vancuong.logic.UserLogic#listUser()
	 */
	@Override
	public List<User> listUser() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		return userDaoImpl.listUser();
	}

}
