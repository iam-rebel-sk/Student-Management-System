package com.codsoft.task5.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codsoft.task5.Entitiy.Student;
import com.codsoft.task5.payloads.StudentDto;
import com.codsoft.task5.repositories.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService{

	
	private ModelMapper modelMapper;
	private StudentRepo studentRepo;
	
	
	
	@Autowired
	public StudentServiceImpl(ModelMapper modelMapper, StudentRepo studentRepo) {
		super();
		this.modelMapper = modelMapper;
		this.studentRepo = studentRepo;
	}

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		Student savesdStudent = studentRepo.save(modelMapper.map(studentDto,Student.class));
		return modelMapper.map(savesdStudent, StudentDto.class);
	}

	@Override
	public StudentDto getStudent(int id) {
		Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException());
		return studentToDto(student);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> students = studentRepo.findAll();
		List<StudentDto> studentDtos = students.stream().map((student)->studentToDto(student)).collect(Collectors.toList());
		
		
		return studentDtos;
	}

	@Override
	public void deleteStudent(int id) {
		Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException());
		studentRepo.delete(student);
	}

	@Override
	public StudentDto updateStudent(StudentDto dto) {
		Student updatedStudent = studentRepo.save(dtoToStudent(dto));
		return studentToDto(updatedStudent);
	}
	
	@Override
	public List<StudentDto> searchStudent(String keyword) {
		List<Student> students = studentRepo.findByNameContaining(keyword);
		List<StudentDto> studentDtos = students.stream().map((student)->studentToDto(student)).collect(Collectors.toList());
		return studentDtos;
	}
	
	public Student dtoToStudent (StudentDto studentDto) {
		return modelMapper.map(studentDto,Student.class);
	}
	
	public StudentDto studentToDto(Student student) {
		return modelMapper.map(student, StudentDto.class);
	}

	
	

}
