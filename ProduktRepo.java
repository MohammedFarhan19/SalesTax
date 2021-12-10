package com.mohammed.farhan.db.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mohammed.farhan.db.common.DBConnectionManager;
import com.mohammed.farhan.db.entity.Produkt;

public class ProduktRepo  {

	// connect to DB
	private DBConnectionManager conManager = new DBConnectionManager();

	public int insert(Produkt produkt) throws SQLException {

		try (Connection connection = conManager.connect();

			// prepare Query
			Statement stmt = connection.createStatement();) {

				String sqlQuery = "INSERT INTO produkts (produkt_name, preis, imported) " + "VALUES ('"
						+ produkt.getProdukt_name() + "', '" + produkt.getPrice() + "', '" + produkt.isImported()
						+ "')";

				// excute Query
				int numberOfAffectedRows = stmt.executeUpdate(sqlQuery);

				// fetch results
				return numberOfAffectedRows;

				// Close Connection Auto close in try with catch

			}

		}

	public int insertUsingPreparedStatment(Produkt produkt) throws SQLException {

		try (Connection connection = conManager.connect();){

			// prepare Query
//			Statement stmt = connection.createStatement();) {
				
	
				String sqlQuery = "INSERT INTO produkts (produkt_name, preis, imported) " + "VALUES (?,?,?)";
				PreparedStatement prstmt =connection.prepareStatement(sqlQuery);

				// excute Query
				prstmt.setString(0, produkt.getProdukt_name());
				prstmt.setDouble(1, produkt.getPrice());
				prstmt.setBoolean(2, produkt.isImported());
				int numberOfAffectedRows =prstmt.executeUpdate(sqlQuery);
				

				// fetch results
				return numberOfAffectedRows;

				// Close Connection Auto close in try with catch

			}

		}

	
	
	public int update(Produkt produkt) throws SQLException{
		try (Connection connection = conManager.connect();

			// prepare Query
			Statement stmt = connection.createStatement();) {

				String sqlQuery = "UPDATE produkts SET "
						+ "produkt_name = '"+ produkt.getProdukt_name()+"' , '"+produkt.getPrice()+"'"
								+ ", '"+produkt.isImported()+"' "
						+ "WHERE id = "+produkt.getProdukt_id()+" ;";
						

				// excute Query
				int numberOfAffectedRows = stmt.executeUpdate(sqlQuery);

				// fetch results
				return numberOfAffectedRows;

				// Close Connection Auto close in try with catch

			}


	}

	
	public int updateUsingPreparedStatment(Produkt produkt) throws SQLException{
		try (Connection connection = conManager.connect();

			// prepare Query
			) {

				String sqlQuery = "UPDATE produkts SET "
						+ "produkt_name = ? , price = ?"
						+ "WHERE id = ? ;";
						

				PreparedStatement stmt = connection.prepareStatement(sqlQuery);
				stmt.setString(0, produkt.getProdukt_name());
				stmt.setDouble(1, produkt.getPrice());
				stmt.setInt(2, produkt.getProdukt_id());
				
				
				// excute Query
				int numberOfAffectedRows = stmt.executeUpdate(sqlQuery);

				// fetch results
				return numberOfAffectedRows;

				// Close Connection Auto close in try with catch

			}


	}
	
	public int delete(Integer id) throws SQLException {
		try (Connection connection = conManager.connect();

				// prepare Query
				Statement stmt = connection.createStatement();) {

					String sqlQuery = "DELETE FROM produkts  "
								+ "WHERE id = "+ id +" ;";
							

					// excute Query
					int numberOfAffectedRows = stmt.executeUpdate(sqlQuery);

					// fetch results
					return numberOfAffectedRows;

					// Close Connection Auto close in try with catch

				}



	}

	
	public Produkt selectProdukt(Integer id) throws SQLException {
		try (Connection connection = conManager.connect();

				// prepare Query
				Statement stmt = connection.createStatement();) {

					String sqlQuery = "SELECT * FROM produkts WHERE id = "+ id +";";
					

					// excute Query
					ResultSet result = stmt.executeQuery(sqlQuery);

					// fetch results
					
					if(result.next()) {
						Produkt currentProdukt = new Produkt();
						currentProdukt.setProdukt_id(result.getInt("id"));
						currentProdukt.setProdukt_name(result.getString("produkt_name"));
						currentProdukt.setPrice(result.getDouble("Price"));
						currentProdukt.setImported(result.getBoolean("imported"));
						return currentProdukt;
						
						
					}
					return null;

					// Close Connection Auto close in try with catch

				}

	}
	
	public Produkt selectUsingPreparedStatmentProdukt(Integer id) throws SQLException {
//		try (Connection connection = conManager.connect();
//
//				// prepare Query
//				) {
//
//					String sqlQuery = "UPDATE produkts SET "
//							+ "produkt_name = ? , price = ?"
//							+ "WHERE id = ? ;";
//							
//
//					PreparedStatement stmt = connection.prepareStatement(sqlQuery);
//					stmt.setString(0, produkt.getProdukt_name());
//					stmt.setDouble(1, produkt.getPrice());
//					stmt.setInt(2, produkt.getProdukt_id());
//					
//					
//					// excute Query
//					int numberOfAffectedRows = stmt.executeUpdate(sqlQuery);
//
//					// fetch results
//					return numberOfAffectedRows;
//
//					// Close Connection Auto close in try with catch
		
		try (Connection connection = conManager.connect();

				// prepare Query
				) {

					String sqlQuery = "SELECT * FROM produkts WHERE id = ?;";
					

					PreparedStatement stmt = connection.prepareStatement(sqlQuery);

					stmt.setInt(2, id);
					
					
					// excute Query
					ResultSet result = stmt.executeQuery(sqlQuery);

					// fetch results
					
					if(result.next()) {
						Produkt currentProdukt = new Produkt();
						currentProdukt.setProdukt_id(result.getInt("id"));
						currentProdukt.setProdukt_name(result.getString("produkt_name"));
						currentProdukt.setPrice(result.getDouble("Price"));
						currentProdukt.setImported(result.getBoolean("imported"));
						return currentProdukt;
						
						
					}
					return null;

					// Close Connection Auto close in try with catch

				}

	}

		
	public List<Produkt> selectAllProdukts() throws SQLException {
		try (Connection connection = conManager.connect();

				// prepare Query
				Statement stmt = connection.createStatement();) {

					String sqlQuery = "SELECT * FROM produkts";

					// excute Query
					ResultSet result = stmt.executeQuery(sqlQuery);

					// fetch results
					List<Produkt> allProdukts = new ArrayList<>();
					while(result.next()) {
						Produkt currentProdukt = new Produkt();
						currentProdukt.setProdukt_id(result.getInt("id"));
						currentProdukt.setProdukt_name(result.getString("produkt_name"));
						currentProdukt.setPrice(result.getDouble("Price"));
						currentProdukt.setImported(result.getBoolean("imported"));
						allProdukts.add(currentProdukt);
						
						
					}
					return allProdukts;

					// Close Connection Auto close in try with catch

				}

	}
	
	
}
