package com.mohammed.farhan.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.mohammed.farhan.db.common.DBConnectionManager;

public class MyMain {

	public int wishNumber;
	Scanner inputPrompting = new Scanner(System.in);
	public String name;
	public String produkt;
	int buy;
	boolean wantToBuy = false;
	int[] myBucketList = new int[100];
	private DBConnectionManager conManager = new DBConnectionManager();
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:ucanaccess://C://Users//Mohammed.Farhan//OneDrive - Zurich Insurance//Desktop//Unterlagen//Meine//Java//test//projects_2021//mohammed_//DB_mohammedStore.accdb";
			 conn = DriverManager.getConnection(url);
			Statement st = conn.createStatement();

			String query = "select * from produkts";
			ResultSet rs = st.executeQuery(query);

			System.out.print("Nr.\tName \t\tprice \timported\n-----\t------\t\t-------\t-----------\n");
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getDouble(3) + "\t" + rs.getBoolean(4));

			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return conn;

	}

	public int prompting() {

		System.out.println("What´s your Name please?");
		name = inputPrompting.next();
		System.out.printf("Hallo, Can I help you Mr %s what do you want to do?\n", name);
		System.out.println("do you want to buy something?\nPress 1 for Yes or 2 for No");
		buy = inputPrompting.nextInt();
		if (buy == 1) {
			wantToBuy = true;
			System.out.println("press 1 to See our Produkts and choose from it");
			wishNumber = inputPrompting.nextInt();
			check();

		} else {

			System.out.printf("have a Nice Day Mr %s", name);
		}
		return wishNumber;

	}

	public void choseProdukt() {
		Scanner produktName = new Scanner(System.in);
		System.out.printf("What do you want to buy Mr %s please press 1 to choose from our list ", name);
		Scanner inputInt = new Scanner(System.in);
		int numToPress = inputInt.nextInt();
		if (numToPress == 1) {
			System.out.println("This is our List");
			
		}

	}

	public void check() {
		if (wishNumber == 1 || wishNumber == 2) {
			switch (wishNumber) {
			case 1:
				
						getConnection();
				
				
//				System.out.println("Please choose from our List by Typing Number of the Artikel you Wish to buy");
//				Scanner input = new Scanner(System.in);
//				
//				System.out.println("Please Enter a Number to select and 0 to quit");
//				for (int i = 1; i <= myBucketList.length; i++) {
//					myBucketList[i] = input.nextInt();
//					System.out.println("How many?");
//					int quantity = input.nextInt();
//					if (myBucketList[i] == 0) {
//						System.out.println("Your Bill will be Prepaired");
////						calculateBill();
//						break;
//					} 
//				}

				break;
			case 2:
				choseProdukt();
				break;
			}

		} else

		{
			System.out.println("please choose a valid Value");
//			check();

		}
	}

	public List<Produkts> calculateBill(Connection conn) throws SQLException,ClassNotFoundException {
		System.out.println("you choose following produkts");
		String sql = "SELECT * FROM produkts WHERE  ";
				
		
		return null;
		
//		for(int i = 0; i < myBucketList.length; i++) {
//			System.out.println(myBucketList[i]);
//		}

	}

}
