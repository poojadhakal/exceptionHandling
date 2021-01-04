package com.example.exceptionhandling.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exceptionhandling.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
