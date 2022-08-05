package com.centris.campus.util;

public class SQLUtilConstants {

	public static final String VALIDATE_LOGIN_USER = "SELECT COUNT(*) FROM `user` WHERE `username`=? AND `password`=?";
	
}
