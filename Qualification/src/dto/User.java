package dto;

public class User {
	private int ID;
	private String pass;
	private String Name;
	private int Sid;
	private String Mail;

	public User() {

	}

	public User(int iD, String pass, String name, int sid, String mail) {
		ID = iD;
		this.pass = pass;
		Name = name;
		Sid = sid;
		Mail = mail;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

}
