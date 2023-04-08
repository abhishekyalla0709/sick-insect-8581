package courseplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courseplanner.dto.Course;
import courseplanner.dto.CourseImpl;
import exceptions.CourseException;
import exceptions.SomethingWentWrong;

public class AdminCourseOpeartionsImpl implements AdminCourseOperations{

	@Override
	public void createCourse(Course course) throws SomethingWentWrong, CourseException {
		// TODO Auto-generated method stub
		//creating connection to database
		Connection conn = null;
		List<Course> list = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			
			String query1 = "SELECT * from Course where course_id=?";
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, course.getCourse_id());
			
			ResultSet rs = ps1.executeQuery();
			list = ListofCourses(rs);
			
			if(list.size() != 0) {
				throw new CourseException("Course already exist with id " + course.getCourse_id() + "\nenter a new course id");
			}
			
			// prepare the query
			String query = "INSERT INTO Course (course_id, course_name, course_fee, course_des) values (?,?,?,?)";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, course.getCourse_id());
			ps.setString(2, course.getCourse_name());
			ps.setDouble(3, course.getCourse_fee());
			ps.setString(4, course.getCourse_des());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Course successfully added!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while adding the course");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		finally {
			DBUtils.closeConnection(conn);
		}

		
	}

	@Override
	public void updateCourse(Course course) throws SomethingWentWrong, CourseException {
		// TODO Auto-generated method stub
		//creating connection to database
		Connection conn = null;
		List<Course> list = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			String query1 = "SELECT * from Course where course_id=?";
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, course.getCourse_id());
			
			ResultSet rs = ps1.executeQuery();
			list = ListofCourses(rs);
			if(list.size() == 0) {
				throw new CourseException("No course found with id " + course.getCourse_id() + "/nenter a valid course id");
			}
			
			// prepare the query
			String query = "UPDATE Course set course_name = ?,  course_fee = ?, course_des = ? where course_id = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(4, course.getCourse_id());
			ps.setString(1, course.getCourse_name());
			ps.setDouble(2, course.getCourse_fee());
			ps.setString(3, course.getCourse_des());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Course successfully updated!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while updating the course");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		finally {
			DBUtils.closeConnection(conn);
		}

		
	}
	
	private List<Course> ListofCourses(ResultSet rs) throws SQLException{
		List<Course> list = new ArrayList<>();
		if(resultSetStatus(rs)) {
			while(rs.next()) {
				Course course = new CourseImpl();
				course.setCourse_id(rs.getString("course_id"));
				course.setCourse_name(rs.getString("course_name"));
				course.setCourse_fee(rs.getDouble("course_fee"));
				course.setCourse_des(rs.getString("course_des"));
				list.add(course);
			}
		}
		
		return list;
	}


	//method to check whether result set is empty or not
	private boolean resultSetStatus(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			return false;
		}
		return true;
	}


	@Override
	public List<Course> viewAllCourses() throws SomethingWentWrong, CourseException {
		// TODO Auto-generated method stub
		List<Course> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Course";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofCourses(rs);
			if(list.size() == 0) {
				throw new CourseException("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public List<Course> viewCourse(String course_id) throws SomethingWentWrong, CourseException {
		// TODO Auto-generated method stub
		List<Course> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Course where course_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, course_id);
			
			ResultSet rs = ps.executeQuery();
			list = ListofCourses(rs);
			if(list.size() == 0) {
				throw new CourseException("You may have entered an invalid course_id.\nPlease try again");
			}
		}
		catch (SQLException ex){
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;

	}

}







