package courseplanner.gui;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

import courseplanner.dao.AdminOperations;
import courseplanner.dao.AdminOperationsImpl;
import exceptions.BatchException;
import exceptions.CourseException;
import exceptions.FacultyException;
import exceptions.SomethingWentWrong;

public class Main {
public static void main(String[] args) throws SomethingWentWrong,BatchException,FacultyException{
	Scanner sc = new Scanner(System.in);
	try {
	int choice;
	
	do {
		System.out.println("Enter 1 to Admin login");
		System.out.println("Enter 2 to Faculty login");
		System.out.println("Enter 0 to exit");
		choice = sc.nextInt();
		if(choice == 1) {
			Admin.main(args);
		}
		
		else if(choice == 2) {
		FacOpe.main(args);	
		}
		
		else if(choice == 0) {
			System.out.println("Thank you for choosing our services. Visit again!");
		}
		else {
			System.err.println("Choose from one of the above options");
		}
	}
	
	while(choice != 0);
	}
	catch (InputMismatchException ex) {
		System.out.println("Enter a valid input");
		Main.main(args);
	}
	sc.close();
}
}
