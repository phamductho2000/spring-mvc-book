package com.webbansach.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "db_order")
public class OrderEntity extends BaseEntity{

	@Column(name = "total_price")
	private int total_price;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name = "payment_id")
	private PaymentEntity payment;
	@OneToMany(mappedBy = "order")
	private List<DetailOrderEntity> detailOrder = new ArrayList<>();
	@Column(name = "status")
	private int status;

	public PaymentEntity getPayment() {
		return payment;
	}

	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}

	public int getStatus() { return status; }
	public void setStatus(int status) { this.status = status; }
	public List<DetailOrderEntity> getDetailOrder() { return detailOrder; }
	public void setDetailOrder(List<DetailOrderEntity> detailOrder) { this.detailOrder = detailOrder; }
	public UserEntity getUser() { return user; }
	public void setUser(UserEntity user) { this.user = user; }
	public int getTotal_price() { return total_price; }
	public void setTotal_price(int total_price) { this.total_price = total_price; }
}
