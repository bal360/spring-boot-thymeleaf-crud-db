package com.blakelong.thymeleafcruddb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blakelong.thymeleafcruddb.entity.Employee;
import com.blakelong.thymeleafcruddb.service.EmployeeService;

@Controller
public class EmployeeController {
	
	// inject EmployeeService
	@Autowired
	EmployeeService employeeService;
	
	// GET /employees - get all employees
	@RequestMapping("/employees")
	public String findAll(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	// GET /employees/{employeeId} - get one employee by id
	@RequestMapping("/employees/{employeeId}")
	public String findById(@PathVariable int employeeId, Model model) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		model.addAttribute("employee", employee);
		
		return "show-employee";
	}
	
	// POST /employees - create an employee
	@RequestMapping("/employees")
	public String save(Employee employee) {
		return null;
	}
	
	// PUT /employees - edit an employee
	
	// DELETE /employees/{employeeId} - delete by id
	
}
