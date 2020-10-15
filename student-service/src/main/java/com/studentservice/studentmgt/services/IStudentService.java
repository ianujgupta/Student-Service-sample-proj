package com.studentservice.studentmgt.services;

import java.util.List;

import com.studentservice.studentmgt.entities.Student;

public interface IStudentService {

	Student add(Student student);
	
	List<Student>fetchAllStudent();
	
	void removeStudent(Integer id);
	
	Student findById(Integer id);
	
	Student updateStudent(Student student);
}
