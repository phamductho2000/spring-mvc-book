package com.webbansach.dto;

public class OrderDTO extends AbstractDTO<OrderDTO>{
	private int total_price;
	private long user_id;
	private String user_name;
	private String user_address;
	private int user_phone;
	private int status;

	public String getUser_name() {
		return user_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(int user_phone) {
		this.user_phone = user_phone;
	}
}
