package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

//ShoppingCart class for managing shopping cart.
public class ShoppingCart {
	private ArrayList<Product> cart = new ArrayList<Product>();
	
//	This function will display available items in the Store for purchase.
	public static void displayItems(ArrayList<Product> productList) {
		System.out.println("Item No.\tItem Name\tItem Price\tQuantity Available");
		System.out.println("-------------------------------------------------------------");
		for(int i = 0; i<productList.size(); i++) {
			System.out.println(i+1 +"\t\t"+ productList.get(i).getName() +"\t\t"+ productList.get(i).getPrice() +"\t\t"+ productList.get(i).getQuantity());
		}
	}
	
	
//	This function is used to add item in the shopping cart.
	public void addItem(Product item, int quantity) {
		if(quantity>item.getQuantity() || quantity<=0 ) {
			System.out.println("Invalid Quantity");
		}else {
			cart.add(new Product(item.getName(), quantity, item.getPrice()));
			int remainingQuantity = item.getQuantity() - quantity;
			item.setQuantity(remainingQuantity);
		}
	}
	
	
//	This function is used to display the items of the cart.
	public void displayCart() {
		if(cart.isEmpty()) {
			System.out.println("Your Cart is Empty.");
		}else {
			System.out.println("Item No.\tItem Name\tItem Price\tQuantity Available");
			System.out.println("-------------------------------------------------------------");
			for(int i = 0; i<cart.size(); i++) {
				System.out.println(i+1 +"\t\t"+ cart.get(i).getName() +"\t\t"+ cart.get(i).getPrice() +"\t\t"+ cart.get(i).getQuantity());
			}			
		}
	}
	
	
//	This function is used to generate bill and total amount.
	public void generateBill() {
		displayCart();
		if(cart.isEmpty()) {
			return;
		}
		int billAmount = 0;
		for(Product item: cart) {
			billAmount += item.getPrice()*item.getQuantity();
		}
		System.out.println("Grand Total = "+ billAmount);
	}
	
//	This function updates the cart like updating quantity of the product already available in cart.
	public boolean updateCart(ArrayList<Product> productList) {
		displayCart();
		
		if(cart.size()==0) {
			return false;
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter item number : ");
		int itemIndex = sc.nextInt()-1;
		
		if(itemIndex>=cart.size() || itemIndex<0) {
			System.out.println("Invalid item number");
			return false;
		}
		
		int productIndex;
		for(productIndex = 0; productIndex<productList.size(); productIndex++) {
			if(productList.get(productIndex).getName().equals(cart.get(itemIndex).getName())) {
				break;
			}
		}
		int productQuantity = productList.get(productIndex).getQuantity();
		
		System.out.println("Please Enter updated quantity : ");
		int quantity = sc.nextInt();
		int previousQuantity = cart.get(itemIndex).getQuantity();
		if(quantity<0 || quantity>productQuantity) {
			System.out.println("Invalid Quantity or Desired Quantity not available.");
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
