package com.mohammed.farhan.engine;

import java.util.ArrayList;
import java.util.Scanner;

import com.mohammed.farhan.store.MyMain;

public class DBEngine {
	
	public static void main(String[] args) {
		MyMain one = new MyMain();
		one.prompting();
		ArrayList list = new ArrayList();
		Tax tx = new Tax();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Chose the Name of your Produkt ");
		String nameOfProdukt = input.next();
		System.out.println("Quantity");
		int qty = input.nextInt();
		
		System.out.println("Please type the Price ");
		float price = input.nextFloat();
		
		System.out.println("type y if is imported or n for NO");
		boolean isImported = input.nextBoolean();
		
		tx.calculateSalesTax();
		
		
		//MyMain.getConnection();
		
		
	}

}
