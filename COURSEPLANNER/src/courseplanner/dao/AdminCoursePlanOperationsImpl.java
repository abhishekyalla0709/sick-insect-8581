package courseplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import courseplanner.dto.CoursePlan;
import courseplanner.dto.CoursePlanImpl;
import exceptions.BatchException;
import exceptions.CourseException;
import exceptions.CoursePlanException;
import exceptions.SomethingWentWrong;

public class AdminCoursePlanOperationsImpl implements AdminCoursePlanOperations{

	@Override
	public void createCoursePlan(CoursePlan courseplan)
			throws SomethingWentWrong, CoursePlanException, BatchException, CourseException {
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
	public void updateCourselan(CoursePlan courseplan)
			throws SomethingWentWrong, CoursePlanException, BatchException, CourseException {
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

	//method to check whether result set is empty or not
		private boolean resultSetStatus(ResultSet rs) throws SQLException {
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				return false;
			}
			return true;
		}

	@Override
	public List<CoursePlan> viewAllCoursePlan() throws SomethingWentWrong, CoursePlanException {
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
	public List<CoursePlan> viewCoursePlan(String courseplan_id) throws SomethingWentWrong, CoursePlanException {
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
	public List<CoursePlan> viewDayWisePlan(String batch_id) throws SomethingWentWrong, BatchException {
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
