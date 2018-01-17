package fr.sujit.limoissa.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fr.sujit.limoissa.actions.ActionManager;
import fr.sujit.limoissa.utils.Redirect;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(
		name = "/MainServlet",
		value = { "/books","/add", "/addauthor"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HOME = "/WEB-INF/index.jsp";   
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
		
		Redirect redirect = ActionManager.getAction(actionName).executeAction(request);
		
		
		// for test
		System.out.println("doGet " + redirect.getAction());
		//end test
		request.setAttribute("actionName", redirect.getAction());

		if(redirect.isRedirection())
			response.sendRedirect(request.getContextPath() + "/" + redirect.getAction());
		else	
			this.getServletContext().getRequestDispatcher(HOME).forward(request, response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = getActionName(request);
		//for test
		System.out.println("doPost " + actionName);
		//end test
		Redirect redirect = ActionManager.getAction(actionName).executeAction(request);

		//for test
		System.out.println("doPost " + redirect.getAction() +" "+ redirect.isRedirection());
		//end test
		if(redirect.isRedirection())
		{
			request.setAttribute("actionName", redirect.getAction());
			response.sendRedirect(request.getContextPath() + "/" + redirect.getAction());
		}
		else
		{
			this.getServletContext().getRequestDispatcher(HOME).forward(request, response);
		}
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
