package com.object;

public class UserRateAVGObject {
	private String user_id;
	private float user_rate_avg;
	private int user_rate_total;

	public UserRateAVGObject(String user_id, float user_rate_avg, int user_rate_total) {
		this.user_id = user_id;
		this.user_rate_avg = user_rate_avg;
		this.user_rate_total = user_rate_total;
	}

	public UserRateAVGObject() {
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public float getUser_rate_avg() {
		return user_rate_avg;
	}

	public void setUser_rate_avg(float user_rate_avg) {
		this.user_rate_avg = user_rate_avg;
	}

	public int getUser_rate_total() {
		return user_rate_total;
	}

	public void setUser_rate_total(int user_rate_total) {
		this.user_rate_total = user_rate_total;
	}

}
