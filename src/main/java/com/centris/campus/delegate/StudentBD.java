package com.centris.campus.delegate;

import java.util.List;

import com.centris.campus.forms.StudentForm;
import com.centris.campus.pojo.StudentPojo;
import com.centris.campus.service.StudentService;
import com.centris.campus.serviceImpl.StudentServiceImpl;

public class StudentBD {
	StudentService service=new StudentServiceImpl();

	public String saveStudent(StudentForm sform) {
		return service.saveStudent(sform);
	}

	public List<StudentPojo> getStudentRegistrationList() {
		return service.getStudentRegistrationList();
	}

	public StudentPojo editStudent(String studentId) {
		return service.editStudent(studentId);
	}

	public String deleteStudent(String studentId, String remarks) {
		return service.deleteStudent(studentId,remarks);
	}
	
	
}
