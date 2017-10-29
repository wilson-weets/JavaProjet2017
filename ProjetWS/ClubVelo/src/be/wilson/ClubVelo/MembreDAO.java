package be.wilson.ClubVelo;

import java.sql.*;

public class MembreDAO extends DAO<Membre>{
	public MembreDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Membre obj){		
		return false;
	}
	
	public boolean delete(Membre obj){
		return false;
	}
	
	public boolean update(Membre obj){
		return false;
	}
	
	public Membre find(int id){
		Membre membre = new Membre();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne"
							+ "INNER JOIN Membre WHERE ipPers = " + id);
			if(result.first())
				membre = new Membre(id, result.getString("nom"), result.getString("prenom"), result.getDate("dateNaiss"), result.getFloat("cotisation"));
			}
		catch(SQLException e){
			e.printStackTrace();
		}
		return membre;
	}

}
