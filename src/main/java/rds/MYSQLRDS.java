/**
 * 
 */
package rds;

import org.json.simple.JSONArray;
import java.sql.*;

/**
 * @author ankurupadhyay3
 * The class is used for relational database operations
 */
public class MYSQLRDS extends RDS{
	
	// connection object
	public Connection connection;
	
	/*
	 * Function for connecting to the database.
	 */
	public void ConnectDatabase(String connectionString){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(connectionString);
			this.connection = connection;
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	/*
	 * public function to create the table in the database.
	 */
	public boolean createTable(Connection databaseConnection, String table){
		try{
			
			return true;
		}catch(Exception exception){
			System.out.println("Cannot create database table.");
			return false;
		}
	}
	
	/*
	 * public function to persist the array list of json objects into the temporary table.
	 * parameters:
	 * databaseConnection -  The database connection object.
	 * tempTable - The temporary table in the database 
	 * jsonArray - The array of json objects to be persisted
	 * maxAttributes - The maximum number of attributes the json objects can have.
	 * outFile - temp file used to write the data. The file will be used to bulk insert into database.
	 */
	public void persistSnapshot(String tempTable, JSONArray jsonArray){
		
	}
}






