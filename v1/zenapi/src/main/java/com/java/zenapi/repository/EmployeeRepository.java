package com.java.zenapi.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.java.zenapi.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e where e.email=?1 and e.password =?2")
	Employee checkLogin(String email,String password);

}
