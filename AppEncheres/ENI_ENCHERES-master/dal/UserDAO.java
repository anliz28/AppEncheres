package fr.eni.encheres.dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.ConnectionProvider;

public class UserDAO{

	
	private static UserDAO instance = null;

	//SINGLETON
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public UserDAO() {
		
	}

	//Méthode qui sauvegarde un utilisateur
	public void saveUser(User user) throws SQLException {

		String req = "INSERT INTO Users (credit,pseudo,nom,prenom,email,tel,adresse,adresse2,ville,cp,mdp) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		if (ConnectionProvider.getConnection() != null) {

			try {
				PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);

				pstmt.setInt(1,user.getCredit());
				pstmt.setString(2,user.getPseudo());
				pstmt.setString(3,user.getNom());
				pstmt.setString(4,user.getPrenom());
				pstmt.setString(5,user.getEmail());
				pstmt.setString(6,user.getTel());
				pstmt.setString(7,user.getAdresse());
				pstmt.setString(8,user.getAdresse2());
				pstmt.setString(9,user.getVille());
				pstmt.setString(10,user.getCp());
				pstmt.setString(11,user.getMdp());

				pstmt.executeUpdate();

				System.out.println("L'utilisteur à bien été crée !");
		
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}



	//Méthode qui supprime un utilisateur
	public void supUser(int id) throws SQLException{
		
		String req = "DELETE FROM Users WHERE id=?";

	
			if (ConnectionProvider.getConnection() != null) {
				
				try {
					PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);

					pstmt.setInt(1,id);
					pstmt.executeUpdate();

					System.out.println("L'utilisteur à bien été effacer !");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	}


	//Méthode qui affiche le profil d'un utilisateur
	public User afficherUser(String pseudo) throws SQLException {
		
		String req = "SELECT pseudo, nom, prenom, email, tel, adresse, adresse2, ville, cp FROM Users WHERE pseudo=?";
		
		User user = new User();
		try {

			PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);
			pstmt.setString(1, pseudo);
		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	//Méthode qui modifie les données d'un utilisateur
	public User modifierUser( User user) throws SQLException {
		
		String req = "UPDATE Users SET pseudo=?, nom=?, prenom=?, email=?, tel=?, adresse=?, adresse2=?, ville=?, cp=? WHERE id=?";
		 
		if (ConnectionProvider.getConnection() != null) {
			
			try {
				PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);

				pstmt.setString(1,user.getPseudo());
				pstmt.setString(2,user.getNom());
				pstmt.setString(3,user.getPrenom());
				pstmt.setString(4,user.getEmail());
				pstmt.setString(5,user.getTel());
				pstmt.setString(6,user.getAdresse());
				pstmt.setString(7,user.getAdresse2());
				pstmt.setString(8,user.getVille());
				pstmt.setString(9,user.getCp());
				pstmt.setInt(10,user.getId());
				
				pstmt.executeUpdate();
				
				System.out.println("L'utilisteur à bien été modifier !");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	//Méthode qui permet la connection d'un utilisateur à son compte
	public User loginUser(String pseudo, String mdp){
		
		User user = new User();
		
		try {

			PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement("SELECT * FROM Users WHERE pseudo=? AND mdp=?");
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				
				user.setId(rs.getInt("id"));
				user.setPseudo(rs.getString("pseudo"));
				user.setMdp(rs.getString("mdp"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setTel(rs.getString("tel"));
				user.setAdresse(rs.getString("adresse"));
				user.setAdresse2(rs.getString("adresse2"));
				user.setVille(rs.getString("ville"));
				user.setCp(rs.getString("cp"));
				user.setCredit(rs.getInt("credit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	//Méthode qui verifie l'existence du pseudo et mot de passe saisis par l'utilisateur
	public boolean checkLoginPassword(String login, String password) {
		boolean verif = false;

		String resultPseudo = null;
		String resultMdp = null;

		try {

			String req = "SELECT mdp, pseudo FROM Users WHERE pseudo=? AND mdp=?";

			PreparedStatement pstmt = ConnectionProvider.getConnection().prepareStatement(req);
			pstmt.setString(1, login);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();	
			while(rs.next()){
				resultPseudo = rs.getString("pseudo");
				resultMdp = rs.getString("mdp");
			}
			if(login.equals(resultPseudo) && password.equals(resultMdp)){					
				verif = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verif;
	}


}

