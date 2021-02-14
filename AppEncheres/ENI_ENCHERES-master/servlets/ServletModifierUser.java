package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.User;



public class ServletModifierUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/modifUser.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String email = request.getParameter("email");
		
		 Map<String, String> erreurs = new HashMap<String, String>();
		  //Validation du champ email.
        try {
            UserManager.validationEmail(email);
        } catch ( Exception e ) {
            erreurs.put( email, e.getMessage() );
        } 
        
        UserManager userManager = UserManager.getInstance();
		
		try {
			session.setAttribute("user",userManager.dao().modifierUser(userManager.UpdateUser(user, request)));
			response.sendRedirect("/ENI_Encheres/ServletUser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
