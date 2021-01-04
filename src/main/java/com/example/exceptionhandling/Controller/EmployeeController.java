package com.example.exceptionhandling.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exceptionhandling.Services.EmployeeService;
//import com.example.exceptionhandling.Services.EmployeeServiceException;
//import com.example.exceptionhandling.handlingexception.IdNotFoundException;
//import com.example.exceptionhandling.handlingexception.ResourceNotFoundException;
//import com.example.exceptionhandling.handlingexception.ResourceNotFoundException;
import com.example.exceptionhandling.model.Employee;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Saving Employee");
		return ResponseEntity.status(HttpStatus.OK).headers(header).build(); 
	}
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		//without custom header
		System.out.println("list is obtained");
		List<Employee> list = employeeService.getAllEmployee();
		HttpHeaders header = new HttpHeaders();
		header.add("description","List of Employee");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(list);
//		if(list.isEmpty()) {
//			throw new ResourceNotFoundException("employee is empty");
		}
	@GetMapping("/get/employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") int id ) {
		Employee emp = employeeService.getById(id);
		System.out.println("list by id is view");
		HttpHeaders header = new HttpHeaders();
		header.add("description", "Getting employee by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(emp);
//		if(emp ==null) {
//			throw new ResourceNotFoundException("Employee is not found");
//			
//		}

		
		}
		
		


}
