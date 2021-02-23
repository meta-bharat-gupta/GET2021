package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Biscuit", 50, 10));
		productList.add(new Product("Orange", 30, 20));
		productList.add(new Product("Apple", 60, 40));
		productList.add(new Product("Coke", 50, 25));

		ShoppingCart userCart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n             Shopping Menu            ");
			System.out.println("---------------------------------------");
			System.out.println("1. To View Available Items in the Shop");
			System.out.println("2. For Add Item in the Cart");
			System.out.println("3. For View Items in the Cart");
			System.out.println("4. For Update Items in the Cart");
			System.out.println("5. For Generate Bill for the Cart");
			System.out.println("6. For Exit");
			System.out.println("Please Enter your choice : ");
			int userChoice = sc.nextInt();
			
			switch(userChoice) {
				case 1:
					ShoppingCart.displayItems(productList);
					break;
				
				case 2:
					System.out.println("To Add Item, Enter the Item number: ");
					int itemIndex = sc.nextInt();
					if(itemIndex>0 && itemIndex<=productList.size()) {
						System.out.println("Enter quantity: ");
						int itemQuantity = sc.nextInt();
						userCart.addItem(productList.get(itemIndex-1), itemQuantity);
						break;						
					}else {
						System.out.println("Invalid Item number");
						break;
					}
				
				case 3:
					userCart.displayCart();
					break;
				
				case 4:
					if(userCart.updateCart(productList)) {
						System.out.println("Cart Updated Successfully");
					}else {
						System.out.println("Oops! Cart updation failed");
					}
					break;
				
				case 5:
					userCart.generateBill();
					break;
				
				case 6:
					return;
				
				default:
					System.out.println("Invalid Choice");
			}
		}
	}
}
