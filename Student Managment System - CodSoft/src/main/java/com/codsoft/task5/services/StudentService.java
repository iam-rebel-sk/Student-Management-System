package com.codsoft.task5.services;

import java.util.List;

import com.codsoft.task5.payloads.StudentDto;

public interface StudentService {
	
	StudentDto addStudent(StudentDto studentDto);
	StudentDto getStudent(int id);
	List<StudentDto> getAllStudent();
	void deleteStudent(int id);
	StudentDto updateStudent(StudentDto dto);
	List<StudentDto> searchStudent(String keyword);
	
	
}
