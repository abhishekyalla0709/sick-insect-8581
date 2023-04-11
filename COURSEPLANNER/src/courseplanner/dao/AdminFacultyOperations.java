package courseplanner.dao;

import java.util.List;

import courseplanner.dto.Faculty;
import exceptions.FacultyException;
import exceptions.SomethingWentWrong;

public interface AdminFacultyOperations {

    public void createFaculty(Faculty faculty) throws SomethingWentWrong, FacultyException;
	
	public void updateFaculty(Faculty faculty) throws SomethingWentWrong, FacultyException;
	
	public List<Faculty> viewAllFaculty() throws SomethingWentWrong, FacultyException;
	
	public List<Faculty> viewFaculty(String faculty_id) throws SomethingWentWrong, FacultyException;
	
}
