package com.object;

public class UserRateAVGObject {
	private int rate_avg_id;
	private String user_id;
	private float user_rate_avg;

	public UserRateAVGObject(int rate_avg_id, String user_id, float user_rate_avg) {
		this.rate_avg_id = rate_avg_id;
		this.user_id = user_id;
		this.user_rate_avg = user_rate_avg;
	}

	public UserRateAVGObject() {
	}

	public int getRate_avg_id() {
		return rate_avg_id;
	}

	public void setRate_avg_id(int rate_avg_id) {
		this.rate_avg_id = rate_avg_id;
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

}
