package fr.sujit.limoissa.actions;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.beans.Book;
import fr.sujit.limoissa.dao.DAOFactory;



public class AddBook extends AbstractAction {

	@Override
	public void executeAction(HttpServletRequest request) {
		Book book = new Book(
			request.getParameter("book-title"),
			request.getParameter("book-overview"),
			Float.parseFloat(request.getParameter("book-price")),
			Boolean.parseBoolean(request.getParameter("book-availability")),
			new ArrayList<Author>()
				);
		
		book.getAuthors().add(new Author(
				request.getParameter("author-firstname"),
				request.getParameter("author-lastname"),
				request.getParameter("author-country")
				));
		DAOFactory.getInstance().getBookDAO().create(book);
		
		
	}
}
