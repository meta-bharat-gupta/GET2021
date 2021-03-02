package assignment1;

import static java.lang.System.out;
import java.util.ArrayList;


public class MainClass {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Biscuit", 50, 10));
		productList.add(new Product("Orange", 30, 20));
		productList.add(new Product("Apple", 60, 40));
		productList.add(new Product("Coke", 50, 25));

		ShoppingCart userCart = new ShoppingCart();
		
		while(true) {
			out.println("\n             Shopping Menu            ");
			out.println("---------------------------------------");
			out.println("1. To View Available Items in the Shop");
			out.println("2. For Add Item in the Cart");
			out.println("3. For View Items in the Cart");
			out.println("4. For Update Items in the Cart");
			out.println("5. For Generate Bill for the Cart");
			out.println("6. For Exit");
			out.println("Please Enter your choice : ");
			int userChoice = ShoppingCart.readInteger();
			
			switch(userChoice) {
				case 1:
					ShoppingCart.displayItems(productList);
					break;
				
				case 2:
					out.println("To Add Item, Enter the Item number: ");
					int itemIndex = ShoppingCart.readInteger();
					if(itemIndex>0 && itemIndex<=productList.size()) {
						out.println("Enter quantity: ");
						int itemQuantity = ShoppingCart.readInteger();
						userCart.addItem(productList.get(itemIndex-1), itemQuantity);
						break;						
					}else {
						out.println("Invalid Item number");
						break;
					}
				
				case 3:
					userCart.displayCart();
					break;
				
				case 4:
					if(userCart.updateCart(productList)) {
						out.println("Cart Updated Successfully");
					}else {
						out.println("Oops! Cart updation failed");
					}
					break;
				
				case 5:
					userCart.generateBill();
					break;
				
				case 6:
					return;
				
				default:
					out.println("Invalid Choice");
			}
		}
	}
}
