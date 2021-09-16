package com.webbansach.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "db_publisher")
public class PublisherEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@OneToMany(mappedBy = "publisher")
	private List<BookEntity> books = new ArrayList<>();

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


	
}
