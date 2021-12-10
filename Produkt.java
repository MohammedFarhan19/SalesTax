package com.mohammed.farhan.db.entity;

public class Produkt {
	
	private int produkt_id;
	private String produkt_name;
	private double price;
	private boolean imported;
	
	
	public Produkt() {
		
	}


	public int getProdukt_id() {
		return produkt_id;
	}


	public void setProdukt_id(int produkt_id) {
		this.produkt_id = produkt_id;
	}


	public String getProdukt_name() {
		return produkt_name;
	}


	public void setProdukt_name(String produkt_name) {
		this.produkt_name = produkt_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isImported() {
		return imported;
	}


	public void setImported(boolean imported) {
		this.imported = imported;
	}
	
	
	
	
	
	

}
