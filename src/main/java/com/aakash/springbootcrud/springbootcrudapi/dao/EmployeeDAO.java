package com.aakash.springbootcrud.springbootcrudapi.dao;

import java.util.List;

import com.aakash.springbootcrud.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
	
}
