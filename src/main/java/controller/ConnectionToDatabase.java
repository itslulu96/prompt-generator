package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ConnectionToDatabase {
	Connection connection = null;
	public Connection connectToDatabase(String databaseName) {

		try {
			if(connection != null && connection.isValid(200)) {
				return connection;
			}
			String url = "jdbc:mysql://localhost:3306/" + databaseName;
			String username = "root", password = "root";
			Class.forName("com.mysql.cj.jdbc.Driver"); 

			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.toString();
		}

		return connection;

	}

	public String getEntryById(String table, int id) throws SQLException {

		Connection connection = connectToDatabase("promptgenerator"); 
		String query = "SELECT nome FROM " + table + " WHERE id = " + id;
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		String entry = result.next() ? result.getString("nome") : "Error";
		statement.close();
		connection.close();
		return entry;

	}

	public  String getSongById (String table, int id) throws SQLException {

		Connection connection = connectToDatabase("promptgenerator"); 
		String query = "SELECT* FROM " + table + " WHERE id = " + id;
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query); 

		//String songName = result.getString("nome");
		//String songLink = result.getString("link");
		String song = result.next() ? result.getString("nome") + ", " + result.getString("link") : "Error";
		statement.close();
		connection.close();
		return song;

	}

	public int countRowsInTable(String table) throws SQLException {

		Connection connection = connectToDatabase("promptgenerator"); 
		String query = "SELECT COUNT(*) FROM " + table;
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query); 
		result.next();
		int count = result.getInt("COUNT(*)");
		statement.close();
		return count;

	}

	public  String getRandomEntryFromTable(String table) throws SQLException {

		Random random_method = new Random();
		int index = random_method.nextInt(1, countRowsInTable(table));
		String randomEntry = getEntryById(table, index); 

		return randomEntry; 

	}

	public  String getRandomSongFromTable(String table) throws SQLException {

		Random random_method = new Random();
		int index = random_method.nextInt(1, countRowsInTable(table));
		String randomEntry = getSongById(table, index); 

		return randomEntry; 

	}

}
