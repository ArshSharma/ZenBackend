package com.java.zenapi.service;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.zenapi.model.Orders;
import com.java.zenapi.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Orders> getAllOrders(){
		return (List<Orders>) orderRepository.findAll();
	}
	
	public Orders addOrder(Orders order) {
		
		return orderRepository.save(order);
		
	}
	
	public Optional<Orders> getOrderById(int id) {
		return orderRepository.findById(id);
	}
	
	public List<Orders> getAllOrdersByAppoitmentDate(){
		return orderRepository.findAllByOrderByAppointmentDateAsc();
	}
	
	@SuppressWarnings("deprecation")
	public List<Orders> getOrdersForDate(Date date){
		Date startDate = date;
		Date endDate= date;
		
//		endDate.setDate(date.getDate()+2);
		System.out.println(startDate.toString());
//		System.out.println(endDate.toString());
		return orderRepository.getAllByAppointmentDateBetween(startDate);
	}
}
