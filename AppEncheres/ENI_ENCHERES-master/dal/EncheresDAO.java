package fr.eni.encheres.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.User;

public class EncheresDAO {



	public EncheresDAO(){
	}

	private static EncheresDAO instance = null;

	//SINGLETON
	public static EncheresDAO getInstance() {
		if (instance == null) {
			instance = new EncheresDAO();
		}
		return instance;
	}



	//Méthode qui sauvegarde un utilisateur
	public void CreerArticleVendu(ArticleVendu article) throws SQLException {

		String req = "INSERT INTO ArticlesVendus ( nomArticle, description,dateDebutEnchere, dateFinEnchere, miseAPrix, etatVente , prixVente, id, noCategorie) VALUES(?,?,?,?,?,?,?,?,?)";

		if (ConnectionProvider.getConnection() != null) {

			try {
				PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);

				pstmt.setString(1,article.getNomArticle());
				pstmt.setString(2,article.getDescription());
				
				LocalDateTime dateDebut = article.getDateDebutEnchere();
				Timestamp sqlDateD = Timestamp.valueOf(dateDebut);
				pstmt.setTimestamp(3,sqlDateD);

				LocalDateTime dateFin = article.getDateFinEnchere();
				Timestamp sqlDateF = Timestamp.valueOf(dateFin);
				pstmt.setTimestamp(4,sqlDateF);
				
				pstmt.setInt(5,article.getMiseAPrix());
				pstmt.setString(6,article.getEtatVente());
				pstmt.setInt(7,article.getPrixVente());
				pstmt.setInt(8,article.getUser().getId());
				pstmt.setInt(9,article.getCategorie().getNoCategorie());


				pstmt.executeUpdate();

				System.out.println("L'article à bien été créé !");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}



	public void CreerRetrait(Retrait retrait){

		String req = "INSERT INTO Retraits ( rue, ville, cp, noArticle) VALUES(?,?,?,?)";
		try {
			if (ConnectionProvider.getConnection() != null) {

				try {
					PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);

					pstmt.setString(1,retrait.getAdresse());
					pstmt.setString(2,retrait.getVille());
					pstmt.setString(3,retrait.getCp());
					pstmt.setInt(4,retrait.getArticleVendu().getNoArticle());

					pstmt.executeUpdate();

					System.out.println("Le retrait à bien été créé !");
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Categorie findById(int noCategorie){
		
		Categorie categorie = new Categorie();

		String req = "Select*FROM Categories WHERE noCategorie=?";
		try {
			if (ConnectionProvider.getConnection() != null) {
				
					PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);
					pstmt.setInt(1,noCategorie);

					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						categorie.setLibelle(rs.getString("libelle"));
						categorie.setNoCategorie(rs.getInt("noCategorie"));
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorie;
	}




	public User findByIdUser(int id){
		
		User user = new User();

		String req = "Select*FROM Users WHERE id=?";
		try {
			if (ConnectionProvider.getConnection() != null) {
				
					PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);
					pstmt.setInt(1,id);

					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						user.setId(rs.getInt("id"));
						user.setPseudo(rs.getString("pseudo"));
						user.setNom(rs.getString("nom"));
						user.setPrenom(rs.getString("prenom"));
						user.setEmail(rs.getString("email"));
						user.setNom(rs.getString("tel"));
						user.setAdresse(rs.getString("adresse"));
						user.setAdresse2(rs.getString("adresse2"));
						user.setVille(rs.getString("ville"));
						user.setCp(rs.getString("cp"));
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	

	public List<Categorie> recupCat(){

		List<Categorie> Categories = new ArrayList<Categorie>();
		
		String req = "SELECT * FROM Categories";
	
		try {
			if (ConnectionProvider.getConnection() != null) {
				PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Categorie categorie = new Categorie();
					categorie.setNoCategorie(rs.getInt("noCategorie"));
					categorie.setLibelle(rs.getString("libelle"));
					Categories.add(categorie);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Categories;
	}
	

}
