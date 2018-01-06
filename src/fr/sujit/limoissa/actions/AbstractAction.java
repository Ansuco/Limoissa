package fr.sujit.limoissa.actions;

import javax.servlet.http.HttpServletRequest;


public abstract class AbstractAction {
	
		
	//This class does the main work ..it execute the requested task
	public abstract void executeAction(HttpServletRequest request);
}
