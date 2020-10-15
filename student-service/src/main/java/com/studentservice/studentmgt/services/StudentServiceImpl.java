package com.studentservice.studentmgt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentservice.studentmgt.dao.IStudentDao;
import com.studentservice.studentmgt.entities.Student;
import com.studentservice.studentmgt.exceptions.InvalidArgumentException;
import com.studentservice.studentmgt.exceptions.StudentNotFoundException;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public Student add(Student student) {
		validate(student);
		student = dao.save(student);
		return student;
	}

	@Override
	public List<Student> fetchAllStudent() {
		List<Student> list = dao.findAll();
		return list;
	}

	@Override
	public void removeStudent(Integer id) {
		validate(id);
		dao.deleteById(id);
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> optional = dao.findById(id);
		boolean exist = optional.isPresent();
		if (!exist) {
			throw new StudentNotFoundException("Student not found for id: " + id);
		}
		Student student = optional.get();
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		validate(student);
		student = dao.save(student);
		return student;
	}

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("student can't be null");
		}
	}

}
