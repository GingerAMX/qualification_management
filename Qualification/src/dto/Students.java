package dto;

public class Students {
	private int id;
	private String name;
	private int grade;
	private String class0;

	public Students() {

	}

	public Students(int id, String name, int grade, String class0) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.class0 = class0;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getClass0() {
		return class0;
	}

	public void setClass0(String class0) {
		this.class0 = class0;
	}

}
