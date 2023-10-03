package com.example.FeignClient.model;

import javax.validation.constraints.NotNull;

public class PersonVo {
	@NotNull
	private int orderId;
	@NotNull
	private String orderName;
	public PersonVo() {
		super();
	}
	public PersonVo(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
