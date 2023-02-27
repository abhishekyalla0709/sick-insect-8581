package courseplanner.gui;

import java.time.LocalDate;
import java.util.Scanner;

import courseplanner.dao.AdminOperations;
import courseplanner.dao.AdminOperationsImpl;
import courseplanner.dto.Batch;
import courseplanner.dto.BatchImpl;
import courseplanner.dto.Course;
import courseplanner.dto.CourseImpl;
import courseplanner.dto.CoursePlan;
import courseplanner.dto.CoursePlanImpl;
import courseplanner.dto.FacultyImpl;
import courseplanner.dto.Faculty;
import exceptions.SomethingWentWrong;
import java.util.List;
import java.util.ArrayList;

public class Admin {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminOperations ao = new AdminOperationsImpl();
		//the moment the choice is 1 user should be able to see all the operations
		// that can be performed by admin
		//System.out.println("Enter 1");
		System.out.println("Please login first to access Admin operations");
		
		
			System.out.println("Enter the username of Admin");
			String username = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			try {
				if(ao.adminLogin(username, password)) {
					int choice1;
					do {
					System.out.println("Enter 1 to perform operations on Course");
					System.out.println("Enter 2 to perform operations on Faculty");
					System.out.println("Enter 3 to perform operations on Batch");
					System.out.println("Enter 4 to perform operations on courseplan");
					System.out.println("Enter 0 to exit");
					choice1 = sc.nextInt();
					if(choice1 == 1) {
						System.out.println("Enter 1 to create a course");
						System.out.println("Enter 2 to update course");
						System.out.println("Enter 3 to see details of all courses");
						System.out.println("Enter 4 to see details of a particular course");
						System.out.println("Enter 0 to exit");
						int choice2 = sc.nextInt();
						if(choice2 == 1) {
							Course course = new CourseImpl();
							System.out.println("Enter the details of the course");
							System.out.println("Enter the Course ID");
							String c_id = sc.next();
							course.setCourse_id(c_id);
							System.out.println("Enter the Course Name");
							String c_name = sc.next();
							course.setCourse_name(c_name);
							System.out.println("Enter the Course Fee");
							double c_fee = sc.nextDouble();
							course.setCourse_fee(c_fee);
							System.out.println("Enter the Course Descreption");
							sc.nextLine();
							String c_des = sc.nextLine();
							course.setCourse_des(c_des);
							ao.createCourse(course);
						}
						else if(choice2 == 2) {
							Course course = new CourseImpl();
							System.out.println("Enter the details of the course");
							System.out.println("Enter the Course ID");
							String c_id = sc.next();
							course.setCourse_id(c_id);
							System.out.println("Enter the Course Name");
							String c_name = sc.next();
							course.setCourse_name(c_name);
							System.out.println("Enter the Course Fee");
							double c_fee = sc.nextDouble();
							course.setCourse_fee(c_fee);
							System.out.println("Enter the Course Descreption");
							sc.nextLine();
							String c_des = sc.nextLine();
							course.setCourse_des(c_des);
							ao.updateCourse(course);
						}
						else if(choice2 == 3) {
							System.out.println(ao.viewAllCourses()); 
						}
						else if(choice2 == 4) {
							System.out.println("Enter the course Id to see its details");
							String c_id = sc.next();
							System.out.println(ao.viewCourse(c_id));
						}
						else if(choice2 == 0) {
							System.out.println("Going back to admin operations");
						}
						else {
							System.err.println("Choose from one of the above options");
						}
					}
					
					else if(choice1 == 2) {
						System.out.println("Enter 1 to create a Faculty");
						System.out.println("Enter 2 to update a Faculty");
						System.out.println("Enter 3 to see details of all Faculties");
						System.out.println("Enter 4 to see details of a particular Faculty");
						System.out.println("Enter 0 to exit");
						int choice2 = sc.nextInt();
						if(choice2 == 1) {
							Faculty fac = new FacultyImpl();
							System.out.println("Enter the details of the faculty");
							System.out.println("Enter the Faculty ID");
							String f_id = sc.next();
							fac.setFaculty_id(f_id);
							System.out.println("Enter the Faculty Name");
							String f_name = sc.next();
							fac.setFaculty_name(f_name);
							System.out.println("Enter the Faculty address");
							sc.nextLine();
							String f_address = sc.nextLine();
							fac.setFaculty_address(f_address);
							System.out.println("Enter the Faculty Mobile Number");
							String f_mobileno = sc.nextLine();
							fac.setFaculty_mobileno(f_mobileno);
							System.out.println("Enter the Faculty Email");
							String f_email = sc.nextLine();
							fac.setFaculty_email(f_email);
							System.out.println("Enter the Faculty User Name");
							String f_username = sc.nextLine();
							fac.setFaculty_username(f_username);
							System.out.println("Enter the Faculty Password");
							String f_password = sc.nextLine();
							fac.setFaculty_password(f_password);
							ao.createFaculty(fac);
						}
						else if(choice2 == 2) {
							Faculty fac = new FacultyImpl();
							System.out.println("Enter the details of the faculty");
							System.out.println("Enter the Faculty ID");
							String f_id = sc.next();
							fac.setFaculty_id(f_id);
							System.out.println("Enter the Faculty Name");
							String f_name = sc.next();
							fac.setFaculty_name(f_name);
							System.out.println("Enter the Faculty address");
							sc.nextLine();
							String f_address = sc.nextLine();
							fac.setFaculty_address(f_address);
							System.out.println("Enter the Faculty Mobile Number");
							String f_mobileno = sc.nextLine();
							fac.setFaculty_mobileno(f_mobileno);
							System.out.println("Enter the Faculty Email");
							String f_email = sc.nextLine();
							fac.setFaculty_email(f_email);
							System.out.println("Enter the Faculty User Name");
							String f_username = sc.nextLine();
							fac.setFaculty_username(f_username);
							System.out.println("Enter the Faculty Password");
							String f_password = sc.nextLine();
							fac.setFaculty_password(f_password);
							ao.updateFaculty(fac);
						}
						else if(choice2 == 3) {
							System.out.println(ao.viewAllFaculty()); 
						}
						else if(choice2 == 4) {
							System.out.println("Enter the Faculty Id to see their details");
							String f_id = sc.next();
							System.out.println(ao.viewFaculty(f_id));
						}
						else if(choice2 == 0) {
							System.out.println("Going back to admin operations");
						}
						else {
							System.err.println("Choose from one of the above options");
						}
					}
					
					
					else if(choice1 == 3) {
						System.out.println("Enter 1 to create a Batch");
						System.out.println("Enter 2 to update a Batch");
						System.out.println("Enter 3 to see details of all Batches");
						System.out.println("Enter 4 to see details of a particular Batch");
						System.out.println("Enter 5 to allocate the faculty for a batch");
						System.out.println("Enter 0 to exit");
						int choice2 = sc.nextInt();
						if(choice2 == 1) {
							Batch bat = new BatchImpl();
							System.out.println("Enter the details of the Batch");
							System.out.println("Enter the Batch ID");
							String b_id = sc.next();
							bat.setBatch_id(b_id);
							System.out.println("Enter the Course ID");
							String c_id = sc.next();
							bat.setCourse_id(c_id);
							System.out.println("Enter the Faculty ID if yu donot want to add faculty now write null");
							sc.nextLine();
							String f_id = sc.nextLine();
							bat.setFaculty_id(f_id);
							System.out.println("Enter the Number of Students in batch");
							int students = sc.nextInt();
							bat.setNumber_of_students(students);
							System.out.println("Enter the batch start date");
							String date = sc.next();
							bat.setBatch_start_date(LocalDate.parse(date));
							System.out.println("Enter the duratioon of the batch");
							int dur = sc.nextInt();
							bat.setDuration(dur);
							ao.createBatch(bat);
						}
						else if(choice2 == 2) {
							Batch bat = new BatchImpl();
							System.out.println("Enter the details of the Batch to be updated");
							System.out.println("Enter the Batch ID");
							String b_id = sc.next();
							bat.setBatch_id(b_id);
							System.out.println("Enter the Course ID");
							String c_id = sc.next();
							bat.setCourse_id(c_id);
							System.out.println("Enter the Faculty ID");
							sc.nextLine();
							String f_id = sc.nextLine();
							bat.setFaculty_id(f_id);
							System.out.println("Enter the Number of Students in batch");
							int students = sc.nextInt();
							bat.setNumber_of_students(students);
							System.out.println("Enter the batch start date");
							String date = sc.next();
							bat.setBatch_start_date(LocalDate.parse(date));
							System.out.println("Enter the duratioon of the batch");
							int dur = sc.nextInt();
							bat.setDuration(dur);
							ao.updateBatch(bat);
						}
						else if(choice2 == 3) {
							System.out.println(ao.viewAllBatches());
						}
						else if(choice2 == 4) {
							System.out.println("Enter the Batch Id to see their details");
							String b_id = sc.next();
							System.out.println(ao.viewBatch(b_id));
						}
						else if(choice2 == 5) {
							System.out.println("Enter the Batch Id to which faculty has to be allocated");
							String b_id = sc.next();
							System.out.println("Enter the faculty Id");
							String f_id = sc.next();
							ao.allocateFacultytoBatch(b_id, f_id);
						}
						else if(choice2 == 0) {
							System.out.println("Going back to admin operations");
						}
						else {
							System.err.println("Choose from one of the above options");
						}
					}
					
					else if(choice1 == 4) {
						System.out.println("Enter 1 to create a CoursePlan");
						System.out.println("Enter 2 to update a CoursePlan");
						System.out.println("Enter 3 to see details of all CoursePlans");
						System.out.println("Enter 4 to see details of a particular CoursePlan");
						System.out.println("Enter 5 to see the daywise update of a batch");
						System.out.println("Enter 0 to exit");
						int choice2 = sc.nextInt();
						if(choice2 == 1) {
							CoursePlan cp = new CoursePlanImpl();
							System.out.println("Enter the details of the CoursePlan");
							System.out.println("Enter the Course Plan ID");
							String cp_id = sc.next();
							cp.setPlan_id(cp_id);
							System.out.println("Enter the Batch ID");
							String b_id = sc.next();
							cp.setBatch_id(b_id);
							System.out.println("Enter the day number of the plan");
							int day = sc.nextInt();
							cp.setDaynumber(day);
							System.out.println("The topic has to be specified by faculty so kindly provide null");
							String topic = sc.next();
							cp.setTopic(topic);
							System.out.println("Enter the status for that day");
							sc.nextLine();
							String status = sc.nextLine();
							cp.setStatus(status);
							ao.createCoursePlan(cp);
						}
						else if(choice2 == 2) {
							CoursePlan cp = new CoursePlanImpl();
							System.out.println("Enter the details of the CoursePlan to be updated");
							System.out.println("Enter the Course Plan ID");
							String cp_id = sc.next();
							cp.setPlan_id(cp_id);
							System.out.println("Enter the Batch ID");
							String b_id = sc.next();
							cp.setBatch_id(b_id);
							System.out.println("Enter the day number of the plan");
							int day = sc.nextInt();
							cp.setDaynumber(day);
							System.out.println("The topic has to be specified by faculty so kindly provide null");
							String topic = sc.next();
							cp.setTopic(topic);
							System.out.println("Enter the status for that day");
							sc.nextLine();
							String status = sc.nextLine();
							cp.setStatus(status);
							ao.updateCourselan(cp);
						}
						else if(choice2 == 3) {
							System.out.println(ao.viewAllCoursePlan());
						}
						else if(choice2 == 4) {
							System.out.println("Enter the Plan Id to see their details");
							String cp_id = sc.next();
							System.out.println(ao.viewCoursePlan(cp_id));
						}
						else if(choice2 == 5) {
							System.out.println("Enter the Batch Id to see the plans for that particular batch");
							String b_id = sc.next();
							System.out.println(ao.viewDayWisePlan(b_id)); 
						}
						else if(choice2 == 0) {
							System.out.println("Going back to admin operations");
						}
					}
					else if(choice1 == 0) {
						System.out.println("Thankyou for using our services! \n Taking back to main page");
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



