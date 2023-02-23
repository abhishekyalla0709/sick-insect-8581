package courseplanner.dto;

import java.time.LocalDate;

public class BatchImpl implements Batch{
	
	private String batch_id;
	private String course_id;
	private String faculty_id;
	private int number_of_students;
	private LocalDate batch_start_date;
	private int duration;
	
	public BatchImpl() {
		
	}
	
	public BatchImpl(String batch_id, String course_id, String faculty_id, int number_of_students, LocalDate batch_start_date,
			int duration) {
		this.batch_id = batch_id;
		this.course_id = course_id;
		this.faculty_id = faculty_id;
		this.number_of_students = number_of_students;
		this.batch_start_date = batch_start_date;
		this.duration = duration;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public int getNumber_of_students() {
		return number_of_students;
	}

	public void setNumber_of_students(int number_of_students) {
		this.number_of_students = number_of_students;
	}

	public LocalDate getBatch_start_date() {
		return batch_start_date;
	}

	public void setBatch_start_date(LocalDate batch_start_date) {
		this.batch_start_date = batch_start_date;
	}

	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}
	

}
