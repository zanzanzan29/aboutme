package model.bean;

public class Changduong {
	private int id;
	private String name;
	private String Date;
	private String phanloai;
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPhanloai() {
		return phanloai;
	}
	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}
	public Changduong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Changduong(int id, String name, String date, String phanloai) {
		super();
		this.id = id;
		this.name = name;
		Date = date;
		this.phanloai = phanloai;
	}
	public Changduong(int id, String name, String date, String phanloai,
			String content) {
		super();
		this.id = id;
		this.name = name;
		Date = date;
		this.phanloai = phanloai;
		this.content = content;
	}
	
	
}
