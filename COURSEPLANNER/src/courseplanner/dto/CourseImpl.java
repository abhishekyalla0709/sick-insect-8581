package courseplanner.dto;

public class CourseImpl implements Course {
	
	private String course_id;
	private String course_name;
	private double course_fee;
	private String course_des;
	
	public CourseImpl() {
		
	}
	
	public CourseImpl(String course_id, String course_name, double course_fee, String course_des) {
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_fee = course_fee;
		this.course_des = course_des;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public double getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(double course_fee) {
		this.course_fee = course_fee;
	}

	public String getCourse_des() {
		return course_des;
	}

	public void setCourse_des(String course_des) {
		this.course_des = course_des;
	}
	

}
