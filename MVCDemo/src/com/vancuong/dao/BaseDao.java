/**
 * Copyright(C) 2015 Media Brige Company
 * BaseDao.java
 */
package com.vancuong.dao;

/**
 * @author Cuong
 *
 */
public interface BaseDao {

	/**
	 * connectToDB
	 *
	 * @return true: connectToDB success false: connectToDB unsuccess
	 */
	public boolean connectToDB();

	/**
	 * closeConnect
	 */
	public void closeConnect();

}
