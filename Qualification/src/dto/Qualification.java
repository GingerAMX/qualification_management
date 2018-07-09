package dto;

public class Qualification {
	private int qId;
	private String qName;

	public Qualification() {

	}

	public Qualification(int qId, String qName) {
		this.qId = qId;
		this.qName = qName;
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

}
