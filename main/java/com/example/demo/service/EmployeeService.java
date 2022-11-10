package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.*;
import com.example.demo.entity.*;

@Service
public class EmployeeService {
	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	

	
	@Transactional
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Transactional
	
	public Employee findById(int id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		Employee employee2 = employee.get();
		return employee2;
	}
	
	@Transactional

	public String deleteById(int id) {
		Employee employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return "Deleted Employee id "+id;
	}
	
	@Transactional
	
	public Employee update(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	
	public List<Employee> findByName(String name) {
		return employeeRepository.findByFirstname(name);
	}
	

	@Transactional
	public List<Employee> sort(String order){
		
	
		if(order.equals("\"asc\"")) {
			System.out.println(order);
			return employeeRepository.findAll(Sort.by(Direction.ASC, "firstname"));
		}
		System.out.println(order);
		return employeeRepository.findAll(Sort.by(Direction.DESC, "firstname"));
	}


}
