package com.codsoft.task5.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codsoft.task5.Entitiy.Student;
import com.codsoft.task5.payloads.StudentDto;
import com.codsoft.task5.services.StudentService;

import jakarta.validation.Valid;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<StudentDto> students = studentService.getAllStudent();
		model.addAttribute("students",students);
		return "index";
	}
	@PostMapping("/processform")
	public String saveStudent(@ModelAttribute("student") @Valid StudentDto studentDto , BindingResult bindingResult) {
		boolean error = bindingResult.hasErrors();
		if(error) {
			return "student_form";	
		}
		else {
			studentService.addStudent(studentDto);
			return "redirect:/";
		}
	}
	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("student", new StudentDto());
		return "student_form";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id){
		studentService.deleteStudent(id);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String deleteStudent(@PathVariable int id , Model model){
		StudentDto student = studentService.getStudent(id);
		model.addAttribute("student", student);
		return "student_form";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword , Model model) {
		List<StudentDto> students = studentService.searchStudent(keyword);
		model.addAttribute("students", students);
		return "index";
	}
	
	
	

}
