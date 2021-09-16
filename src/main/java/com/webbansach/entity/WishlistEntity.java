package com.webbansach.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "db_wishlist")
public class WishlistEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "book_id")
	private BookEntity bookEntity;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;


	public BookEntity getBookEntity() { return bookEntity; }
	public void setBookEntity(BookEntity bookEntity) { this.bookEntity = bookEntity; }
	public UserEntity getUserEntity() { return userEntity; }
	public void setUserEntity(UserEntity userEntity) { this.userEntity = userEntity; }

}
