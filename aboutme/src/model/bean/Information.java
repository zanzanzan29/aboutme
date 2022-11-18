package model.bean;

public class Information {
	private int id;
	private String name;
	private String date;
	private String email;
	private String diachi;
	private int phone;
	private String content;
	private int status;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Information(int id, String name, String date, String email,
			String diachi, int phone, String content, int status) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.email = email;
		this.diachi = diachi;
		this.phone = phone;
		this.content = content;
		this.status = status;
	}
	
}
