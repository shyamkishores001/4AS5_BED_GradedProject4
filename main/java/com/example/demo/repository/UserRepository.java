package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	public User findByUsername(String username);


}