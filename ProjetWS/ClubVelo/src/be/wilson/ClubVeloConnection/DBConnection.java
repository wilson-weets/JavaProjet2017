package be.wilson.ClubVeloConnection;

import java.sql.*;

import javax.swing.*;

public class DBConnection {
	private static Connection instance = null;

	private DBConnection() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./ClubVelo.accdb";
			instance = DriverManager.getConnection(url);
		} catch (ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
			JOptionPane.showMessageDialog(null, "La base de donn�es est inaccessible, fermeture du programme.");
			System.exit(0);
		}
	}

	public static Connection getInstance() {
		if (instance == null) {
			new DBConnection();
		}
		return instance;
	}
}