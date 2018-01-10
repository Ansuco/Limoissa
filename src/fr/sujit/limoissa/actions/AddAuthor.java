package fr.sujit.limoissa.actions;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.beans.Author;
import fr.sujit.limoissa.dao.DAOFactory;

public class AddAuthor extends AbstractAction {
	
    @Override
    public void executeAction(HttpServletRequest request) {

    	Author author = new Author(
    			request.getParameter("author-firstname"),
    			request.getParameter("author-lastname"),
    			request.getParameter("author-country")
  		);
		DAOFactory.getInstance().getAuthorDAO().create(author);

    }

}
