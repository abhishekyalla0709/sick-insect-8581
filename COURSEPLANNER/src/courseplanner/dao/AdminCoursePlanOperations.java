package courseplanner.dao;

import java.util.List;

import courseplanner.dto.Batch;
import courseplanner.dto.CoursePlan;
import exceptions.BatchException;
import exceptions.CourseException;
import exceptions.CoursePlanException;
import exceptions.SomethingWentWrong;

public interface AdminCoursePlanOperations {
	
    public void createCoursePlan(CoursePlan courseplan) throws SomethingWentWrong, CoursePlanException, BatchException, CourseException;
	
    public void updateCourselan(CoursePlan courseplan) throws SomethingWentWrong, CoursePlanException, BatchException, CourseException;
	
    public List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong, CoursePlanException;
	
    public List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong, CoursePlanException;
	
    public List<CoursePlan> viewDayWisePlan(String batch_id) throws SomethingWentWrong, BatchException;
	

}
