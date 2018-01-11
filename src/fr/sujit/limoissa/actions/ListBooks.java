package fr.sujit.limoissa.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Book;
import fr.sujit.limoissa.dao.DAOFactory;
import fr.sujit.limoissa.utils.Redirect;



public class ListBooks extends AbstractAction {

	@Override
	public Redirect executeAction(HttpServletRequest request) {
		
		//System.out.println("Action ListBook");
		List<Book> books = DAOFactory.getInstance().getBookDAO().findAll();
		request.setAttribute("books", books);
//		List<Author> authors = DAOFactory.getInstance().getAuthorDAO().findAll();
//		request.setAttribute("authors", authors);
		return new Redirect(false,"books");

	}

}
