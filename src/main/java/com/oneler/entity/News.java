package com.oneler.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Index;
import org.hibernate.type.TrueFalseType;

@Entity
@Table(name="news",catalog="goods")
public class News {
	
	private Integer id; //field
	private String title;
	private String author;
	
	
	//使用 title + "," + content 可以来描述当前的 News 记录. 
	//即 title + "," + content 可以作为 News 的 desc 属性值
	
	private String content;
	
	private Blob picture;
	@Basic
	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	@Basic
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	private Date date;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() { //property
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="TITLE",nullable=true,unique=true)
	public String getTitle() {
		return title;
	}
  
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="AUTHOR",columnDefinition="TEXT")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE")
	public void setDate(Date date) {
		this.date = date;
	}

	public News(String title, String author, Date date) {
		super();
		this.title = title;
		this.author = author;
		this.date = date;
	}
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author
				+ ", date=" + date + "]";
	}
	
	
	
}
