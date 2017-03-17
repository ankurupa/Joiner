/**
 * 
 */
package config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import rds.RDS;

/**
 * @author ankurupadhyay3
 * Public class for RDS Config file
 */
public class RDSConfig {
	
	public static File rdsConfig;
	
	public RDSConfig() {
		// TODO Auto-generated constructor stub
	}
	public RDSConfig(File rdsConfig){
		RDSConfig.rdsConfig = rdsConfig;
	}
	
	/*
	 * public function to parse RDS Config file.
	 */
	public static String parseRDSConfig(){
		try{
			String connectionString = null;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(RDSConfig.rdsConfig);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("database");
			Element element = (Element)nList.item(0);
			// set the type of database.
			RDS.databaseType = RDS.DatabaseTypeEnum.valueOf(element.getElementsByTagName("type").item(0).getTextContent());
			String server = element.getElementsByTagName("server").item(0).getTextContent();
			String database = element.getElementsByTagName("name").item(0).getTextContent();
			String port = element.getElementsByTagName("port").item(0).getTextContent();
			String user = element.getElementsByTagName("user").item(0).getTextContent();
			String password = element.getElementsByTagName("password").item(0).getTextContent();
			switch(RDS.databaseType){
				case MYSQL:
					connectionString = "jdbc:mysql://"+server+":"+port+"/"+database+"?user="+user+"&password="+password;
					return connectionString;
				default:
					return null;
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			return null;
		}
	}

}
