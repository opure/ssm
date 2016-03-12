package entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
/*@Entity
@Table(name = "News")*/
public class News {
	private Integer id;
	private String title;
	private String author;
	private Date date;
	public Integer getId() {
		return id;
	}
	/*@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment"*/
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/*@Temporal(TemporalType.TIMESTAMP)
	@Column()*/
	public Date getDate() {
		return date;
	}
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
		super();
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", date=" + date + "]";
	}
	
}