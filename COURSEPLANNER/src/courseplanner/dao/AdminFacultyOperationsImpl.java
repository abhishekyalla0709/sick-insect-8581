package courseplanner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import courseplanner.dto.Faculty;
import courseplanner.dto.FacultyImpl;
import exceptions.FacultyException;
import exceptions.SomethingWentWrong;

public class AdminFacultyOperationsImpl implements AdminFacultyOperations{

	@Override
	public void createFaculty(Faculty faculty) throws SomethingWentWrong, FacultyException {
		// TODO Auto-generated method stub
		//creating connection to database
			List<Faculty> list = null;
			Connection conn = null;
			int r = 0;
			try {
				conn = DBUtils.getConnection();
				String query1 = "SELECT * from Faculty where faculty_id=?";
				
				PreparedStatement ps1 = conn.prepareStatement(query1);
				ps1.setString(1, faculty.getFaculty_id());
				
				ResultSet rs = ps1.executeQuery();
				list = ListofFaculties(rs);
				if(list.size() != 0) {
					throw new FacultyException("There exists a faculty with id " + faculty.getFaculty_id() + "\nplease enter new id");
				}
				
				String x = "^[A-Za-z0-9+_.-]+@(.+)$";
				Pattern p1 = Pattern.compile(x);
				String y = "^[0-9]{10}";
				Pattern p2 = Pattern.compile(y);
				Matcher m1 = p1.matcher(faculty.getFaculty_email());
				Matcher m2 = p2.matcher(faculty.getFaculty_mobileno());
				if(m1.find()==false) {
					throw new FacultyException("Email should be in the proper format");
				}
				
				if(m2.find() == false) {
					throw new FacultyException("Phone number should be of only numbers and should be of 10 digits");
				}
				
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
			}
			finally {
				DBUtils.closeConnection(conn);
			}

	}

	@Override
	public void updateFaculty(Faculty faculty) throws SomethingWentWrong, FacultyException {
		// TODO Auto-generated method stub
		//creating connection to database
		Connection conn = null;
		List<Faculty> list = null;
		int r = 0;
		try {
			conn = DBUtils.getConnection();
			String query1 = "SELECT * from Faculty where faculty_id=?";
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, faculty.getFaculty_id());
			
			ResultSet rs = ps1.executeQuery();
			list = ListofFaculties(rs);
			if(list.size() == 0) {
				throw new FacultyException("No faculty found with id " + faculty.getFaculty_id());
			}
			
			String x = "^[A-Za-z0-9+_.-]+@(.+)$";
			Pattern p1 = Pattern.compile(x);
			String y = "^[0-9]{10}";
			Pattern p2 = Pattern.compile(y);
			Matcher m1 = p1.matcher(faculty.getFaculty_email());
			Matcher m2 = p2.matcher(faculty.getFaculty_mobileno());
			if(m1.find()==false) {
				throw new FacultyException("Email should be in the proper format");
			}
			
			if(m2.find() == false) {
				throw new FacultyException("Phone number should be of only numbers and should be of 10 digits");
			}
			
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
				throw new SomethingWentWrong("An error occured while updating the faculty details");
			}
		} catch (SQLException e) {
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
	
	//method to check whether result set is empty or not
			private boolean resultSetStatus(ResultSet rs) throws SQLException {
				if(!rs.isBeforeFirst() && rs.getRow() == 0) {
					return false;
				}
				return true;
			}

	@Override
	public List<Faculty> viewAllFaculty() throws SomethingWentWrong, FacultyException {
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
			if(list.size() == 0) {
				throw new FacultyException("Something went wrong!.\nPlease try again");
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
	public List<Faculty> viewFaculty(String faculty_id) throws SomethingWentWrong, FacultyException {
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
			if(list.size() == 0) {
				throw new FacultyException("You may have entered an invalid faculty_id.\nPlease try again");
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


