package model.bean;

public class Project {
	private int id;
	private String name;
	private String link;
	private String picture;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, String link, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.picture = picture;
	}
	
}
