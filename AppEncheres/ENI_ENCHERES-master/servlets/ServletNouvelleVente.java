package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.User;



public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EncheresManager encheresManager = EncheresManager.getInstance();
		request.setAttribute("categories", encheresManager.Edao.recupCat());

		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/nouvelleVente.jsp").forward(request, response);	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EncheresManager encheresManager = EncheresManager.getInstance();
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		
		String cat = request.getParameter("categorie");
		int noCategorie = Integer.parseInt(cat);
		Categorie categorie = encheresManager.Edao.findById(noCategorie);
		
		ArticleVendu article = new ArticleVendu();
		article.setNomArticle(request.getParameter("article"));
		article.setDescription(request.getParameter("description"));
		
		String dateDebut = request.getParameter("dateDebutEnchere");
		LocalDateTime dateDebutEnchere = LocalDateTime.parse(dateDebut);
		article.setDateDebutEnchere(dateDebutEnchere);
		
		String dateFin = request.getParameter("dateFinEnchere");
		LocalDateTime dateFinEnchere = LocalDateTime.parse(dateFin);
		article.setDateFinEnchere(dateFinEnchere);
		
		article.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
		int prixVente = article.getPrixVente();
		prixVente = Integer.parseInt(request.getParameter("miseAPrix"));
		article.setPrixVente(prixVente);
		article.setCategorie(categorie);
		article.setUser(user);
	
		
		ArticleVendu art = encheresManager.CreationArticle(article);
		
		
		Retrait retrait = new Retrait();
		retrait.setAdresse(request.getParameter("adresse"));
		retrait.setVille(request.getParameter("ville"));
		retrait.setCp(request.getParameter("cp"));
		retrait.setArticleVendu(art);
		
		encheresManager.CreationRetrait(retrait);
		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/vente.jsp").forward(request, response);	
	}

}
