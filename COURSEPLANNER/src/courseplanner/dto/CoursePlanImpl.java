package courseplanner.dto;

public class CoursePlanImpl implements CoursePlan {
		
	private String plan_id;
	private String batch_id;
	private int daynumber;
	private String topic;
	private String status;
	
	public CoursePlanImpl() {
		
	}
	
	public CoursePlanImpl(String plan_id, String batch_id, int daynumber, String topic, String status) {
		super();
		this.plan_id = plan_id;
		this.batch_id = batch_id;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(String batch_id) {
		this.batch_id = batch_id;
	}

	public int getDaynumber() {
		return daynumber;
	}

	public void setDaynumber(int daynumber) {
		this.daynumber = daynumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
