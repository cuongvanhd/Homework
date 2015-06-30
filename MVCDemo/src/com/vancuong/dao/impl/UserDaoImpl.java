/**
 * Copyright(C) 2015 Media Brige Company
 * UserDaoImpl.java
 */
package com.vancuong.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.vancuong.dao.UserDao;
import com.vancuong.entities.User;

/**
 * @author Cuong
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vancuong.dao.UserDao#listUser()
	 */
	@Override
	public List<User> listUser() {

		List<User> lsUser = new ArrayList<User>();

		if (connectToDB()) {
			try {

				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT * FROM");
				sqlCommand.append(" ADMIN");

				preparedStatement = connection.prepareStatement(sqlCommand.toString());

				rs = preparedStatement.executeQuery();

				if (rs != null) {
					while (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						user.setName(rs.getString("name"));

						// add list
						lsUser.add(user);
					}
				}

			} catch (Exception e) {
				System.out.println("UserDaoImpl:List user error: " + e.getMessage());
			}
			closeConnect();
		}

		return lsUser;
	}
}
