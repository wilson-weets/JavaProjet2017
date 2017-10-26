package be.wilson.ClubVelo;

import java.util.GregorianCalendar;

public class Membre extends Personne{
	private static final long serialVersionUID = 4199324936270699959L;
	private float cotisation;
	
	public Membre(int id, String nom, String prenom, GregorianCalendar dateNaiss, float cotisation) {
		super(id, nom, prenom, dateNaiss);
		this.cotisation = cotisation;
	}

	public float getCotisation() {
		return cotisation;
	}

	public void setCotisation(float cotisation) {
		this.cotisation = cotisation;
	}
}