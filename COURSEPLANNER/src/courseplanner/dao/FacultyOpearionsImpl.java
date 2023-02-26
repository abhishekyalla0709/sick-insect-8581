package courseplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courseplanner.dto.CoursePlan;
import courseplanner.dto.CoursePlanImpl;
import courseplanner.dto.Faculty;
import courseplanner.dto.FacultyImpl;
import exceptions.SomethingWentWrong;

public class FacultyOpearionsImpl implements FacultyOperations {

	@Override
	public boolean facultyLogin(String username, String password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "SELECT * from faculty where faculty_username = ? && faculty_password = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst() && rs.getRow() == 0) {
				System.out.println("Login Successful!");
				return true;
			}
			else {
				throw new SomethingWentWrong("Incorrect credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}

		return false;
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
	
	private boolean resultSetStatus(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow() == 0) {
			return false;
		}
		return true;
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
	public void fillDayWisePlanner(String courseplanner_id, int dayno, String topic, String status) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE CoursePlan set topic=?, status=? where plan_id = ? && dayNumber = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, topic);
			ps.setString(2, status);
			ps.setString(3,courseplanner_id);
			ps.setInt(4, dayno);
			
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

	@Override
	public void updateLoginCredentials(String fac_id, String old_username, String old_password, String new_username,
			String new_password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
			// prepare the query
			String query = "UPDATE Faculty set faculty_username=?, faculty_password = ? where faculty_id = ? && faculty_username = ? && faculty_password = ?";
			
			//pass the query
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, new_username);
			ps.setString(2, new_password);
			ps.setString(3, fac_id);
			ps.setString(4, old_username);
			ps.setString(5, old_password);
			r = ps.executeUpdate();
			if(r > 0) {
				System.out.println("Login credentials successfully updated!");
			}
			else {
				throw new SomethingWentWrong("An error occured while updating the login credentials");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(conn);
		}
	
	}

	

}
