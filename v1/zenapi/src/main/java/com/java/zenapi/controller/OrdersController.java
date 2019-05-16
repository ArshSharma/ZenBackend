package com.java.zenapi.controller;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.zenapi.model.DateModel;
import com.java.zenapi.model.Orders;
import com.java.zenapi.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping(value="orders")
public class OrdersController {
	
	@Autowired
	public OrderService orderService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Orders> getAllOrders(){
		
		return orderService.getAllOrders();
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Orders addOrder(@RequestBody Orders order) {
		System.out.println("---------------------------------------------");
		System.out.println(order.getAppointmentDate());
		
		orderService.addOrder(order);
		return order;
	}
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Optional<Orders> getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	@RequestMapping(value="/getordered/byAppointmentDate", method=RequestMethod.GET)
	public List<Orders> getAllOrdersByAppointmentDate() {
		return orderService.getAllOrdersByAppoitmentDate();
	}
	
	@RequestMapping(value="/getByAppointmentDate", method=RequestMethod.POST)
	public List<Orders> getOrdersForAppointmentDate(@RequestBody DateModel dateModel) {
//		System.out.println(dateModel.getDate());
		return orderService.getOrdersForDate(dateModel.getDate());
	}
	

}
