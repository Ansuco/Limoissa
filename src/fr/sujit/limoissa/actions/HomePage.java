package fr.sujit.limoissa.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.dao.DAOFactory;
import fr.sujit.limoissa.utils.Redirect;

public class HomePage extends AbstractAction {
	
	@Override
	public Redirect executeAction(HttpServletRequest request)
	{
		request.setAttribute("title", "Ajouter Livre/Auteur");
		//Redirect redirect = new Redirect(false, "addsomething");
		//Code below permits to show list of authors 
		List<Author> authors = DAOFactory.getInstance().getAuthorDAO().findAll();
		request.setAttribute("authors", authors);
		return new Redirect(false, "addsomething");
		 
	}
	
}
