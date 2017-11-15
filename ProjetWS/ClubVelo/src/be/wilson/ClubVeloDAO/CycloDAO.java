package be.wilson.ClubVeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.wilson.ClubVeloPOJO.Balade;
import be.wilson.ClubVeloPOJO.Categorie;
import be.wilson.ClubVeloPOJO.Cyclo;
import be.wilson.ClubVeloPOJO.TypeVTT;
import be.wilson.ClubVeloPOJO.VTT;

public class CycloDAO extends CategorieDAO {
private long generatedId;
	
	public CycloDAO(Connection conn){
		super(conn);
		generatedId = 0;
	}
	
	public boolean create(Cyclo obj) {
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("INSERT INTO Categorie(nbMembres, type, sousType, idPers) "
										  + "VALUES(?, ?, ?, ?)");
			stmt.setInt(1, obj.getNbMembres());
			stmt.setString(2, "Cyclo");
			stmt.setString(3, null);
			stmt.setLong(4, obj.getResp().getId());
			stmt.executeUpdate();
			
			generatedId = stmt.getGeneratedKeys().getInt(1);

			super.close(stmt);
			return true;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean delete(Cyclo obj){
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("DELETE FROM Categorie "
					  					  + "WHERE idCat = ?");
			stmt.setLong(1, obj.getId());
			stmt.executeUpdate();
			
			generatedId = stmt.getGeneratedKeys().getInt(1);

			super.close(stmt);
			return true;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean update(Cyclo obj){
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("UPDATE Categorie "
								  		  + "SET nbMembres = ?, type = ?, sousType = ?, idPers = ?");
			stmt.setInt(1, obj.getNbMembres());
			stmt.setString(2, "Cyclo");
			stmt.setString(3, null);
			stmt.setLong(4, obj.getResp().getId());
			stmt.executeUpdate();
			
			generatedId = stmt.getGeneratedKeys().getInt(1);
			super.close(stmt);
			
			return true;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Cyclo find(int id){
		Cyclo cyc = new Cyclo();
		ResponsableDAO respDAO = new ResponsableDAO(connect);
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Categorie "
														   + "WHERE idAdr = " + id);
			if(result.first()){
				cyc = new Cyclo(id, result.getInt("nbMembres"), respDAO.find(result.getInt("idPers")));
			}
			
			super.close(result);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cyc;
	}
	
	public long getGeneratedId(){
		return generatedId;
	}
}
