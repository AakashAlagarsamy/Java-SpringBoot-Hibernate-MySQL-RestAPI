package com.aakash.springbootcrud.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.springbootcrud.springbootcrudapi.model.Employee;
import com.aakash.springbootcrud.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee employee = employeeService.get(id);
		if (employee == null) {
			throw new RuntimeException("Employee with id"+id+" is not found.");
		}
		return employee;
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee has been deleted with id " + id;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
		
	}

}
