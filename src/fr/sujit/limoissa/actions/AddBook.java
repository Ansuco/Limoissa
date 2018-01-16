package fr.sujit.limoissa.actions;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.beans.Book;
import fr.sujit.limoissa.dao.DAOFactory;
import fr.sujit.limoissa.utils.Redirect;



public class AddBook extends AbstractAction {

	@Override
	public Redirect executeAction(HttpServletRequest request) {
		
		Redirect redirect = new Redirect(false, "add");
		
		//Code below permits to show list of authors 
		List<Author> authors = DAOFactory.getInstance().getAuthorDAO().findAll();
		request.setAttribute("authors", authors);
		
		if(request.getMethod().equals("POST"))
		{
			
			//System.out.println(request.getParameter("overview"));
			
		Book book = new Book(
			request.getParameter("title"),
			request.getParameter("overview"),
			Float.parseFloat(request.getParameter("price")),
			Boolean.parseBoolean(request.getParameter("availability")),
			new ArrayList<Author>()
				);
		
		book.getAuthors().add(new Author(
				request.getParameter("firstname"),
				request.getParameter("lastname"),
				request.getParameter("country")
				));
		DAOFactory.getInstance().getBookDAO().create(book);
		
		redirect = new Redirect(true, "books");
		}
		
		return redirect;
	}
}
