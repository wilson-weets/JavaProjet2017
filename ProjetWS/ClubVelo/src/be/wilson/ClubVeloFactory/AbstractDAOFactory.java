package be.wilson.ClubVeloFactory;
import be.wilson.ClubVeloDAO.*;
import be.wilson.ClubVeloPOJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Membre> getMembreDAO();
	
	public abstract DAO<Responsable> getResponsableDAO();
	
	public abstract DAO<Tresorier> getTresorierDAO();
		
	public abstract DAO<Voiture> getVoitureDAO();
	
	public abstract DAO<Adresse> getAdresseDAO();
	
	public abstract DAO<Categorie> getCatDAO();
	
	public abstract DAO<Balade> getBaladeDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}

}
