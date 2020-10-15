package com.studentservice.studentmgt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.studentservice.studentmgt.dto.CreateStudentRequest;
import com.studentservice.studentmgt.dto.StudentDto;
import com.studentservice.studentmgt.dto.UpdateStudentRequest;
import com.studentservice.studentmgt.entities.Student;
import com.studentservice.studentmgt.services.IStudentService;
import com.studentservice.studentmgt.util.StudentUtil;
@Validated
@RequestMapping("students")
@RestController
public class StudentController {

	@Autowired
	private StudentUtil util;

	@Autowired
	private IStudentService service;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public StudentDto addStudent(@RequestBody @Valid CreateStudentRequest request) {
		String name = request.getName();
		int age = request.getAge();
		String address = request.getAddress();
		Long phoneNumber = request.getPhoneNumber();
		Student student = new Student(name, age, address, phoneNumber);
		student = service.add(student);
		StudentDto response = util.studentDto(student);
		return response;
	}

	@GetMapping("/getbyid/{id}")
	public StudentDto findById(@PathVariable("id") Integer id) {
		Student student = service.findById(id);
		StudentDto response = util.studentDto(student);
		return response;
	}

	@GetMapping("")
	public List<StudentDto> allstudents() {
		List<Student> list = service.fetchAllStudent();
		List<StudentDto> response = new ArrayList<>();
		for (Student student : list) {
			StudentDto dto = util.studentDto(student);
			response.add(dto);
		}
		return response;
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteStudent(@PathVariable("id") Integer id) {
		service.removeStudent(id);
	}

	@PutMapping("/update")
	public StudentDto updateStudent(@RequestBody UpdateStudentRequest request) {
		Integer id = request.getId();
		String name = request.getName();
		int age = request.getAge();
		String address = request.getAddress();
		Long phoneNumber = request.getPhoneNumber();
		Student student = new Student(name, age, address, phoneNumber);
		student.setId(id);
		student = service.updateStudent(student);
		StudentDto response = util.studentDto(student);
		return response;
	}

}
