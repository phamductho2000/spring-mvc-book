package com.webbansach.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "db_category")
public class CategoryEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private int status;
	@OneToMany(mappedBy = "category")
    private List<BookEntity> books = new ArrayList<>();
	public List<BookEntity> getBooks() {
		return books;
	}
	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
