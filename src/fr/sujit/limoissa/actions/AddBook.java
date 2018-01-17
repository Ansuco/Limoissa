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
		// Here we store authors informations in an array
		String[] authorSend = request.getParameterValues("authors");
		for (String a : authorSend) {
			String[] authorSplit = a.split(" ");
			Author author = DAOFactory.getInstance().getAuthorDAO().find(Integer.parseInt(authorSplit[0]));
			//for test purpose
			System.out.println("author : " + author.getId() + " " + author.getFirstname() + " " + author.getLastname() + " " + author.getCountry());
			//end test
			book.addAuthor(author);
		}
		//for test 
		System.out.println("book "+ book.getTitle() + " " + book.getOverview() + " " + book.getPrice() + " " + book.isAvailability());
		System.out.println("book.author : "+ book.getAuthors().get(0).getId() + " " + book.getAuthors().get(0).getFirstname() + " " + book.getAuthors().get(0).getLastname() + " " + book.getAuthors().get(0).getCountry());
		//end test
		DAOFactory.getInstance().getBookDAO().create(book);
		
		redirect = new Redirect(true, "books");
		}
		
		return redirect;
	}
}
