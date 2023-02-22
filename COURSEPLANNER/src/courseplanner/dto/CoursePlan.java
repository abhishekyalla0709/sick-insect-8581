package courseplanner.dto;

public interface CoursePlan {

	public String getPlan_id();

	public void setPlan_id(String plan_id);

	public String getBatch_id();

	public void setBatch_id(String batch_id);

	public int getDaynumber();

	public void setDaynumber(int daynumber);

	public String getTopic();

	public void setTopic(String topic);

	public String getStatus();

	public void setStatus(String status);
}
