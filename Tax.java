package com.mohammed.farhan.engine;

public class Tax {

	int qty = 0;
	String prodName = null;
	float price = 0.0f;
	boolean imported = false;
	
	float tax = 0.0f;

	void calculateSalesTax() {
		float totalTax = 0.0f;
		if (!imported)
			totalTax = 0.1f;
		
		if (imported)
			totalTax = .15f;
		tax = totalTax * price;
	}

	public String toString() {
		float p = price + tax;
		return qty + " " + prodName + " at " + p;
	}
}
