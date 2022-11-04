package com.gl.StdMgnt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.StdMgnt.service.StudentService;

import lombok.RequiredArgsConstructor;

import com.gl.StdMgnt.model.Student;

@Controller
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;

	@GetMapping("list")
	public String showStudents(Model model) {
		List<Student> students = this.studentService.fetchAllStudents();
		model.addAttribute("students", students);
		return "student-list";
	}

	@GetMapping("showStudentForm")
	public String showStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("save")
	public String saveStudent(Model model, @ModelAttribute("student") Student student) {
		this.studentService.saveStudent(student);
		return "redirect:/students/list";
	}

	@GetMapping("update")
	public String updateStudent(Model model, @RequestParam("id") int studentId) {
		Student student = this.studentService.fetchStudentById(studentId);
		model.addAttribute("student", student);
		return "student-form";
	}

	@GetMapping("delete")
	public String deleteStudent(Model model, @RequestParam("id") int studentId) {
		this.studentService.deleteStudentById(studentId);
		return "redirect:/students/list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView("/403");
		var userMsg = (user != null) ? "Hi " + user.getName() + ", " : "";
		model.addObject("msg", userMsg + "You do not have permission to perform this action!");
		return model;
	}
}
