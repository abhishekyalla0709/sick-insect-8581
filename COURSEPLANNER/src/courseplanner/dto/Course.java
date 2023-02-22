package courseplanner.dto;

public interface Course {
	
	/**
	 * 
	 * @return it returns courseId (String)
	 */
	public String getCourse_id();
	
	/**
	 * It helps us in setting the course_id
	 * @param course_id
	 */
	public void setCourse_id(String course_id);

	/**
	 * 
	 * @return it returns the course_name (String)
	 */
	public String getCourse_name();

	/**
	 * It helps us in setting the course_name
	 * @param course_name
	 */
	public void setCourse_name(String course_name);

	/**
	 * 
	 * @return It returns the course fee (double)
	 */
	public double getCourse_fee();

	/**
	 * It helps in setting the course fee
	 * @param course_fee
	 */
	public void setCourse_fee(double course_fee);

	/**
	 * 
	 * @return it returns the description f the course (String)
	 */
	public String getCourse_des();

	/**
	 * It helps us in setting the description of course
	 * @param course_des
	 */
	public void setCourse_des(String course_des);
	
	
}
