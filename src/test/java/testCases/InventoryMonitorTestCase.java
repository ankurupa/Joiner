package testCases;

import java.util.ArrayList;
import org.json.simple.*;
import java.util.Random;

public class InventoryMonitorTestCase {
	
	protected ArrayList<JSONObject> products;
	protected ArrayList<String> users;
	protected ArrayList<JSONObject> orderStream;
	
	// default constructor
	public InventoryMonitorTestCase(){
	}
	
	// constructor with parameters
	public InventoryMonitorTestCase(int numberOfRegisteredUsers, int numberOfProducts, int numberOfOrders) {
		createProductsInventory(numberOfProducts);
		createSampleRegisteredUsers(numberOfRegisteredUsers);
		createOrderStream(numberOfRegisteredUsers, numberOfProducts, numberOfOrders);
	}
	
	/*
	 * getter and setter functions
	 */
	public ArrayList<JSONObject> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<JSONObject> products) {
		this.products = products;
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}

	public ArrayList<JSONObject> getOrderStream() {
		return orderStream;
	}

	public void setOrderStream(ArrayList<JSONObject> orderStream) {
		this.orderStream = orderStream;
	}

	/*
	 * function for creating the product inventory. This resembles the static relational database.
	 */
	@SuppressWarnings("unchecked")
	public void createProductsInventory(int numberOfProducts){
		this.products = new ArrayList<JSONObject>();
		// add sample products to the inventory. This resembles the relational database.
		for(int i = 1; i<= numberOfProducts; i++){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("p"+Integer.toString(i), 5);
			this.products.add(jsonObject);
		}
	}
	
	/*
	 * function for creating sample set of registered users
	 */
	public void createSampleRegisteredUsers(int numberOfRegisteredUsers){
		// add some registered users
		this.users = new ArrayList<String>();
		for(int i=1; i<=numberOfRegisteredUsers;i++){
			this.users.add("u"+Integer.toString(i));
		}
	}
	
	/*
	 * function for creating order stream.
	 */
	@SuppressWarnings("unchecked")
	public void createOrderStream(int numberOfRegisteredUsers, int numberOfProducts, int numberOfOrders){
		this.orderStream =  new ArrayList<JSONObject>();
		// let's place some orders
		for(int i = 1; i <= numberOfOrders; i++){
			// get random user
			Random userRand = new Random();
			String user = "u" + Integer.toString(userRand.nextInt(numberOfRegisteredUsers)+1);
			// get random product
			Random productRand = new Random();
			String product = "p" + Integer.toString(productRand.nextInt(numberOfProducts)+1);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(user, product);
			this.orderStream.add(jsonObject);
		}
	}
}
