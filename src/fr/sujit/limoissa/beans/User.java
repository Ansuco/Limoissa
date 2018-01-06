package fr.sujit.limoissa.beans;

public class User {
	private int id;
	private String pseudo;
	private String firstname;
	private String lastname;
	private String passwd;
	private String email;
	private String role;
	
	public User() {}
	
	public User(String pseudo, String firstname, String lastname, String passwd, String email, String role) {
		this.pseudo = pseudo;
		this.firstname = firstname;
		this.lastname = lastname;
		this.passwd = passwd;
		this.email = email;
		this.role = role;
	}
	
	public User(int id, String pseudo, String firstname, String lastname, String passwd, String email, String role) {
		this(pseudo, firstname, lastname, passwd, email, role);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
