package be.wilson.ClubVeloPOJO;

import java.io.*;
import java.sql.Date;
import java.util.*;

public class Balade implements Serializable {
	private static final long serialVersionUID = 2249723182500190742L;
	private int id;
	private String libelle;
	private Adresse adr;
	private Date date;
	private float fraisDepla;
	private List<Voiture> listVoit;
	private ListIterator<Voiture> iter;
	private Categorie cat;
	
	public Balade() { }
	public Balade(int id, String libelle, Adresse adr, Date date, float fraisDepla, Categorie cat) {
		this.id = id;
		this.libelle = libelle;
		this.adr = adr;
		this.date = date;
		this.fraisDepla = fraisDepla;
		listVoit = new ArrayList<>();
		iter = listVoit.listIterator();
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
}
