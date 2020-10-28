package it.corso.accenture.entities;

import java.io.Serializable;

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titoloString;
	private String autoreString;
	private double prezzo;
	private String data;
	
	public Libro(String titoloString, String autoreString, double prezzo, String data) {
		super();
		this.titoloString = titoloString;
		this.autoreString = autoreString;
		this.prezzo = prezzo;
		this.data = data;
	}
	
	public String getTitoloString() {
		return titoloString;
	}
	
	public void setTitoloString(String titoloString) {
		this.titoloString = titoloString;
	}
	
	public String getAutoreString() {
		return autoreString;
	}
	
	public void setAutoreString(String autoreString) {
		this.autoreString = autoreString;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Libro [titoloString=" + titoloString + ", autoreString=" + autoreString + ", prezzo=" + prezzo
				+ ", data=" + data + "]";
	}

	
}
