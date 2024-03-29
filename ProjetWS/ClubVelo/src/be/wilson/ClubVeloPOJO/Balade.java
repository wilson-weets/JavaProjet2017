package be.wilson.ClubVeloPOJO;

import java.io.*;
import java.sql.Date;
import java.util.*;

import be.wilson.ClubVeloDAO.VoitureDAO;
import be.wilson.ClubVeloFactory.AbstractDAOFactory;

public class Balade implements Serializable {
	private static final long serialVersionUID = 2249723182500190742L;
	private int id;
	private String libelle;
	private Adresse adr;
	private Date date;
	private float fraisDepla;
	private List<Voiture> listVoit;
	private Categorie cat;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	VoitureDAO voitDAO = (VoitureDAO) adf.getVoitureDAO();
	
	public Balade() { }
	
	public Balade(int id, String libelle, Adresse adr, Date date, float fraisDepla, Categorie cat) {
		this.id = id;
		this.libelle = libelle;
		this.adr = adr;
		this.date = date;
		this.fraisDepla = fraisDepla;
		listVoit = new ArrayList<>();
		this.cat = cat;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public List<Voiture> getListVoit() {
		return listVoit;
	}
	public void setListVoit(List<Voiture> listVoit) {
		this.listVoit = listVoit;
	}
	public float getFraisDepla() {
		return fraisDepla;
	}
	public void setFraisDepla(float fraisDepla) {
		this.fraisDepla = fraisDepla;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Adresse getAdr() {
		return adr;
	}
	public void setAdr(Adresse adr) {
		this.adr = adr;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void addVoiture(Voiture b){
		if(!listVoit.contains(b))
			listVoit.add(b);
	}
	
	public void removeVoiture(Voiture b){
		listVoit.remove(b);
	}
	
	public void modifierBalade(Balade b) {
		this.id = b.id;
		this.libelle = b.libelle;
		this.adr = b.adr;
		this.date = b.date;
		this.fraisDepla = b.fraisDepla;
	}
	
	public boolean equals(Balade b){
		if(this.getId() == b.getId())
			return true;
		else
			return false;
	}
}
