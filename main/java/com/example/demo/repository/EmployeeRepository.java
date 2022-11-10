package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	public List<Employee> findByFirstname(String name);
	

	

}