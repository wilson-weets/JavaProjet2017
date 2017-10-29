package be.wilson.ClubVelo;

import java.sql.Date;

public class Responsable extends Personne {
	private static final long serialVersionUID = 2364367160201498393L;
	private Date dateExp;
	
	public Responsable(int id, String nom, String prenom, Date dateNaiss, Date dateExp) {
		super(id, nom, prenom, dateNaiss);
		this.dateExp = dateExp;
	}
	
	public Responsable(){}

	public Date getDateExp() {
		return dateExp;
	}

	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}
}
