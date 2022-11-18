package model.bean;

public class Contact {
	private int id;
	private String name;
	private String email;
	private String diachi;
	private int phone;
	private String noidung;
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
	public String getNoidung() {
		return noidung;
	}
	public Contact(int id, String name, String email, String diachi, int phone,
			String noidung) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.diachi = diachi;
		this.phone = phone;
		this.noidung = noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
