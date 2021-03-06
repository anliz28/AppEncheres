package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.User;



public class ServletSupprimerUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");		
		UserManager userManager = UserManager.getInstance();
		userManager.DeleteUser(user.getId());
		
		session.invalidate();
		response.sendRedirect("/ENI_Encheres/ServletAcceuil");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
