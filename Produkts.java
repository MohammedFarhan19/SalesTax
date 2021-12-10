package com.mohammed.farhan.store;

public class Produkts {
	
	private int Produkt_id;
	private String produkt_name;
	private double Preis;
	private boolean imported;
	
	
	public Produkts() {
	}


	public Produkts(int produkt_id, String produkt_name, double preis, boolean imported) {
		super();
		Produkt_id = produkt_id;
		this.produkt_name = produkt_name;
		Preis = preis;
		this.imported = imported;
	}


	public int getProdukt_id() {
		return Produkt_id;
	}


	public void setProdukt_id(int produkt_id) {
		Produkt_id = produkt_id;
	}


	public String getProdukt_name() {
		return produkt_name;
	}


	public void setProdukt_name(String produkt_name) {
		this.produkt_name = produkt_name;
	}


	public double getPreis() {
		return Preis;
	}


	public void setPreis(double preis) {
		Preis = preis;
	}


	public boolean isImported() {
		return imported;
	}


	public void setImported(boolean imported) {
		this.imported = imported;
	} 
	
	
	
	
	

}
