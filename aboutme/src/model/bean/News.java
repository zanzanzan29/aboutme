package model.bean;

public class News {
	private int id;
	private String name;
	private Category category;
	private String picture;
	private int status;
	private String mota;
	private String chitiet;
	private int view;
	private String nguoiviet;
	
	
	public String getNguoiviet() {
		return nguoiviet;
	}
	public void setNguoiviet(String nguoiviet) {
		this.nguoiviet = nguoiviet;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getChitiet() {
		return chitiet;
	}
	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(int id, String name, Category category, String picture,
			int status) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.picture = picture;
		this.status = status;
	}
	public News(int id, String name, Category category, String picture,
			int status, String mota, String chitiet) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.picture = picture;
		this.status = status;
		this.mota = mota;
		this.chitiet = chitiet;
	}
	public News(int id, String name, Category category, String picture,
			int status, String mota, String chitiet, int view) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.picture = picture;
		this.status = status;
		this.mota = mota;
		this.chitiet = chitiet;
		this.view = view;
	}
	public News(int id, String name, Category category, String picture,
			int status, String mota, String chitiet, int view, String nguoiviet) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.picture = picture;
		this.status = status;
		this.mota = mota;
		this.chitiet = chitiet;
		this.view = view;
		this.nguoiviet = nguoiviet;
	}
	
	
	
	
}
