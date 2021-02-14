package fr.eni.encheres.bo;

public class Retrait {

	
	String adresse;
	String cp;
	String ville;
	ArticleVendu articleVendu;
	
	
	
	public Retrait() {
		super();
	}


	public Retrait(String adresse, String cp, String ville, ArticleVendu articleVendu) {
		super();
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}



	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public String getCp() {
		return cp;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}




	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	
}
