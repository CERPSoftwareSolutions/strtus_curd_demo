package com.centris.campus.dao;

import java.util.List;

import com.centris.campus.forms.StudentForm;
import com.centris.campus.pojo.StudentPojo;

public interface StudentDao {

	String saveStudent(StudentForm sform);

	List<StudentPojo> getStudentRegistrationList();

	StudentPojo editStudent(String studentId);

	String deleteStudent(String studentId, String remarks);

}
