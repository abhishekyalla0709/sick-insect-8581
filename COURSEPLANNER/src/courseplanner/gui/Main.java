package courseplanner.gui;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter 1 to Admin login");
	System.out.println("Enter 2 to Employee login");
	System.out.println("Enter 0 to exit");
	int choice = sc.nextInt();
	//the moment the choice is 1 user should be able to see all the operations
	// that can be performed by admin
	if(choice == 1) {
		System.out.println("Enter the username of Admin");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		
		ResourceBundle bundle = ResourceBundle.getBundle("adminlogindetails");
		System.out.println(bundle.getString("username") + " " + bundle.getString("password"));
		if(username.equals(bundle.getString("username")) && password.equals(bundle.getString("password"))) {
			System.out.println("login succesfull");
			//now connect this with the Admin operations
		}
		else {
			System.out.println("Login failed!\nInvalid username or password");
		}
		
		
	}
	
	else if(choice == 2) {
		
	}
	
	else if(choice == 0) {
		System.out.println("Thank you for choosing our services. Visit again!");
	}
	// the same should when user enters 2 but this time operations should be of Faculty
	
	
	
	sc.close();
}
}
