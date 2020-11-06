package com.blakelong.thymeleafcruddb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blakelong.thymeleafcruddb.dao.EmployeeRepository;
import com.blakelong.thymeleafcruddb.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject EmployeeRepository
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// @Override - findAll()
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	// @Override - findById(int id)
	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id); 
		
		Employee employee;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + id);
		}
		
		return employee;
	}
	
	// @Override - save(Employee employee)
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee); 
	}
	
	// @Override - deleteById(int id)
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
