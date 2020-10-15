package com.studentservice.studentmgt.util;

import org.springframework.stereotype.Component;

import com.studentservice.studentmgt.dto.StudentDto;
import com.studentservice.studentmgt.entities.Student;
@Component
public class StudentUtil {

	public StudentDto studentDto(Student student) {
		StudentDto dto = new StudentDto(student.getId(),student.getName(),student.getAge(),student.getAddress(),student.getPhoneNumber());
		return dto;
}
}
