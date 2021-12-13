package fr.eseo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eseo.beans.DAOFactory;
import fr.eseo.beans.client.Client;
import fr.eseo.beans.client.DAOClient;

/**
 * Servlet implementation class VenteLigne
 */
@WebServlet("/VenteLigne")
public class VenteLigne extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private DAOClient daoclient;
	
	public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        daoclient = daoFactory.getDAOClient();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);		
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String code;
		if(id == null) {
			id = "display";			
		}
		switch(id) {
			case "welcome":
				request.setAttribute("content", "welcome");	
				break;
			case "display":
				List<Client> catalog = daoclient.getClients();				
				request.setAttribute("catalog", catalog);				
				request.setAttribute("content", "display");	
				break;
		}
	}

}
