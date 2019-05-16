package com.java.zenapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	public enum ItemType{
		Dental,Spa,Hair
	}
	@Id
	@Column(name="productId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@Column(name="decription")
	private String description;
	@Column(name="price")
	private float price;
	@Column(name = "itemType", nullable = false, length = 45)
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
