package com.webbansach.entity;

import javax.persistence.*;

@Entity
@Table(name = "db_review")
public class ReviewEntity extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "book_id")
	private BookEntity bookEntity;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;

	String content;
	int rate;

	public BookEntity getBookEntity() { return bookEntity; }
	public void setBookEntity(BookEntity bookEntity) { this.bookEntity = bookEntity; }
	public UserEntity getUserEntity() { return userEntity; }
	public void setUserEntity(UserEntity userEntity) { this.userEntity = userEntity; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public int getRate() { return rate; }
	public void setRate(int rate) { this.rate = rate; }
}
