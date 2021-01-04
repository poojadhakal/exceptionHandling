package com.example.exceptionhandling.Serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exceptionhandling.Repo.EmployeeRepo;
import com.example.exceptionhandling.Services.EmployeeService;
import com.example.exceptionhandling.handlingexception.IdNotFoundException;
import com.example.exceptionhandling.handlingexception.ResourceNotFoundException;
import com.example.exceptionhandling.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
EmployeeRepo employeeRepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee()  {
		List<Employee> listEmployee = (List<Employee>)employeeRepo.findAll();
		if(listEmployee.isEmpty()) {
			throw new ResourceNotFoundException("Employee list is not found");
		}
		return listEmployee;
	
	}

	@Override
	public Employee getById(int id)  {
		// TODO Auto-generated method stub
		Optional<Employee> opt = employeeRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new IdNotFoundException("Invalid Id");
		}
	}

}
