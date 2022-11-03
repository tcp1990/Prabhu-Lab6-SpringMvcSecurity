package com.gl.StdMgnt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gl.StdMgnt.model.Student;
import com.gl.StdMgnt.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}

	public List<Student> fetchAllStudents() {
		return this.studentRepository.findAll();
	}

	public Student fetchStudentById(int studentId) {
		return this.studentRepository.findById(studentId).orElseThrow();
	}

	public void deleteStudentById(int studentId) {
		this.studentRepository.deleteById(studentId);
	}
}
