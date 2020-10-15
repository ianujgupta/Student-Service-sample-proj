package com.studentservice.studentmgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentservice.studentmgt.entities.Student;

public interface IStudentDao extends JpaRepository<Student, Integer>{

}
