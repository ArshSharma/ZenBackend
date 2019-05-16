package com.java.zenapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="Orders")
public class Orders {
	
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="orderDate")
	private String orderDate;
	
	@Column(name="appointmentDate")
	private Date appointmentDate;
	
	@Column(name="discount")
	private int discount;
	
	@Column(name="total")
	private float total;
	
	
//	@JsonManagedReference
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="client_id")
	private Client client;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="order",cascade = CascadeType.ALL)
	@JsonManagedReference
//	@JoinColumn(name="orderDetails", referencedColumnName="orderDetailsId")
	private List<OrderDetails> orderDetails;
	

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
