package com.java.zenapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.zenapi.model.Employee;

import com.java.zenapi.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping(value="employee")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Employee addPatient(@RequestBody  Employee employee) {
		
		return loginService.checkLoginDetails(employee.getEmail(),employee.getPassword());
	}

}
