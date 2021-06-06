package com.webbansach.dto;

import java.math.BigDecimal;

public class OrderDTO extends AbstractDTO<OrderDTO>{
	private BigDecimal total_price;
	private int user_id;
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
