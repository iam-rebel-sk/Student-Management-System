package com.codsoft.task5.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codsoft.task5.Entitiy.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	List<Student> findByNameContaining(String keyword);
}
