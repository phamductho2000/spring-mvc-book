package com.webbansach.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "db_contact")
public class ContactEntity extends BaseEntity{

	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private int phone;
	@Column(name = "link_map")
	private String link_map;
	@Column(name = "link_fb")
	private String link_fb;
	@Column(name = "link_insta")
	private String link_insta;
	@Column(name = "link_youtube")
	private String link_youtube;
	@Column(name = "link_twitter")
	private String link_twitter;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLink_map() {
		return link_map;
	}

	public void setLink_map(String link_map) {
		this.link_map = link_map;
	}

	public String getLink_fb() {
		return link_fb;
	}

	public void setLink_fb(String link_fb) {
		this.link_fb = link_fb;
	}

	public String getLink_insta() {
		return link_insta;
	}

	public void setLink_insta(String link_insta) {
		this.link_insta = link_insta;
	}

	public String getLink_youtube() {
		return link_youtube;
	}

	public void setLink_youtube(String link_youtube) {
		this.link_youtube = link_youtube;
	}

	public String getLink_twitter() {
		return link_twitter;
	}

	public void setLink_twitter(String link_twitter) {
		this.link_twitter = link_twitter;
	}
}
