package com.inditex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class PricesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	Integer brandId;
	
	String startDate;
	
	String endDate;
	
	Integer priceList;
	
	Long productId;
	
	Integer priority;
	
	Double price;
	
	String curr;
	

}
