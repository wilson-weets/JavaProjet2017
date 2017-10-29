package be.wilson.ClubVelo;

import java.io.Serializable;
import java.sql.Date;

public abstract class Personne  implements Serializable {
	private static final long serialVersionUID = -3480279736443429062L;
	private int id;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	
	public Personne(int id, String nom, String prenom, Date dateNaiss) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaiss = dateNaiss;
	}
	
	public Personne(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	
}
