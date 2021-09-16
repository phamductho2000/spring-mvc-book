package com.webbansach.dto;

import java.sql.Timestamp;

public class BookDTO extends AbstractDTO<BookDTO>{
	
	private String name;
	
	private int price;

	private int oldPrice;

	private int quanty;

	private  int discount;

	private String author;
	
	private String image;

	private int page;
	
	private String weight;
	
	private String description;

	private String shortDes;

	private String size;

	private int status;

	private int rate;

	private int countReviews;

	private long category_id;
	
	private long publisher_id;

	private Timestamp publishDate;

	private String namePublisher;

	private String nameCategory;

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getNamePublisher() { return namePublisher; }

	public void setNamePublisher(String namePublisher) { this.namePublisher = namePublisher; }

	public Timestamp getPublishDate() { return publishDate; }

	public void setPublishDate(Timestamp publishDate) { this.publishDate = publishDate; }

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

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

	public int getOldPrice() { return oldPrice; }

	public void setOldPrice(int oldPrice) { this.oldPrice = oldPrice; }

	public int getQuanty() { return quanty; }

	public void setQuanty(int quanty) { this.quanty = quanty; }

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getCountReviews() {
		return countReviews;
	}

	public void setCountReviews(int countReviews) {
		this.countReviews = countReviews;
	}
}
