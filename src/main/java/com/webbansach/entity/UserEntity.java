package com.webbansach.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "db_user")
public class UserEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private int phone;
	@Column(name = "username")
	private String username;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "password")
	private String password;
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> order;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "db_user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<RoleEntity> roles = new ArrayList<>();
	@Column(name = "status")
	private int status;
	@OneToMany(mappedBy = "userEntity")
	List<ReviewEntity> reviews;
	@OneToMany(mappedBy = "userEntity")
	List<WishlistEntity> wishlist;

	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<ReviewEntity> getReviews() { return reviews; }
	public void setReviews(List<ReviewEntity> reviews) { this.reviews = reviews; }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	public List<OrderEntity> getOrder() { return order; }
	public void setOrder(List<OrderEntity> order) { this.order = order; }
	public List<WishlistEntity> getWishlist() { return wishlist; }
	public void setWishlist(List<WishlistEntity> wishlist) { this.wishlist = wishlist; }
	public int getStatus() { return status; }
	public void setStatus(int status) { this.status = status; }
}
