package courseplanner.gui;

import java.util.ResourceBundle;
import java.util.Scanner;

import courseplanner.dao.AdminOperations;
import courseplanner.dao.AdminOperationsImpl;
import exceptions.SomethingWentWrong;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter 1 to Admin login");
	System.out.println("Enter 2 to Employee login");
	System.out.println("Enter 0 to exit");
	int choice = sc.nextInt();
	AdminOperations ao = new AdminOperationsImpl();
	//the moment the choice is 1 user should be able to see all the operations
	// that can be performed by admin
	if(choice == 1) {
		System.out.println("Please login first to access Admin operations");
		System.out.println("Enter the username of Admin");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		try {
			if(ao.adminLogin(username, password)) {
				System.out.println("Enter 1 to perform opearions on Course");
				System.out.println("Enter 2 to perform operations on Faculty");
				System.out.println("Enter 3 to perform operations on Batch");
				System.out.println("Enter 4 to perform operations on courseplan");
			}
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	else if(choice == 2) {
	System.out.println("Operations of Faculty");	
	}
	
	else if(choice == 0) {
		System.out.println("Thank you for choosing our services. Visit again!");
	}
	// the same should when user enters 2 but this time operations should be of Faculty
	
	
	
	sc.close();
}
}
