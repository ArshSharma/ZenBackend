package com.java.zenapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.zenapi.model.Employee;
import com.java.zenapi.repository.EmployeeRepository;

@Service
public class LoginService {

	@Autowired
	private EmployeeRepository employeeRepositry;
	
	public Employee checkLoginDetails(String email, String password) {
		return employeeRepositry.checkLogin(email, password);
		
	}
}
