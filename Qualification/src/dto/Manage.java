package dto;

public class Manage {
	private int qId;
	private String day;
	private int id;
	private String result;

	public Manage() {

	}

	public Manage(int qId, String day, int id, String result) {
		this.qId = qId;
		this.day = day;
		this.id = id;
		this.result = result;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



}
