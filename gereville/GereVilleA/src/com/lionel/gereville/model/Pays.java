package com.lionel.gereville.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pays implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private String nom;
	private int nbHabitants;
	private Ville capitale;
	private List<Ville> villes = new ArrayList<Ville>();
	private String president;
	
	
	
	
	public Pays(String nom) {
		super();
		this.nom = nom;
	}

	public void addVille(Ville v){
		villes.add(v);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNbHabitants() {
		return nbHabitants;
	}
	
	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
	}
	
	public Ville getCapitale() {
		return capitale;
	}
	public void setCapitale(Ville capitale) {
		this.capitale = capitale;
	}
	public List<Ville> getVilles() {
		return villes;
	}
	
	

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}
	
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pays other = (Pays) obj;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nom;
	}

	
	
	
	
}
