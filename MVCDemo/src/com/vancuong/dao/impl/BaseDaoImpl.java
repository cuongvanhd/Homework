/**
 * Copyright(C) 2015 Media Brige Company
 * BaseDaoImpl.java
 */
package com.vancuong.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.vancuong.dao.BaseDao;
import com.vancuong.utils.DatabaseProperties;

/**
 * @author Cuong
 *
 */
public class BaseDaoImpl implements BaseDao {

	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet rs = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vancuong.dao.BaseDao#connectToDB()
	 */
	@Override
	public boolean connectToDB() {
		boolean result = true;
		try {
			if (connection == null) {
				// load mysql driver
				Class.forName(DatabaseProperties.getData("driver"));
				connection = DriverManager.getConnection(DatabaseProperties.getData("url"), DatabaseProperties.getData("user"),
						DatabaseProperties.getData("password"));
			}
		} catch (Exception e) {
			System.out.println("an exception occur baseDaoImpl:connectDB: " + e.getMessage());
			result = false;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vancuong.dao.BaseDao#closeConnect()
	 */
	@Override
	public void closeConnect() {
		if (connection != null) {
			try {
				if (connection.getAutoCommit()) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}

		}

	}

}
