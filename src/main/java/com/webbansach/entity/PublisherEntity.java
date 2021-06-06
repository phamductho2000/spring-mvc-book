package com.webbansach.entity;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class PublisherEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}

	@OneToMany(mappedBy = "publisher")
	private List<BookEntity> books = new ArrayList<>();
	
}
