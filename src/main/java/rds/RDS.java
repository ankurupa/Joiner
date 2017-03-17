/**
 * 
 */
package rds;

import org.json.simple.JSONArray;

/**
 * @author ankurupadhyay3
 * abstract class which acts as wrapper for all Relational databases classes.
 */
public abstract class RDS {
	
	// enum for different relational databases
	public enum DatabaseTypeEnum{
		MYSQL, MSSQL, POSTGRESQL, AWS
	}
	// database type
	public static DatabaseTypeEnum databaseType;
	
	/*
	 * Abstract methods
	 * 1. persistSnapshot - Public function to persist array of json objects into relational database
	 * 2. ConnectDatabase - Public function to connect to database.
	 */
	public abstract void persistSnapshot(String tempTable, JSONArray jsonArray);
	public abstract void ConnectDatabase(String connectionString);

}
