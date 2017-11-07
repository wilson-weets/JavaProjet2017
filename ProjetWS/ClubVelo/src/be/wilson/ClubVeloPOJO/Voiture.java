package be.wilson.ClubVeloPOJO;

import java.io.Serializable;
import java.util.*;

public class Voiture implements Serializable {
	private static final long serialVersionUID = 8173001894596959567L;
	private Membre chauffeur;
	private List<Membre> passagers;
	private ListIterator<Membre> iter;
	private String numImmat;
	public Voiture(Membre chauffeur, String numImmat) {
		this.chauffeur = chauffeur;
		passagers = new ArrayList<>();
		iter = passagers.listIterator();
		this.numImmat = numImmat;
	}
	public Membre getChauffeur() {
		return chauffeur;
	}
	public void setChauffeur(Membre chauffeur) {
		this.chauffeur = chauffeur;
	}
	public List<Membre> getPassagers() {
		return passagers;
	}
	public void setPassagers(List<Membre> passagers) {
		this.passagers = passagers;
	}
	public String getNumImmat() {
		return numImmat;
	}
	public void setNumImmat(String numImmat) {
		this.numImmat = numImmat;
	}
	
	public void addMembre(Membre m){
		if(!passagers.contains(m))
			passagers.add(m);
	}
	
	public void removeMembre(Membre m){
		passagers.remove(m);
	}
	
	public boolean equals(Voiture v){
		if(this.getNumImmat() == v.getNumImmat())
			return true;
		else
			return false;
	}
}