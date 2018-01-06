package fr.sujit.limoissa.beans;


public class Author {

	private int id;
	private String firstname;
	private String lastname;
	private String country;
	
	
	public Author() {}
	
	//this constructeur auteur will be called when we want to construct auteur at once
	public Author(String firstname, String lastname, String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
	}
	
	//this constructeur is used to set the auteur informations with id
	public Author(int id, String firstname, String lastname, String country) {
		this(firstname, lastname, country);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
