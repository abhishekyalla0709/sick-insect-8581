package courseplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import courseplanner.dto.Batch;
import courseplanner.dto.Course;
import courseplanner.dto.CoursePlan;
import courseplanner.dto.Faculty;
import exceptions.SomethingWentWrong;

public class AdminOperationsImpl implements AdminOperations {

	@Override
	public void adminLogin(String username, String password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("adminlogindetails");
		System.out.println(bundle.getString("username") + " " + bundle.getString("password"));
		if(username.equals(bundle.getString("username")) && password.equals(bundle.getString("password"))) {
			System.out.println("login succesfull");
			//now connect this with the Admin operations
		}
		else {
			throw new SomethingWentWrong("Invalid Credentials");
		}
	}

	@Override
	public void createCourse(Course course) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		//creating connection to database
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
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
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}

	}

	@Override
	public void updateCourse(Course course) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		//creating connection to database
				Connection conn = null;
				int r = 0;
				try {
					conn = DBUtils.getConnection();
					
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
					e.printStackTrace();
				}
				finally {
					DBUtils.closeConnection(conn);
				}
	}

	@Override
	public List<Course> viewAllCourses() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewCourse(String course_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBatch(Batch batch) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBatch(Batch batch) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Batch> viewAllBatches() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batch> viewBatch(String batch_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFaculty(Faculty faculty) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFaculty(Faculty faculty) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Faculty> viewAllFaculty() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> viewFaculty(String faculty_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allocateFacultytoBatch(String batch_id, String faculty_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCoursePlan(CoursePlan courseplan) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCourselan(CoursePlan courseplan) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoursePlan> viewDayWisePlan(String courseplan_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batch> generateReportofEveryBatch() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		return null;
	}

}
