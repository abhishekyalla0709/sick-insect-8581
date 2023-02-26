package courseplanner.dao;

import java.util.List;

import courseplanner.dto.CoursePlan;
import exceptions.SomethingWentWrong;

public interface FacultyOperations {

	
	boolean facultyLogin(String username, String password) throws SomethingWentWrong;
	
	List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong;
	
	void fillDayWisePlanner(String courseplanner_id, int dayno, String topic, String status) throws SomethingWentWrong;
	
	void updateLoginCredentials(String fac_id, String old_username, String old_password, String new_username, String new_password) throws SomethingWentWrong;

}
