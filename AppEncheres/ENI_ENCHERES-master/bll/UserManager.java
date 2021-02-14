package fr.eni.encheres.bll;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.UserDAO;

public class UserManager {


	private static UserManager instance = null;
	private UserDAO Dao;

	private UserManager(UserDAO userDAO){
		this.Dao = userDAO;
	}

	//SINGLETON
	public static UserManager getInstance() {

		if (instance==null) {
			instance = new UserManager(UserDAO.getInstance());
		}
		return instance;
	}
	//Méthode qui permet de créer un nouvel utilisateur
	public User newUser(String pseudo,String nom, String prenom, String email, String tel, String adresse, String adresse2, String ville, String cp, String mdp){

		User user = new User(pseudo, nom, prenom, email, tel, adresse, adresse2, ville, cp, mdp);

		try {
			this.Dao.saveUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return user;
	}


	//Méthode qui permet de verifier que la saisie de l'email et la confirmation de l'email sont bien similaires
	public static void validMdp(String mdp, String confirm) throws Exception{
		if(mdp != null && confirm != null){
			if(!mdp.equals(confirm)){
				throw new Exception("Les mots de passe saisis sont différents, veuillez saisir un mot de passe et le confirmer!");
			}
		}else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}System.out.println("le mot de passe et confirm sont identiques");
	}


	//Méthode qui vérifie du bon format de l'adresse mail
	public static void validationEmail( String email ) throws Exception {
		if ( email != null && email.trim().length() != 0 ) {
			if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "Merci de saisir une adresse mail valide." );
			}
		} else {
			throw new Exception( "Merci de saisir une adresse mail." );
		}
	}


	//Méthode qui verifie l'existence du compte avec le login entrer par l'utilisateur
	public User verifLogin(String pseudo, String mdp)throws Exception{
		User user = null;
		if(Dao.checkLoginPassword(pseudo, mdp) == true){
			user = Dao.loginUser(pseudo, mdp);

		}else{
			throw new Exception( "erreur de pseudo ou de mot de passe!" );
		}
		return user;
	} 


	public UserDAO dao(){
		return this.Dao;
	}


	public void DeleteUser(int id){
		try {
			this.Dao.supUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public User UpdateUser(User user,HttpServletRequest request){
		
		user.setPseudo(request.getParameter("pseudo"));
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setEmail(request.getParameter("email"));
		user.setTel(request.getParameter("tel"));
		user.setAdresse(request.getParameter("adresse"));
		user.setAdresse2(request.getParameter("adresse2"));
		user.setVille(request.getParameter("ville"));
		user.setCp(request.getParameter("cp"));
		
		return user;
	}


	public User viewUser(String pseudo) throws SQLException{
		return this.Dao.afficherUser(pseudo);
	}

}
