package courseplanner.dto;

import java.time.LocalDate;

public interface Batch {
	
	public String getBatch_id();

	public void setBatch_id(String batch_id);

	public String getCourse_id();

	public void setCourse_id(String course_id);
	
	public String getFaculty_id();

	public void setFaculty_id(String faculty_id);

	public int getNumber_of_students();

	public void setNumber_of_students(int number_of_students);

	public LocalDate getBatch_start_date();

	public void setBatch_start_date(LocalDate batch_start_date);

	public int getDuration();

	public void setDuration(int duration);


}
