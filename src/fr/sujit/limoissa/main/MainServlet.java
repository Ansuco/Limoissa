package fr.sujit.limoissa.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.sujit.limoissa.actions.ActionManager;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(
		name = "/MainServlet",
		value = { "/home", "/books", "books/add"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		request.setAttribute("title", "Library Limoissa"); 	// To change the name of the title page.	
		
		String actionName = getActionName(request);
		
		//System.out.println(actionName);
		
		ActionManager.getAction(actionName).executeAction(request);
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/**
	 * creation of method to parse the uri to get the action name
	 * here the word after last "/" is recovered
	 */
	
	private String getActionName(HttpServletRequest req) {
		String uri = req.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}

}
