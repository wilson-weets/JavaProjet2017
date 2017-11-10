package be.wilson.ClubVeloDAO;

import java.sql.*;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(int id);
	
	public void close(PreparedStatement stmt){
		try {
			if(stmt != null)
				stmt.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close(ResultSet res){
		try {
			if(res != null)
				res.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

