package com.example.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.exception.ResourceNotFoundException;
import com.example.cruddemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
    
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public Employee createEmployee(Employee e1) {
		// TODO Auto-generated method stub
		return employeeRepository.save(e1);
		
	}

	public Employee getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
		
	}

	public Employee updateEmployee(Integer id, Employee e1) {
		// TODO Auto-generated method stub
		Employee e2=employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee","id",id));
		e2.setName(e1.getName());
		e2.setAddress(e1.getAddress());
		employeeRepository.save(e2);
		return e2;
		

	}
	

}
