package com.webbansach.dto;

import java.math.BigDecimal;

public class BookDTO extends AbstractDTO<BookDTO>{
	
	private String name;
	
	private int price;
	
	private String author;
	
	private String image;

	private int page;
	
	private String weight;
	
	private String description;

	private String size;
	
	private long category_id;
	
	private long publisher_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public long getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(long publisher_id) {
		this.publisher_id = publisher_id;
	}
}
