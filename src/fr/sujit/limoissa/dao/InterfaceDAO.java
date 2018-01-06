package fr.sujit.limoissa.dao;

import java.util.List;

public interface InterfaceDAO<T> {
	
	// here T is  java class parameter which is replaced by book, author or user send from DAOFactory
	
	T find(int id);
	void delete(int id);
	void update(T obj);
	void create(T obj);
	List<T> findAll();

}
