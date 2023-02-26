package courseplanner.dto;

public class FacultyImpl implements Faculty{

	
	private String faculty_id;
	private String faculty_name;
	private String faculty_address;
	private String faculty_mobileno;
	private String faculty_email;
	private String faculty_username;
	private String faculty_password;
	
	
	public FacultyImpl() {
		
	}
	
	public FacultyImpl(String faculty_id, String faculty_name, String faculty_address, String faculty_mobileno,
			String faculty_email, String faculty_username, String faculty_password) {
		this.faculty_id = faculty_id;
		this.faculty_name = faculty_name;
		this.faculty_address = faculty_address;
		this.faculty_mobileno = faculty_mobileno;
		this.faculty_email = faculty_email;
		this.faculty_username = faculty_username;
		this.faculty_password = faculty_password;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getFaculty_address() {
		return faculty_address;
	}

	public void setFaculty_address(String faculty_address) {
		this.faculty_address = faculty_address;
	}

	public String getFaculty_mobileno() {
		return faculty_mobileno;
	}

	public void setFaculty_mobileno(String faculty_mobileno) {
		this.faculty_mobileno = faculty_mobileno;
	}

	public String getFaculty_email() {
		return faculty_email;
	}

	public void setFaculty_email(String faculty_email) {
		this.faculty_email = faculty_email;
	}

	public String getFaculty_username() {
		return faculty_username;
	}

	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}

	public String getFaculty_password() {
		return faculty_password;
	}

	public void setFaculty_password(String faculty_password) {
		this.faculty_password = faculty_password;
	}

	@Override
	public String toString() {
		return "faculty_id=" + faculty_id + ", name=" + faculty_name + ", address="
				+ faculty_address + ", mobileno=" + faculty_mobileno + ", email=" + faculty_email
				+ ", username=" + faculty_username + ", password=" + faculty_password + "\n";
	}
	
	
	

}
