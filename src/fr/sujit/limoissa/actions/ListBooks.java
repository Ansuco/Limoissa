package fr.sujit.limoissa.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Book;
import fr.sujit.limoissa.dao.DAOFactory;



public class ListBooks extends AbstractAction {

	@Override
	public void executeAction(HttpServletRequest request) {
		
		//System.out.println("Action ListBook");
		List<Book> books = DAOFactory.getInstance().getBookDAO().findAll();
		request.setAttribute("books", books);

	}

}
