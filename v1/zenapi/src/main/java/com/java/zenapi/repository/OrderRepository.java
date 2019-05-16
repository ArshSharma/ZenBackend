package com.java.zenapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import com.java.zenapi.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
	
	List<Orders> findAllByOrderByAppointmentDateAsc();
	
	@Query(value = "from Orders t where appointmentDate=:startDate")
	List<Orders> getAllByAppointmentDateBetween(@Param("startDate")Date startDate);

}
