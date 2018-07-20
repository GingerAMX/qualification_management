package dto;

public class Manage {
	private int qId;
	private String qName;
	private int id;
	private String name;
	private String day;
	private String result;

	public Manage() {

	}

	public Manage(int qId, String qName, int id, String name, String day, String result) {
		this.qId = qId;
		this.qName = qName;
		this.id = id;
		this.name = name;
		this.day = day;
		this.result = result;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


}

