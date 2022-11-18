package model.bean;

public class Comment {
	private int id;
	private String name;
	private String message;
	private News news;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(int id, String name, String message, News news) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.news = news;
	}
	
}
