package model.bean;

public class Skill {
	private int id;
	private String name;
	private int value;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skill(int id, String name, int value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}
	
}