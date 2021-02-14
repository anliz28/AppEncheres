package fr.eni.encheres.bo;

import java.time.LocalTime;

public class Enchere extends ArticleVendu{
	
	LocalTime dateEnchere;
	int montantEnchere;
	int id;
	int noArticle;
	
	
	
	public Enchere() {
		super();
	}
	
	
	public Enchere(LocalTime dateEnchere, int montantEnchere, int noArticle) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
	}
	
	
	public LocalTime getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	

}
