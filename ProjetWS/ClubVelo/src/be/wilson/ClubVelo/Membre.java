package be.wilson.ClubVelo;

import java.sql.Date;

public class Membre extends Personne{
	private static final long serialVersionUID = 4199324936270699959L;
	private float cotisation;
	
	public Membre(int id, String nom, String prenom, Date dateNaiss, float cotisation) {
		super(id, nom, prenom, dateNaiss);
		this.cotisation = cotisation;
	}
	
	public Membre(){}

	public float getCotisation() {
		return cotisation;
	}

	public void setCotisation(float cotisation) {
		this.cotisation = cotisation;
	}
}
