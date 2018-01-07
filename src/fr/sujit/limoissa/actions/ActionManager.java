package fr.sujit.limoissa.actions;

import java.util.HashMap;
import java.util.Map;



public final class ActionManager {
	
	/**
	 * First create ActionManager which call AbstractAction to execute the actions
	 * we have mapped in variable actions.
	 * ActionManager list all the available CRUD actions 
	 *	and forward appropriate actions when called with getAction method
	 */
	

	
	//Creation of variables as action name
	public static final String ACTION_ADD = "add";
	public static final String ACTION_DELETE = "delete";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_LIST_BOOKS = "books";
	
	//Creation of Static Map called actions 
	private static Map<String, AbstractAction> actions;
	
	//here static map is populated
	static {
		actions = new HashMap<String, AbstractAction>();
		
		actions.put(ACTION_ADD, new AddBook()); // go create AddBook class before creating other actions
//		actions.put(ACTION_DELETE, new DeleteBook());
//		actions.put(ACTION_EDIT, new EditBook());
		actions.put(ACTION_LIST_BOOKS, new ListBooks());
	}

	//initiation of ActionManager
	private ActionManager() {}
	
	
	public static AbstractAction getAction(String actionName) {
		
		//System.out.println("Action Manager " + actionName);
		return actions.get(actionName);
	}
	
}
