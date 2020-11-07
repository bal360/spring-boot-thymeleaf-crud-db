package com.blakelong.thymeleafcruddb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blakelong.thymeleafcruddb.entity.Employee;
import com.blakelong.thymeleafcruddb.service.EmployeeService;

@Controller
public class EmployeeController {
	
	// inject EmployeeService
	@Autowired
	private EmployeeService employeeService;
	
	// GET /employees - get all employees
	@GetMapping("/employees")
	public String findAll(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	// GET /employees/{employeeId} - get one employee by id
	@GetMapping("/employees/{employeeId}")
	public String findById(@PathVariable int employeeId, Model model) {
		
		Employee employee = employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		model.addAttribute("employee", employee);
		
		return "employees/show-employee";
	}
	
	// GET /employees/showFormForAdd
	@GetMapping("/employees/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
//	 POST /employees - create an employee
	@PostMapping("/employees")
	public String save(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees";
	}
	
	// GET /showFormForUpdate
	@GetMapping("employees/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		// get the employee
		Employee employee = employeeService.findById(id);
		
		// set the employee as a model attribute for pre-populating the form
		model.addAttribute("employee", employee);
		
		// return view
		return "employees/employee-form";
	}
	
	// PUT /employees - edit an employee
//	@PutMapping("/employees")
	
	// DELETE /employees/{employeeId} - delete by id
	
}
