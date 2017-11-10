package be.wilson.ClubVeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.wilson.ClubVeloPOJO.Balade;
import be.wilson.ClubVeloPOJO.Categorie;
import be.wilson.ClubVeloPOJO.TypeVTT;
import be.wilson.ClubVeloPOJO.VTT;

public class VTTDAO extends CategorieDAO {
private long generatedId;
	
	public VTTDAO(Connection conn){
		super(conn);
		generatedId = 0;
	}
	
	public boolean create(VTT obj) {
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("INSERT INTO Categorie(nbMembres, type, sousType, idPers)"
										  + "VALUES(?, ?, ?, ?)");
			stmt.setInt(1, obj.getNbMembres());
			stmt.setString(2, "VTT");
			stmt.setString(3, obj.getType().name());
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
	
	public boolean delete(VTT obj){
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("DELETE FROM Categorie"
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
	
	public boolean update(VTT obj){
		PreparedStatement stmt = null;
		try{
			stmt = connect.prepareStatement("UPDATE Categorie"
								  		  + "SET nbMembres = ?, type = ?, sousType = ?, idPers = ?");
			stmt.setInt(1, obj.getNbMembres());
			stmt.setString(2, "VTT");
			stmt.setString(3, obj.getType().name());
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
	
	public VTT find(int id){
		VTT cat = new VTT();
		TypeVTT typeVTT = null;
		ResponsableDAO respDAO = new ResponsableDAO(connect);
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Categorie"
														   + "WHERE idAdr = " + id);
			if(result.first()){
				for(TypeVTT t : TypeVTT.values()){
					if(TypeVTT.Descendeur.equals(result.getString("sousType")))
						typeVTT = TypeVTT.Descendeur;
					else if (TypeVTT.Randonneur.equals(result.getString("sousType")))
						typeVTT = TypeVTT.Randonneur;
					else
						typeVTT = TypeVTT.Trialiste;
				}
				cat = new VTT(id, result.getInt("nbMembres"), respDAO.find(result.getInt("idPers")), typeVTT);
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
}