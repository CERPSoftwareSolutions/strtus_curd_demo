package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.centris.campus.dao.StudentDao;
import com.centris.campus.forms.StudentForm;
import com.centris.campus.pojo.StudentPojo;
import com.centris.campus.util.HelperClass;
import com.centris.campus.util.StudentSQLUtilConstants;

public class StudentDaoImpl implements StudentDao{
	private static final Logger logger = Logger.getLogger(StudentDaoImpl.class);
	
	public String saveStudent(StudentForm sform) {
		logger.info("Starting");
		String status = null;
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			int count = 0;
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			if (sform.getStudentid().trim().equalsIgnoreCase("")) {
				pstmt = conn.prepareStatement(StudentSQLUtilConstants.INSERT_STUDENT);
				pstmt.setString(1, sform.getAdmissionno());
				pstmt.setString(2, HelperClass.convertUIToDatabase(sform.getAdmissiondate()));
				pstmt.setString(3, sform.getFirstname());
				pstmt.setString(4, sform.getLastname());
				pstmt.setString(5, sform.getGender());
				pstmt.setString(6, HelperClass.convertUIToDatabase(sform.getDob()));
				pstmt.setString(7, sform.getBloodgroup());
				pstmt.setString(8, sform.getStudentmobileno());
				pstmt.setString(9, sform.getStudentemailid());
				pstmt.setString(10, sform.getFathername());
				pstmt.setString(11, sform.getFathermobileno());
				pstmt.setString(12, sform.getMothername());
				pstmt.setString(13, sform.getMothermobileno());
				pstmt.setString(14, sform.getGuardianname());
				pstmt.setString(15, sform.getGuardianmobileno());
				pstmt.setString(16, sform.getPrimaryperson());
				pstmt.setString(17, sform.getPermanentaddress());
				pstmt.setString(18, sform.getPresentaddress());
				count = pstmt.executeUpdate();
				if (count > 0) {
					status = "save";
					conn.commit();
				} else {
					status = "failure";
					conn.rollback();
				}
			} else {
				pstmt = conn.prepareStatement(StudentSQLUtilConstants.UPDATE_STUDENT);
				pstmt.setString(1, sform.getAdmissionno());
				pstmt.setString(2, HelperClass.convertUIToDatabase(sform.getAdmissiondate()));
				pstmt.setString(3, sform.getFirstname());
				pstmt.setString(4, sform.getLastname());
				pstmt.setString(5, sform.getGender());
				pstmt.setString(6, HelperClass.convertUIToDatabase(sform.getDob()));
				pstmt.setString(7, sform.getBloodgroup());
				pstmt.setString(8, sform.getStudentmobileno());
				pstmt.setString(9, sform.getStudentemailid());
				pstmt.setString(10, sform.getFathername());
				pstmt.setString(11, sform.getFathermobileno());
				pstmt.setString(12, sform.getMothername());
				pstmt.setString(13, sform.getMothermobileno());
				pstmt.setString(14, sform.getGuardianname());
				pstmt.setString(15, sform.getGuardianmobileno());
				pstmt.setString(16, sform.getPrimaryperson());
				pstmt.setString(17, sform.getPermanentaddress());
				pstmt.setString(18, sform.getPresentaddress());
				pstmt.setDate(19, HelperClass.getCurrentSqlDate());
				pstmt.setString(20, sform.getStudentid());
				count = pstmt.executeUpdate();
				if (count > 0) {
					status = "update";
					conn.commit();
				} else {
					status = "failure";
					conn.rollback();
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.info("Ending");
		return status;
	}

	public List<StudentPojo> getStudentRegistrationList() {
		logger.info("Starting");
		List<StudentPojo> list=new ArrayList<StudentPojo>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = JDBCConnection.getConnection();
			pstmt = conn.prepareStatement(StudentSQLUtilConstants.STUDENT_REGISTRATION_LIST);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				StudentPojo obj=new StudentPojo();
				obj.setAdmissionno(rs.getString("admissionno"));
				obj.setAdmissiondate(HelperClass.convertDatabaseToUI(rs.getString("admissiondate")));
				obj.setFirstname(rs.getString("firstname")+" "+rs.getString("lastname"));
				obj.setGender(rs.getString("gender"));
				obj.setDob(HelperClass.convertDatabaseToUI(rs.getString("dob")));
				obj.setBloodgroup(rs.getString("bloodgroup"));
				obj.setStudentmobileno(rs.getString("studentmobileno"));
				obj.setStudentemailid(rs.getString("studentemailid"));
				obj.setFathername(rs.getString("fathername"));
				obj.setFathermobileno(rs.getString("fathermobileno"));
				obj.setMothername(rs.getString("mothername"));
				obj.setMothermobileno(rs.getString("mothermobileno"));
				obj.setGuardianname(rs.getString("guardianname"));
				obj.setGuardianmobileno(rs.getString("guardianmobileno"));
				obj.setPrimaryperson(rs.getString("primaryperson"));
				obj.setPermanentaddress(rs.getString("permanentaddress"));
				obj.setPresentaddress(rs.getString("presentaddress"));
				obj.setStudentid(rs.getString("id"));
				list.add(obj);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.info("Ending");
		return list;
	}

	public StudentPojo editStudent(String studentId) {
		logger.info("Starting");
		StudentPojo obj=new StudentPojo();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = JDBCConnection.getConnection();
			pstmt = conn.prepareStatement(StudentSQLUtilConstants.EDIT_STUDENT_REGISTRATION);
			pstmt.setString(1, studentId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				obj.setAdmissionno(rs.getString("admissionno"));
				obj.setAdmissiondate(HelperClass.convertDatabaseToUI(rs.getString("admissiondate")));
				obj.setFirstname(rs.getString("firstname"));
				obj.setLastname(rs.getString("lastname"));
				obj.setGender(rs.getString("gender"));
				obj.setDob(HelperClass.convertDatabaseToUI(rs.getString("dob")));
				obj.setBloodgroup(rs.getString("bloodgroup"));
				obj.setStudentmobileno(rs.getString("studentmobileno"));
				obj.setStudentemailid(rs.getString("studentemailid"));
				obj.setFathername(rs.getString("fathername"));
				obj.setFathermobileno(rs.getString("fathermobileno"));
				obj.setMothername(rs.getString("mothername"));
				obj.setMothermobileno(rs.getString("mothermobileno"));
				obj.setGuardianname(rs.getString("guardianname"));
				obj.setGuardianmobileno(rs.getString("guardianmobileno"));
				obj.setPrimaryperson(rs.getString("primaryperson"));
				obj.setPermanentaddress(rs.getString("permanentaddress"));
				obj.setPresentaddress(rs.getString("presentaddress"));
				obj.setStudentid(rs.getString("id"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.info("Ending");
		return obj;
	}

	public String deleteStudent(String studentId, String remarks) {
		logger.info("Starting");
		String status = "failure";
		Connection conn = null;
		PreparedStatement pstmt=null;
		try {
			int count = 0;
			conn = JDBCConnection.getConnection();
			pstmt=conn.prepareStatement(StudentSQLUtilConstants.DELETE_STUDENT_REGISTRATION);
			pstmt.setString(1, remarks);
			pstmt.setString(2, studentId);
			count=pstmt.executeUpdate();
			if(count > 0) {
				status="success";
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.info("Ending");
		return status;
	}

}
