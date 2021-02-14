package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.User;

public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getAttribute("user");
	
		request.getAttribute(user.getNom());
		request.getAttribute(user.getPrenom());
		request.getAttribute(user.getEmail());
		request.getAttribute(user.getAdresse());
		request.getAttribute(user.getAdresse2());
		request.getAttribute(user.getVille());
		request.getAttribute(user.getCp());
		request.getAttribute(user.getPseudo());
		request.getAttribute(user.getTel());
		System.out.println(user);
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/afficherProfil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/afficherProfil.jsp").forward(request, response);
	}

}
