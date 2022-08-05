package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.centris.campus.dao.LoginDao;
import com.centris.campus.util.SQLUtilConstants;

public class LoginDaoImpl implements LoginDao{
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	public String validateLoginUser(String username, String password) {
		logger.info("Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String status="failure";
		try {
			int count=0;
			conn=JDBCConnection.getConnection();
			pstmt = conn.prepareStatement(SQLUtilConstants.VALIDATE_LOGIN_USER);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count > 0) {
				status = "success";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally {
			try {
				if (rs != null && (!rs.isClosed())) {
					rs.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}

		logger.info("Ending");
		return status;
	}
	

}
