package com.centris.campus.serviceImpl;

import java.util.List;

import com.centris.campus.dao.StudentDao;
import com.centris.campus.daoImpl.StudentDaoImpl;
import com.centris.campus.forms.StudentForm;
import com.centris.campus.pojo.StudentPojo;
import com.centris.campus.service.StudentService;

public class StudentServiceImpl implements StudentService{
	StudentDao dao=new StudentDaoImpl();

	public String saveStudent(StudentForm sform) {
		return dao.saveStudent(sform);
	}

	public List<StudentPojo> getStudentRegistrationList() {
		return dao.getStudentRegistrationList();
	}

	public StudentPojo editStudent(String studentId) {
		return dao.editStudent(studentId);
	}

	public String deleteStudent(String studentId, String remarks) {
		return dao.deleteStudent(studentId,remarks);
	}
	
	
}
