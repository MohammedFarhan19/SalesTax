package com.mohammed.farhan.test;

import java.sql.SQLException;
import java.util.List;

import com.mohammed.farhan.db.entity.Produkt;
import com.mohammed.farhan.db.repo.ProduktRepo;

public class FirstDB {

	public static void main(String[] args) {
		try {

			ProduktRepo repo = new ProduktRepo();
			Produkt newProdukt = new Produkt();
			 newProdukt.setProdukt_id(7);
//		newProdukt.setProdukt_name("Updated new Cola");
//		newProdukt.setPrice(67);
//		newProdukt.setImported(true);
//			repo.insert(newProdukt);

//		repo.delete(8);
//		Integer id = 3232;
//		Produkt foundProdukt =repo.selectProdukt(1);
//		if(foundProdukt != null) {
//			System.out.println("ID:" + foundProdukt.getProdukt_id());
//			System.out.println("Name:" + foundProdukt.getProdukt_name());
//			System.out.println("Price:" + foundProdukt.getPrice());
//			System.out.println("Imported:" + foundProdukt.isImported());
//			
//		} else {
//			System.out.println("Invalid Produkt ID" + id);
//		}
//		

			List<Produkt> foundProduktList = repo.selectAllProdukts();
			if (foundProduktList != null && !foundProduktList.isEmpty()) {
				for (Produkt iProdukt : foundProduktList) {
					System.out.print("ID:" + iProdukt.getProdukt_id());
					System.out.print(" | Name:" + iProdukt.getProdukt_name());
					System.out.print(" | Price:" + iProdukt.getPrice());
					System.out.print(" | Imported:" + iProdukt.isImported());
				}

			} else {
				System.out.println("No Produkta found ");
			}

		} catch (SQLException e) {
			System.err.println("DataBase Exception: " + e.getMessage());
		}

	}
}
