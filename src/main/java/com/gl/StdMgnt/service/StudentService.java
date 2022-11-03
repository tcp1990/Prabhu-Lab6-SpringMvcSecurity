package com.gl.StdMgnt.service;

import java.util.List;

import com.gl.StdMgnt.model.Student;

public interface StudentService {

	public void saveStudent(Student student);

	public List<Student> fetchAllStudents();

	public Student fetchStudentById(int studentId);

	public void deleteStudentById(int studentId);

}
