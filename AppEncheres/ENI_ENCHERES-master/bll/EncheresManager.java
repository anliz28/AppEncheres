package fr.eni.encheres.bll;

import java.sql.SQLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.EncheresDAO;


public class EncheresManager {
	
	private static EncheresManager instance = null;
	public EncheresDAO Edao;

	private EncheresManager(EncheresDAO encheresDAO){
		this.Edao = encheresDAO;
	}

	//SINGLETON
	public static EncheresManager getInstance() {

		if (instance == null) {
			instance = new EncheresManager(EncheresDAO.getInstance());
		}
		return instance;
	}
	
	public EncheresDAO Edao(){
		return this.Edao;
	}
	
	public ArticleVendu CreationArticle(ArticleVendu article){
		
			try {
				this.Edao.CreerArticleVendu(article);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return article;
	}
	
	
	public void CreationRetrait(Retrait retrait){
		this.Edao.CreerRetrait(retrait);
	}
	

	
}
