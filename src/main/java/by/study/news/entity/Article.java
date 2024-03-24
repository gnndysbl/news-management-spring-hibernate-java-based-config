package by.study.news.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="news")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Title is required")
	@Size(min = 6, max = 150, message="Title length min 6 symbols")
	@Column(name="title")
	private String title;
	
	@NotNull(message="Brief is required")
	@Size(min = 6, max = 500, message="Brief length min 6 symbols")
	@Column(name="brief")
	private String brief;

	@NotNull(message="Content is required")
	@Size(min = 6, max = 3000, message="Content length min 6 symbols")
	@Column(name="content")
	private String content;
	
	@Column(name="article_date")
	private Date date;

	@Column(name="status")
	private String status;
	
	public Article() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content + ", date=" + date
				+ ", status=" + status + "]";
	}
	
	
	}
	

