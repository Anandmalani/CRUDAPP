package com.example.cruddemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;
    
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@PostMapping
	public Employee createEmployee(@RequestBody Employee e1) {
		return employeeService.createEmployee(e1);
		
	}
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployee(id);
		
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee e1) {
		return employeeService.updateEmployee(id,e1);
		
	}
	

}
