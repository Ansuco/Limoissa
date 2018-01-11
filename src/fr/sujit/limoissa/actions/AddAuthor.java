package fr.sujit.limoissa.actions;

import javax.servlet.http.HttpServletRequest;



import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.dao.DAOFactory;
import fr.sujit.limoissa.utils.Redirect;

public class AddAuthor extends AbstractAction {
	
    @Override
    public Redirect executeAction(HttpServletRequest request) {
    	Redirect redirect = new Redirect(false, "addauthor");
		request.setAttribute("title", "Ajouter un auteur");
		
		if(request.getMethod().equals("post")) {
	    	Author author = new Author();
	    	author.setFirstname(request.getParameter("firstname"));
	    	author.setLastname(request.getParameter("lastname"));
	    	author.setCountry(request.getParameter("country"));	
    	
    		request.setAttribute("author", author);
    		
  		
    		DAOFactory.getInstance().getAuthorDAO().create(author);
			redirect = new Redirect(true, "addauthor");

    }
		return redirect;
    }
}