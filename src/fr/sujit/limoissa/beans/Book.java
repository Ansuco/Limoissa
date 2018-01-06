package fr.sujit.limoissa.beans;

import java.util.ArrayList;
import java.util.List;


public class Book {
	private int id;
	private String title;
	private String overview;
	private float price;
	private boolean availability;
	private List<Author> authors;
	
	
	//First initialisation of class book which initialise also arraylist author
	public Book() {
		this.authors = new ArrayList<Author>();
	}
	
	public Book(String title, String overview, float price, boolean availability, List<Author> authors) {
		this();
		this.title = title;
		this.overview = overview;
		this.price = price;
		this.availability = availability;
		this.authors = authors;				
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	
	//This setter will initiate the array list so that we can use addauthor constructor to add new author.
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	//This setter is created to add new author inside arraylist initiated by above setters
	public void addAuthor(Author author) {
		this.authors.add(author);
	}

}
