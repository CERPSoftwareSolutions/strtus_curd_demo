package com.centris.campus.util;

public class StudentSQLUtilConstants {

	public static final String INSERT_STUDENT = "INSERT INTO `student` (`admissionno`,`admissiondate`,`firstname`,`lastname`,`gender`,`dob`,`bloodgroup`,`studentmobileno`,`studentemailid`,`fathername`,`fathermobileno`,`mothername`,`mothermobileno`,`guardianname`,`guardianmobileno`,`primaryperson`,`permanentaddress`,`presentaddress`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_STUDENT = "UPDATE `student` SET `admissionno`=?,`admissiondate`=?,`firstname`=?,`lastname`=?,`gender`=?,`dob`=?,`bloodgroup`=?,`studentmobileno`=?,`studentemailid`=?,`fathername`=?,`fathermobileno`=?,`mothername`=?,`mothermobileno`=?,`guardianname`=?,`guardianmobileno`=?,`primaryperson`=?,`permanentaddress`=?,`presentaddress`=?,`modifytime`=? WHERE `id`=?";
	public static final String STUDENT_REGISTRATION_LIST = "SELECT * FROM `student` WHERE `isActive`='Y'";
	public static final String EDIT_STUDENT_REGISTRATION = "SELECT * FROM `student` WHERE id=?";
	public static final String DELETE_STUDENT_REGISTRATION = "UPDATE `student` SET `isActive`='N', `remarks`=? WHERE `id`=?";

}
