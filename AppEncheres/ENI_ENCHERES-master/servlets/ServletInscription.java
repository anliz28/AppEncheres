package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UserManager;
import fr.eni.encheres.bo.User;

public class ServletInscription extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/JSP/inscription.jsp";
	
	public static  String champ_pseudo ="pseudo";
	public static  String champ_nom ="nom";
	public static  String champ_prenom ="prenom";
	public static  String champ_email ="email";
	public static  String champ_tel ="tel";
	public static  String champ_adresse="adresse";
	public static  String champ_adresse2 ="adresse2";
	public static  String champ_ville ="ville";
	public static  String champ_cp ="cp";
	public static  String champ_mdp = "mdp";
	public static  String champ_confirm = "confirm";
	public static  final String ATT_ERREURS  = "erreurs";
	public static  final String ATT_RESULTAT = "resultat";
	
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/inscription.jsp").forward(request, response);	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat = null;
		String pseudo = request.getParameter(champ_pseudo);
		String nom = request.getParameter(champ_nom);
		String prenom = request.getParameter(champ_prenom);
		String email = request.getParameter(champ_email);
		String tel = request.getParameter(champ_tel);
		String adresse = request.getParameter(champ_adresse);
		String adresse2 = request.getParameter(champ_adresse2);
		String ville = request.getParameter(champ_ville);
		String cp = request.getParameter(champ_cp);
		String mdp = request.getParameter(champ_mdp);
		String confirm = request.getParameter(champ_confirm);
		
		
		
		
		 Map<String, String> erreurs = new HashMap<String, String>();
		  //Validation du champ email.
        try {
            UserManager.validationEmail( email);
        } catch ( Exception e ) {
            erreurs.put( champ_email, e.getMessage() );
        } 

         //Validation des champs mot de passe et confirmation
        try {
            UserManager.validMdp( mdp, confirm );
            
        	UserManager userManager = UserManager.getInstance();
        	
    	//création d'un nouvel utilisateur	
    		User user = userManager.newUser(pseudo, nom, prenom, email, tel, adresse, adresse2, ville, cp, mdp);
    		
          //création d'une session et enregistrement des données en mémoire
    		HttpSession session = request.getSession();
    		
    		session.setAttribute("user",user);
    		
        } catch ( Exception e ) {
            erreurs.put( champ_mdp, e.getMessage());
        }
	
        // Stockage du résultat et des messages d'erreur dans l'objet request 
        request.setAttribute( ATT_ERREURS, erreurs );
        request.setAttribute( ATT_RESULTAT, resultat );
	
		response.sendRedirect("/ENI_Encheres/ServletUser");
       
    }
	

}


