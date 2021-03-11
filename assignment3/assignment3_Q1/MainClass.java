package assignment3_Q1;

import java.util.Scanner;


public class MainClass {
	
	// main function for menu driven approach
	public static void main(String[] args) {
		MyTree tree = new MyTree();
		Scanner userInput = new Scanner(System.in);
		while(true){
			System.out.println(tree.currentNode.getPath() + "/> ");
			String userCommand = userInput.nextLine();
			//creating tokens of commands by splitting by spaces
			String[] commandToken = userCommand.split(" ");
			switch(commandToken[0]){
				case "mkdir":
					if(tree.addDirectory(commandToken[1])){
						System.out.println("Directory Created.");
					}else{
						System.out.println("Failed to create Directory.");
					}
					break;
				case "cd":
					tree.changeDirectory(commandToken[1]);
					break;
				case "ls":
					tree.display();
					break;
				case "bk":
					tree.moveBack();
					break;
				case "find":
					try{
						tree.findDirectory(commandToken[1]);						
					}catch(Exception e){
						System.out.println("Please provide directory name.");
					}
					break;
				case "tree":
					tree.printTree();
					break;
				case "exit":
					userInput.close();
					return;
				default:
					System.out.println("Invalid Command.");
			}
		}
	}
}
