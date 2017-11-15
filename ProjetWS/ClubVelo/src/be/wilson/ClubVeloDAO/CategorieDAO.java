package be.wilson.ClubVeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.wilson.ClubVeloPOJO.Balade;
import be.wilson.ClubVeloPOJO.Categorie;
import be.wilson.ClubVeloPOJO.Cyclo;
import be.wilson.ClubVeloPOJO.TypeVTT;
import be.wilson.ClubVeloPOJO.VTT;

public class CategorieDAO extends DAO<Categorie> {
private long generatedId;
	
	public CategorieDAO(Connection conn){
		super(conn);
		generatedId = 0;
	}
	
	public Categorie find(int id){
		VTTDAO vttDAO = new VTTDAO(connect);
		CycloDAO cycloDAO = new CycloDAO(connect);
		Categorie cat = null;
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT type FROM Categorie"
														   + "WHERE idAdr = " + id);
			switch(result.getString("type")){
			case "VTT":
				cat = vttDAO.find(id);
				break;
			case "Cyclo":
				cat = cycloDAO.find(id);
				break;
			}
			
			super.close(result);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cat;
	}
	
	public long getGeneratedId(){
		return generatedId;
	}

	@Override
	public boolean create(Categorie obj) {
		return false;
	}

	@Override
	public boolean delete(Categorie obj) {
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		return false;
	}

	@Override
	public List<Categorie> findAll() {
		return null;
	}
}
