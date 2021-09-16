package com.webbansach.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "db_book")
public class BookEntity extends BaseEntity{

	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;
	@Column(name = "price")
	private int price;
	@Column(name = "old_price")
	private int oldPrice;
	@Column(name = "quanty")
	private int quanty;
	@Column(name = "discount")
	private int discount;
	@Column(name = "author", columnDefinition = "nvarchar")
	private String author;
	@Column(name = "image")
	private String image;
	@Column(name = "page")
	private int page;
	@Column(name = "weight")
	private String weight;
	@Lob
	@Column(name = "des")
	private String description;
	@Column(name = "short_des")
	private String shortDes;
	@Column(name = "size")
	private String size;
	@Column(name = "status")
	private int status;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private PublisherEntity publisher;
	@OneToMany(mappedBy = "bookEntity", fetch = FetchType.LAZY)
	private List<DetailOrderEntity> detailOrder;
	@OneToMany(mappedBy = "bookEntity")
	private List<ReviewEntity> reviews;
	@OneToMany(mappedBy = "bookEntity")
	private List<WishlistEntity> wishlist;

	public List<ReviewEntity> getReviews() { return reviews; }
	public void setReviews(List<ReviewEntity> reviews) { this.reviews = reviews; }
	public String getShortDes() { return shortDes; }
	public void setShortDes(String shortDes) { this.shortDes = shortDes; }
	public int getStatus() {
		return status;
	}
	public int getDiscount() { return discount; }
	public void setDiscount(int discount) { this.discount = discount; }
	public void setStatus(int status) {
		this.status = status;
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
	public int getOldPrice() { return oldPrice; }
	public void setOldPrice(int oldPrice) { this.oldPrice = oldPrice; }
	public int getQuanty() { return quanty; }
	public void setQuanty(int quanty) { this.quanty = quanty; }
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
	public CategoryEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	public PublisherEntity getPublisher() {
		return publisher;
	}
	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}
	public List<DetailOrderEntity> getDetailOrder() { return detailOrder; }
	public void setDetailOrder(List<DetailOrderEntity> detailOrder) { this.detailOrder = detailOrder; }

	public List<WishlistEntity> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<WishlistEntity> wishlist) {
		this.wishlist = wishlist;
	}
}
