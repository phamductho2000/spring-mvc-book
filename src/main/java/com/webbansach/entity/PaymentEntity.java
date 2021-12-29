package com.webbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "db_payment")
public class PaymentEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "status")
	private int status;
	@OneToMany(mappedBy = "payment")
	private List<OrderEntity> order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(List<OrderEntity> order) {
		this.order = order;
	}
}
