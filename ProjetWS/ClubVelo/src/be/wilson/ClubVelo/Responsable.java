package be.wilson.ClubVelo;

import java.util.GregorianCalendar;

public class Responsable extends Personne {
	private static final long serialVersionUID = 2364367160201498393L;
	private GregorianCalendar dateExp;
	
	public Responsable(int id, String nom, String prenom, GregorianCalendar dateNaiss, GregorianCalendar dateExp) {
		super(id, nom, prenom, dateNaiss);
		this.dateExp = dateExp;
	}

	public GregorianCalendar getDateExp() {
		return dateExp;
	}

	public void setDateExp(GregorianCalendar dateExp) {
		this.dateExp = dateExp;
	}
}
