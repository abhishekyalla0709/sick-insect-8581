package courseplanner.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import courseplanner.dto.Batch;
import courseplanner.dto.BatchImpl;
import courseplanner.dto.Course;
import courseplanner.dto.CourseImpl;
import courseplanner.dto.CoursePlan;
import courseplanner.dto.CoursePlanImpl;
import courseplanner.dto.Faculty;
import courseplanner.dto.FacultyImpl;
import exceptions.SomethingWentWrong;

public class AdminOperationsImpl implements AdminOperations {

	@Override
	public boolean adminLogin(String username, String password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		ResourceBundle bundle = ResourceBundle.getBundle("adminlogindetails");
		//System.out.println(bundle.getString("username") + " " + bundle.getString("password"));
		if(username.equals(bundle.getString("username")) && password.equals(bundle.getString("password"))) {
			System.out.println("login succesfull");
			//now connect this with the Admin operations
			return true;
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
	public List<Course> viewAllCourses() throws SomethingWentWrong {
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
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public List<Course> viewCourse(String course_id) throws SomethingWentWrong {
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
			if(list == null) {
				throw new SomethingWentWrong("You may have entered an invalid course_id.\nPlease try again");
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
	public void createBatch(Batch batch) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		//creating connection to database
		
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "INSERT INTO Batch (batch_id, course_id, number_of_students, batch_start_date, duration) values (?,?,?,?,?)";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, batch.getBatch_id());
			ps.setString(2, batch.getCourse_id());
			ps.setInt(3, batch.getNumber_of_students());
			ps.setDate(4,Date.valueOf(batch.getBatch_start_date()));
			ps.setInt(5, batch.getDuration());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Batch successfully added!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while adding the Batch");
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
	public void updateBatch(Batch batch) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE Batch set course_id = ?, faculty_id = ?, number_of_students = ?, batch_start_date = ?, duration = ? where batch_id = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(6, batch.getBatch_id());
			ps.setString(1, batch.getCourse_id());
			ps.setString(2, batch.getFaculty_id());
			ps.setInt(3, batch.getNumber_of_students());
			ps.setDate(4,Date.valueOf(batch.getBatch_start_date()));
			ps.setInt(5, batch.getDuration());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Batch successfully updated!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while updating the Batch");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}	
	}

	
	private List<Batch> ListofBatches(ResultSet rs) throws SQLException{
		List<Batch> list = new ArrayList<>();
		if(resultSetStatus(rs)) {
			while(rs.next()) {
				Batch batch = new BatchImpl();
				batch.setBatch_id(rs.getString("batch_id"));
				batch.setCourse_id(rs.getString("course_id"));
				batch.setFaculty_id(rs.getString("faculty_id"));
				batch.setNumber_of_students(rs.getInt("number_of_students"));
				batch.setBatch_start_date(rs.getDate("batch_start_date").toLocalDate());
				batch.setDuration(rs.getInt("duration"));
				list.add(batch);
			}
		}
		
		return list;
	}
	@Override
	public List<Batch> viewAllBatches() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Batch> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Batch";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofBatches(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public List<Batch> viewBatch(String batch_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Batch> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Batch where batch_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, batch_id);
			ResultSet rs = ps.executeQuery();
			list = ListofBatches(rs);
			if(list == null) {
				throw new SomethingWentWrong("You may have entered incorrect batchid");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public void createFaculty(Faculty faculty) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		//creating connection to database
		
			Connection conn = null;
			int r = 0;
			try {
				conn = DBUtils.getConnection();
				
				// prepare the query
				String query = "INSERT INTO Faculty (faculty_id, faculty_name, faculty_address, faculty_mobileno, faculty_email, faculty_username, faculty_password) values (?,?,?,?,?,?,?)";
				
				//pass the query
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, faculty.getFaculty_id());
				ps.setString(2, faculty.getFaculty_name());
				ps.setString(3, faculty.getFaculty_address());
				ps.setString(4, faculty.getFaculty_mobileno());
				ps.setString(5, faculty.getFaculty_email());
				ps.setString(6, faculty.getFaculty_username());
				ps.setString(7, faculty.getFaculty_password());
				r = ps.executeUpdate();
				if(r > 0) {
					System.out.println("Faculty successfully added!");
				}
				else {
					throw new SomethingWentWrong("An error occurd while adding the Faculty");
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
	public void updateFaculty(Faculty faculty) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		//creating connection to database
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE Faculty set faculty_name=?, faculty_address=?, faculty_mobileno=?, faculty_email=?, faculty_username=?, faculty_password=? where faculty_id = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(7, faculty.getFaculty_id());
			ps.setString(1, faculty.getFaculty_name());
			ps.setString(2, faculty.getFaculty_address());
			ps.setString(3, faculty.getFaculty_mobileno());
			ps.setString(4, faculty.getFaculty_email());
			ps.setString(5, faculty.getFaculty_username());
			ps.setString(6, faculty.getFaculty_password());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Faculty details successfully updated!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while updating the faculty details");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
	}

	private List<Faculty> ListofFaculties(ResultSet rs) throws SQLException{
		List<Faculty> list = new ArrayList<>();
		if(resultSetStatus(rs)) {
			while(rs.next()) {
				Faculty faculty = new FacultyImpl();
				faculty.setFaculty_id(rs.getString("faculty_id"));
				faculty.setFaculty_name(rs.getString("faculty_name"));
				faculty.setFaculty_address(rs.getString("faculty_address"));
				faculty.setFaculty_mobileno(rs.getString("faculty_mobileno"));
				faculty.setFaculty_email(rs.getString("faculty_email"));
				faculty.setFaculty_username(rs.getString("faculty_username"));
				faculty.setFaculty_password(rs.getString("faculty_password"));
				list.add(faculty);
			}
		}
		
		return list;
	}
	
	@Override
	public List<Faculty> viewAllFaculty() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Faculty> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Faculty";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofFaculties(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public List<Faculty> viewFaculty(String faculty_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Faculty> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Faculty where faculty_id=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, faculty_id);
			
			ResultSet rs = ps.executeQuery();
			list = ListofFaculties(rs);
			if(list == null) {
				throw new SomethingWentWrong("You may have entered an invalid faculty_id.\nPlease try again");
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
	public void allocateFacultytoBatch(String batch_id, String faculty_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE Batch set faculty_id = ? where batch_id = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,faculty_id);
			ps.setString(2, batch_id);
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Faculty is assigned to the batch!");
			}
			else {
				throw new SomethingWentWrong("An error occurd while assigning the faculty to the batch");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
	}

//	@Override
//	public void createCoursePlan(CoursePlan courseplan) throws SomethingWentWrong {
//		// TODO Auto-generated method stub
//		//creating connection to database
//
//		Connection conn = null;
//		int r = 0;
//		try {
//			conn = DBUtils.getConnection();
//			
//			// prepare the query
//			String query = "INSERT INTO CoursePlan (plan_id, batch_id, dayNumber, topic, status) values (?,?,?,?,?)";
//			
//			//pass the query
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ps.setString(1, courseplan.getPlan_id());
//			ps.setString(2, courseplan.getBatch_id());
//			ps.setInt(3, courseplan.getDaynumber());
//			ps.setString(4,courseplan.getTopic());
//			ps.setString(5, courseplan.getStatus());
//			
//			r = ps.executeUpdate();
//			if(r > 0) {
//				System.out.println("courseplan successfully added!");
//			}
//			else {
//				throw new SomethingWentWrong("An error occured while adding the courseplan");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.closeConnection(conn);
//		}	
//		
//	}
//
//	@Override
//	public void updateCourselan(CoursePlan courseplan) throws SomethingWentWrong {
//		// TODO Auto-generated method stub
//		Connection conn = null;
//		int r = 0;
//		try {
//			conn = DBUtils.getConnection();
//			
//			// prepare the query
//			String query = "UPDATE CoursePlan set batch_id=?, dayNumber=?, topic=?, status=? where plan_id = ?";
//			
//			//pass the query
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ps.setString(5, courseplan.getPlan_id());
//			ps.setString(1, courseplan.getBatch_id());
//			ps.setInt(2, courseplan.getDaynumber());
//			ps.setString(3,courseplan.getTopic());
//			ps.setString(4, courseplan.getStatus());
//			
//			r = ps.executeUpdate();
//			if(r > 0) {
//				System.out.println("courseplan successfully updated!");
//			}
//			else {
//				throw new SomethingWentWrong("An error occured while updating the courseplan");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DBUtils.closeConnection(conn);
//		}
//	}
//
//	private List<CoursePlan> ListofCoursePlan(ResultSet rs) throws SQLException{
//		List<CoursePlan> list = new ArrayList<>();
//		if(resultSetStatus(rs)) {
//			while(rs.next()) {
//				CoursePlan cp = new CoursePlanImpl();
//				cp.setPlan_id(rs.getString("plan_id"));
//				cp.setBatch_id(rs.getString("batch_id"));
//				cp.setDaynumber(rs.getInt("dayNumber"));
//				cp.setTopic(rs.getString("batch"));
//				cp.setStatus(rs.getString("status"));
//				list.add(cp);
//			}
//		}
//		
//		return list;
//	}
//	
//	@Override
//	public List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong {
//		// TODO Auto-generated method stub
//		List<CoursePlan> list = null;
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			// now make the query
//			String query = "SELECT * from CoursePlan";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ResultSet rs = ps.executeQuery();
//			list = ListofCoursePlan(rs);
//			if(list == null) {
//				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
//			}
//		}
//		catch (SQLException ex){
//			throw new SomethingWentWrong();
//		}
//		finally {
//			DBUtils.closeConnection(conn);
//		}
//		
//		return list;
//	}
//
//	@Override
//	public List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong {
//		// TODO Auto-generated method stub
//		List<CoursePlan> list = null;
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			// now make the query
//			String query = "SELECT * from CoursePlan where plan_id = ?";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, courseplan_id);
//			
//			ResultSet rs = ps.executeQuery();
//			list = ListofCoursePlan(rs);
//			if(list == null) {
//				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
//			}
//		}
//		catch (SQLException ex){
//			throw new SomethingWentWrong();
//		}
//		finally {
//			DBUtils.closeConnection(conn);
//		}
//		return list;
//	}
//
//	@Override
//	public List<CoursePlan> viewDayWisePlan(String batch_id) throws SomethingWentWrong {
//		// TODO Auto-generated method stub
//		List<CoursePlan> list = null;
//		Connection conn = null;
//		try {
//			conn = DBUtils.getConnection();
//			// now make the query
//			String query = "SELECT * from CoursePlan where batch_id = ?";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, batch_id);
//			
//			ResultSet rs = ps.executeQuery();
//			list = ListofCoursePlan(rs);
//			if(list == null) {
//				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
//			}
//		}
//		catch (SQLException ex){
//			throw new SomethingWentWrong("Batch Not Found!");
//		}
//		finally {
//			DBUtils.closeConnection(conn);
//		}
//		
//		return list;
//	}

	@Override
	public List<Batch> generateReportofEveryBatch() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<Batch> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Batch";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofBatches(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		
		return list;
	}

	@Override
	public void createCoursePlan(CoursePlan courseplan) throws SomethingWentWrong {
		// TODO Auto-generated method stub

		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "INSERT INTO CoursePlan (plan_id, batch_id, dayNumber, topic, status) values (?,?,?,?,?)";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, courseplan.getPlan_id());
			ps.setString(2, courseplan.getBatch_id());
			ps.setInt(3, courseplan.getDaynumber());
			ps.setString(4,courseplan.getTopic());
			ps.setString(5, courseplan.getStatus());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("courseplan successfully added!");
			}
			else {
				throw new SomethingWentWrong("An error occured while adding the courseplan");
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
	public void updateCourselan(CoursePlan courseplan) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE CoursePlan set batch_id=?, dayNumber=?, topic=?, status=? where plan_id = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(5, courseplan.getPlan_id());
			ps.setString(1, courseplan.getBatch_id());
			ps.setInt(2, courseplan.getDaynumber());
			ps.setString(3,courseplan.getTopic());
			ps.setString(4, courseplan.getStatus());
			
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("courseplan successfully updated!");
			}
			else {
				throw new SomethingWentWrong("An error occured while updating the courseplan");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}

	}

	private List<CoursePlan> ListofCoursePlan(ResultSet rs) throws SQLException{
		List<CoursePlan> list = new ArrayList<>();
		if(resultSetStatus(rs)) {
			while(rs.next()) {
				CoursePlan cp = new CoursePlanImpl();
				cp.setPlan_id(rs.getString("plan_id"));
				cp.setBatch_id(rs.getString("batch_id"));
				cp.setDaynumber(rs.getInt("dayNumber"));
				cp.setTopic(rs.getString("topic"));
				cp.setStatus(rs.getString("status"));
				list.add(cp);
			}
		}
		
		return list;
	}
	
	@Override
	public List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<CoursePlan> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from CoursePlan";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofCoursePlan(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	

	@Override
	public List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<CoursePlan> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from CoursePlan where plan_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, courseplan_id);
			
			ResultSet rs = ps.executeQuery();
			list = ListofCoursePlan(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}


	@Override
	public List<CoursePlan> viewDayWisePlan(String batch_id) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		List<CoursePlan> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from CoursePlan where batch_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, batch_id);
			
			ResultSet rs = ps.executeQuery();
			list = ListofCoursePlan(rs);
			if(list == null) {
				throw new SomethingWentWrong("Something went wrong!.\nPlease try again");
			}
		}
		catch (SQLException ex){
			throw new SomethingWentWrong();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
		return list;
	}	
		

}
