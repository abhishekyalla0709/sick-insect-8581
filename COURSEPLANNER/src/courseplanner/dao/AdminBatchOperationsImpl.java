package courseplanner.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import courseplanner.dto.Batch;
import courseplanner.dto.BatchImpl;
import exceptions.BatchException;
import exceptions.FacultyException;
import exceptions.SomethingWentWrong;

public class AdminBatchOperationsImpl implements AdminBatchOperations{

	@Override
	public void createBatch(Batch batch) throws SomethingWentWrong, BatchException {
		// TODO Auto-generated method stub
		//creating connection to database
		
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			List<Batch> list = null;
				// now make the query
			String query1 = "SELECT * from Batch where batch_id=?";
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, batch.getBatch_id());
			ResultSet rs = ps1.executeQuery();
			list = ListofBatches(rs);
			if(list.size() != 0) {
				throw new BatchException("Batch with batchid "  + batch.getBatch_id() + " already exists!");
			}
			
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
	public void updateBatch(Batch batch) throws SomethingWentWrong, BatchException {
		// TODO Auto-generated method stub
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			List<Batch> list = null;
			// now make the query
		String query1 = "SELECT * from Batch where batch_id=?";
		
		PreparedStatement ps1 = conn.prepareStatement(query1);
		ps1.setString(1, batch.getBatch_id());
		ResultSet rs = ps1.executeQuery();
		list = ListofBatches(rs);
		if(list.size() == 0) {
			throw new BatchException("Batch with batchid "  + batch.getBatch_id() + " not found!");
		}
			
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
				throw new SomethingWentWrong("An error occured while updating the Batch");
			}
		} catch (SQLException e) {
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
	
	//method to check whether result set is empty or not
		private boolean resultSetStatus(ResultSet rs) throws SQLException {
			if(!rs.isBeforeFirst() && rs.getRow() == 0) {
				return false;
			}
			return true;
		}

	@Override
	public List<Batch> viewAllBatches() throws SomethingWentWrong, BatchException {
		List<Batch> list = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			// now make the query
			String query = "SELECT * from Batch";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			list = ListofBatches(rs);
			if(list.size() == 0) {
				throw new BatchException("no batch found");
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
	public List<Batch> viewBatch(String batch_id) throws SomethingWentWrong, BatchException {
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
			if(list.size() == 0) {
				throw new BatchException("No batch found for id " + batch_id);
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
	public void allocateFacultytoBatch(String batch_id, String faculty_id)
			throws SomethingWentWrong, BatchException, FacultyException {
		Connection conn = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			
		List<Batch> list = null;
			// now make the query
		String query1 = "SELECT * from Batch where batch_id=?";
		
		PreparedStatement ps1 = conn.prepareStatement(query1);
		ps1.setString(1, batch_id);
		ResultSet rs = ps1.executeQuery();
		list = ListofBatches(rs);
		if(list.size() == 0) {
			throw new BatchException("Batch with batchid "  + batch_id + " not found!");
		}
		
		String query2 = "SELECT * from faculty where faculty_id = ?";
		
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setString(1, faculty_id);
		ResultSet rs2 = ps2.executeQuery();
		if(rs2 == null) {
			throw new FacultyException("No faculty found for the given id :" + faculty_id);
		}
			
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

}








