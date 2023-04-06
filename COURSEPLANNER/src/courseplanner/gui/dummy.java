package courseplanner.gui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class dummy {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try {
		int choice;
		do {
			System.out.println("Enter a number");
			System.out.println("Enter 1");
			System.out.println("Enter 0");
			choice = sc.nextInt();
				System.out.println("Thanks for choosing 1");
				System.out.println("Thanks for choosing 2");

				//throw new InputMismatchException("Invalid input");
			
		}
		while(choice != 0);
	}
	catch (InputMismatchException ex) {
		System.out.println("Please select one of the above options");
		dummy.main(args);
	}
		sc.close();
}
}
