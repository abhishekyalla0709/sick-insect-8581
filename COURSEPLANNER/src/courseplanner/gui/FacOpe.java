package courseplanner.gui;

import java.util.Scanner;

import courseplanner.dao.FacultyOpearionsImpl;
import courseplanner.dao.FacultyOperations;
import courseplanner.dto.Faculty;
import exceptions.SomethingWentWrong;

public class FacOpe {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	FacultyOperations fo = new FacultyOpearionsImpl();
		System.out.println("Please login first to access Faculty operations");
		System.out.println("Enter the username of Faculty");
		String username = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		try {
			if(fo.facultyLogin(username, password)) {
				int choice1;
				do {
				System.out.println("Enter 1 to see a paticular course plan");
				System.out.println("Enter 2 to fill the daywise planner");
				System.out.println("Enter 3 to update your login credentials");
				System.out.println("Enter 0 to exit");
				choice1 = sc.nextInt();
				if(choice1 == 1) {
					System.out.println("Enter the course plan id");
					String cp_id = sc.next();
					System.out.println(fo.viewCoursePlan(cp_id));
				}
				
				else if(choice1 == 2) {
					System.out.println("Enter the course plan id");
					String cp_id = sc.next();
					System.out.println("Enter the day number for which details has to be updated");
					int dayno = sc.nextInt();
					System.out.println("Enter the topic for that day");
					sc.nextLine();
					String topic = sc.nextLine();
					System.out.println("Enter the status for that day");
					String status = sc.nextLine();
					fo.fillDayWisePlanner(cp_id, dayno, topic, status);
				}
				else if(choice1 == 3) {
					System.out.println("Enter your faculty id");
					String fac_id = sc.next();
					System.out.println("Enter your old user name");
					String old_username = sc.next(); 
					System.out.println("Enter your old password");
					String old_password = sc.next();
					System.out.println("Enter your new user name");
					String new_username = sc.next();
					System.out.println("Enter your new password");
					String new_password = sc.next();
					fo.updateLoginCredentials(fac_id, old_username, old_password, new_username, new_password);
				}
				else if(choice1 == 0) {
					System.out.println("Taking back to the main page");
				}
				else {
					System.err.println("Choose from one of the above options");
				}
			}
				while(choice1 != 0);
			}
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

