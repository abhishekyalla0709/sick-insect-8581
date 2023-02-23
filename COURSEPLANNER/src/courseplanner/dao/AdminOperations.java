package courseplanner.dao;

import java.util.List;

import courseplanner.dto.Batch;
import courseplanner.dto.Course;
import courseplanner.dto.CoursePlan;
import courseplanner.dto.Faculty;
import exceptions.SomethingWentWrong;

public interface AdminOperations {
	
	//list of operations that has to be performed by admin
	
	boolean adminLogin(String username, String password) throws SomethingWentWrong;
	
	void createCourse(Course course) throws SomethingWentWrong;
	
	void updateCourse(Course course) throws SomethingWentWrong;
	
	List<Course> viewAllCourses() throws SomethingWentWrong;
	
	List<Course> viewCourse(String course_id) throws SomethingWentWrong;
	
	void createBatch(Batch batch) throws SomethingWentWrong;
	
	void updateBatch(Batch batch) throws SomethingWentWrong;
	
	List<Batch> viewAllBatches() throws SomethingWentWrong;
	
	List<Batch> viewBatch(String batch_id) throws SomethingWentWrong;
	
	void createFaculty(Faculty faculty) throws SomethingWentWrong;
	
	void updateFaculty(Faculty faculty) throws SomethingWentWrong;
	
	List<Faculty> viewAllFaculty() throws SomethingWentWrong;
	
	List<Faculty> viewFaculty(String faculty_id) throws SomethingWentWrong;
	
	void allocateFacultytoBatch(String batch_id, String faculty_id) throws SomethingWentWrong;
	
	void createCoursePlan(CoursePlan courseplan) throws SomethingWentWrong;
	
	void updateCourselan(CoursePlan courseplan) throws SomethingWentWrong;
	
	List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong;
	
	List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong;
	
	List<CoursePlan> viewDayWisePlan(String courseplan_id) throws SomethingWentWrong;
	
	List<Batch> generateReportofEveryBatch() throws SomethingWentWrong;

//	Create, Update, View Batch. A batch is related to a course. 
//	Create, Update, View Faculty.
//	Allocate faculty to a batch.
//	Create, Update, View Course plan.
//	View the Day wise update of every batch.
//	 Generate Report for every batch.

}
