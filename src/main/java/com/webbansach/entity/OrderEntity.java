package com.webbansach.entity;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class OrderEntity extends BaseEntity{

	@Column(name = "total_price")
	private BigDecimal total_price;
	public List<DetailOrderEntity> getDetailOrder() {
		return detailOrder;
	}
	public void setDetailOrder(List<DetailOrderEntity> detailOrder) {
		this.detailOrder = detailOrder;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	@OneToMany(mappedBy = "order")
    private List<DetailOrderEntity> detailOrder = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
