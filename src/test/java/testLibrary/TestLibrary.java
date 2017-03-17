/**
 * 
 */
package testLibrary;

import testCases.InventoryMonitorTestCase;
import java.util.ArrayList;
import org.json.simple.*;

/**
 * @author ankurupadhyay3
 *
 */
public class TestLibrary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfRegisteredUsers = 3;
		int numberOfProducts = 10;
		int numberOfOrders = 10;
		InventoryMonitorTestCase inventoryMonitorTestCase = new InventoryMonitorTestCase(numberOfRegisteredUsers, numberOfProducts, numberOfOrders);
		
		System.out.println("products inventory");
		ArrayList<JSONObject> productsInventory = inventoryMonitorTestCase.getProducts();
		for(JSONObject product: productsInventory){
			System.out.println(product);
		}
		
		System.out.println("registered users");
		ArrayList<String> registeredUsers = inventoryMonitorTestCase.getUsers();
		for(String user: registeredUsers){
			System.out.println(user);
		}
		
		ArrayList<JSONObject> orderStream = inventoryMonitorTestCase.getOrderStream();
		System.out.println("Number of orders :: "+ orderStream.size());
		for(JSONObject order: orderStream){
			System.out.println(order);
		}
	}

}
