package courseplanner.dao;

import java.util.List;

import courseplanner.dto.Course;
import exceptions.CourseException;
import exceptions.SomethingWentWrong;

public interface AdminCourseOperations {
	public void createCourse(Course course) throws SomethingWentWrong, CourseException;
	
	public void updateCourse(Course course) throws SomethingWentWrong, CourseException;
	
	public List<Course> viewAllCourses() throws SomethingWentWrong, CourseException;
	
	public List<Course> viewCourse(String course_id) throws SomethingWentWrong, CourseException;
}
