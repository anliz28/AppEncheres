package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.User;



public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static  String champ_pseudo ="pseudo";
	public static  String champ_mdp = "mdp";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookiePseudo : cookies){
				if(cookiePseudo.getName().equals("pseudo")){
					request.setAttribute("pseudo", cookiePseudo.getValue());
				}
			}
		}
		if(cookies != null){
			for(Cookie cookieMdp : cookies){
				if(cookieMdp.getName().equals("mdp")){
					request.setAttribute("mdp", cookieMdp.getValue());
				}
			}
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pseudo = request.getParameter(champ_pseudo);
		String mdp = request.getParameter(champ_mdp);


		String rememberMe = request.getParameter("RememberMe");

		if(rememberMe != ""){
			Cookie cookiePseudo = new Cookie("pseudo", pseudo);
			cookiePseudo.setMaxAge(60*60*24*365);
			Cookie cookieMdp = new Cookie("mdp", mdp);
			cookieMdp.setMaxAge(60*60*24*365);
			response.addCookie(cookiePseudo);
			response.addCookie(cookieMdp);
		}

		UserManager userManager = UserManager.getInstance();

		//Vérifie que les données saisies par l'utilisateur correspondent à un profil
		if(userManager.dao().checkLoginPassword(pseudo, mdp)){
		}
		try {
			User user = userManager.verifLogin(pseudo, mdp);
			if(user != null){

				//création d'une session et enregistrement des données en mémoire
				request.getSession().setAttribute("user", user);

				//redirection vers l'acceuil une fois connecté
				response.sendRedirect("/ENI_Encheres/ServletUser");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
