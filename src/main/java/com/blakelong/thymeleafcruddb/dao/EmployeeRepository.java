package com.blakelong.thymeleafcruddb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blakelong.thymeleafcruddb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// CRUD methods now available from Spring Data
		// findAll()
		// findById()
		// save() (create or update)
		// deleteById()
}
