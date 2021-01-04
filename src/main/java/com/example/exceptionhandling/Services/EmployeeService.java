package com.example.exceptionhandling.Services;

import java.util.List;

import com.example.exceptionhandling.handlingexception.IdNotFoundException;
import com.example.exceptionhandling.handlingexception.ResourceNotFoundException;

//import java.util.List;

import com.example.exceptionhandling.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee) throws ResourceNotFoundException  ;
		
	
	public List<Employee> getAllEmployee() throws ResourceNotFoundException;
		
	public Employee getById(int id)throws IdNotFoundException ;
		

}
