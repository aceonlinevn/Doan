package com.object;

public class UserRateObject {
	private String user_id;
	private int product_id, user_rate_point;
	private String user_rate_comment;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_rate_point() {
		return user_rate_point;
	}

	public void setUser_rate_point(int user_rate_point) {
		this.user_rate_point = user_rate_point;
	}

	public String getUser_rate_comment() {
		return user_rate_comment;
	}

	public void setUser_rate_comment(String user_rate_comment) {
		this.user_rate_comment = user_rate_comment;
	}

	public UserRateObject() {
		super();
	}

	public UserRateObject(String user_id, int product_id, int user_rate_point, String user_rate_comment) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.user_rate_point = user_rate_point;
		this.user_rate_comment = user_rate_comment;
	}

}
