/**
 * 
 */
package testLibrary;

import java.io.File;

import config.RDSConfig;
import rds.MYSQLRDS;
import rds.RDS;

/**
 * @author ankurupadhyay3
 * Public class to test the RDS Operations
 */
public class TestRDS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			RDSConfig.rdsConfig= new File("/Users/ankurupadhyay3/Documents/myconfig.xml");
			String connectionString = RDSConfig.parseRDSConfig();
			System.out.println("Connection string :: "+ connectionString);
			RDS rds = null;
			switch(RDS.databaseType){
				case MYSQL:
					rds = new MYSQLRDS();
				default:
					break;
			}
			
			System.out.println("connecting to database");
			rds.ConnectDatabase(connectionString);
			System.out.println("Connection successfull");
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
}
