package com.webbansach.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_voucher")
public class VoucherEntity extends BaseEntity{

	@Column(name = "code")
	private String code;
	@Column(name = "discount")
	private int discount;
	@Column(name = "expiration_date")
	@Temporal(TemporalType.DATE)
	private Date expiration_date;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private int status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
