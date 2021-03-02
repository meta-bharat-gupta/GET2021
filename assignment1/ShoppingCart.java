package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.System.out;


//ShoppingCart class for managing shopping cart.
public class ShoppingCart {
	private ArrayList<Product> cart = new ArrayList<Product>();
	
	/**
	 * To read integer from input stream and check for wrong inputs.
	 * @return
	 * 		return input integer.
	 */
	public static int readInteger(){
		int userChoice;
		InputStreamReader userInput = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(userInput);
		while(true){
			try{
				userChoice = Integer.parseInt(bufferedReader.readLine());
				break;
			}catch(Exception e){
				out.println("Wrong Input Type. Please try again.");
			}
		}
		return userChoice;
	}
	
	
	/**
	 * This function will display available items in the Store for purchase.
	 * @param productList
	 * 			ArrayList of Products.
	 */
	public static void displayItems(ArrayList<Product> productList) {
		out.println("Item No.\tItem Name\tItem Price\tQuantity Available");
		out.println("-------------------------------------------------------------");
		for(int i = 0; i<productList.size(); i++) {
			out.println(i+1 +"\t\t"+ productList.get(i).getName() +"\t\t"+ productList.get(i).getPrice() +"\t\t"+ productList.get(i).getQuantity());
		}
	}
	
	
	/**
	 * This function is used to add item in the shopping cart.
	 * @param item
	 * 			Product which has to be added in the cart.
	 * @param quantity
	 * 			Product quantity
	 */
	public void addItem(Product item, int quantity) {
		if(quantity>item.getQuantity()) {
			out.println("Sorry, We are short on stock for these quantities.");
		}else if(quantity<=0){
			out.println("Invalid Quantity");
		}
		else {
			cart.add(new Product(item.getName(), quantity, item.getPrice()));
			int remainingQuantity = item.getQuantity() - quantity;
			item.setQuantity(remainingQuantity);
		}
	}
	
	
	/**
	 * This function is used to display the items of the cart.
	 */
	public void displayCart() {
		if(cart.isEmpty()) {
			out.println("Your Cart is Empty.");
		}else {
			out.println("Item No.\tItem Name\tItem Price\tQuantity Available");
			out.println("-------------------------------------------------------------");
			for(int i = 0; i<cart.size(); i++) {
				out.println(i+1 +"\t\t"+ cart.get(i).getName() +"\t\t"+ cart.get(i).getPrice() +"\t\t"+ cart.get(i).getQuantity());
			}			
		}
	}
	
	
	/**
	 * This function is used to generate bill and total amount.
	 */
	public void generateBill() {
		displayCart();
		if(cart.isEmpty()) {
			return;
		}
		int billAmount = 0;
		for(Product item: cart) {
			billAmount += item.getPrice()*item.getQuantity();
		}
		out.println("Grand Total = "+ billAmount);
	}
	
	/**
	 * This function updates the cart like updating quantity of the product already available in cart.
	 * @param productList
	 * 			ArrayList of Product items available in the shop.
	 * @return boolean
	 * 			boolean whether cart update process is successful or not.
	 */
	public boolean updateCart(ArrayList<Product> productList) {
		displayCart();
		
		if(cart.size()==0) {
			return false;
		}
		
		out.println("Please Enter item number : ");
		int itemIndex = readInteger()-1;
		
		if(itemIndex>=cart.size() || itemIndex<0) {
			out.println("Invalid item number");
			return false;
		}
		
		int productIndex;
		for(productIndex = 0; productIndex<productList.size(); productIndex++) {
			if(productList.get(productIndex).getName().equals(cart.get(itemIndex).getName())) {
				break;
			}
		}
		int productQuantity = productList.get(productIndex).getQuantity();
		
		out.println("Please Enter updated quantity : ");
		int quantity = readInteger();
		int previousQuantity = cart.get(itemIndex).getQuantity();
		if(quantity<0 || quantity>productQuantity) {
			out.println("Invalid Quantity or Desired Quantity not available.");
			return false;
		}
		if(quantity==0) {
			cart.remove(itemIndex);
			productList.get(productIndex).setQuantity(productList.get(productIndex).getQuantity()-(quantity-previousQuantity));
			return true;
		}
		cart.get(itemIndex).setQuantity(quantity);
		productList.get(productIndex).setQuantity(productList.get(productIndex).getQuantity()-(quantity-previousQuantity));
		return true;
	}
	
}
