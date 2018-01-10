package fr.sujit.limoissa.actions;

import javax.servlet.http.HttpServletRequest;

import fr.sujit.limoissa.utils.Redirect;


public abstract class AbstractAction {
	
		
	//This class does the main work ..it execute the requested task
	public abstract Redirect executeAction(HttpServletRequest request);
}
