package fr.eni.encheres.bo;

public class User {

	protected int id;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private String adresse;
	private String adresse2;
	private String ville;
	private String cp;
	private String mdp;
	private int credit = 0;
	
	
	
	public User() {
		super();
	}

	public User( String pseudo, String nom, String prenom, String email,
			String tel, String adresse, String adresse2, String ville, String cp,
			String mdp) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
		this.adresse2 = adresse2;
		this.ville = ville;
		this.cp = cp;
		this.mdp = mdp;
		
	}

	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getAdresse2() {
		return adresse2;
	}


	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}


	


	@Override
	public String toString() {
		return "User [pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", tel=" + tel + ", adresse=" + adresse
				+ ", adresse2=" + adresse2 + ", ville=" + ville + ", cp=" + cp
				+ ", mdp=" + mdp + "]";
	}
	
	
	
}
