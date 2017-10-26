package be.wilson.ClubVelo;

import java.io.*;
import java.util.*;

public class Balade implements Serializable {
	private static final long serialVersionUID = 2249723182500190742L;
	private int id;
	private String libelle;
	private Adresse adr;
	private GregorianCalendar date;
	public Balade(int id, String libelle, Adresse adr, GregorianCalendar date) {
		this.id = id;
		this.libelle = libelle;
		this.adr = adr;
		this.date = date;
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
	public GregorianCalendar getDate() {
		return date;
	}
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
}
