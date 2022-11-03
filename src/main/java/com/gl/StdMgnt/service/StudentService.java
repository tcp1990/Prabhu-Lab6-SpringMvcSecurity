package com.gl.StdMgnt.service;

import java.util.List;

import com.gl.StdMgnt.model.Student;

public interface StudentService {

	public void saveStudent(Student student);

	public Student findById(int id);

	public List<Student> findAll();

	public void deleteStudent(int id);

	public List<Student> search(String name, String department);

}
