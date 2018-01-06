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
			"",
			Float.parseFloat(request.getParameter("book-price")),
			true,
			new ArrayList<Author>()
				);
		book.getAuthors().add(new Author(
				request.getParameter("author-firstname"),
				"",
				null
				));
		DAOFactory.getInstance().getBookDAO().create(book);
		
		
	}
}
