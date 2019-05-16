package com.java.zenapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="orderDetails")
public class OrderDetails {

	@Id
	@Column(name="orderDetailId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDetailId;
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name="order_id", referencedColumnName="order_id")
	private Orders order;
	


	

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@ManyToOne
	private Product products;

	

	

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
//	private Product products; 
}
