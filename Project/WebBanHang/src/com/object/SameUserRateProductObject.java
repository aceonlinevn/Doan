package com.object;

public class SameUserRateProductObject {
	private int productid;

	public SameUserRateProductObject(int productid, String userid1, String userid2, int user1_rate, int user2_rate) {
		super();
		this.productid = productid;
		this.userid1 = userid1;
		this.userid2 = userid2;
		this.user1_rate = user1_rate;
		this.user2_rate = user2_rate;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	private String userid1, userid2;
	private int user1_rate, user2_rate;

	public String getUserid1() {
		return userid1;
	}

	public void setUserid1(String userid1) {
		this.userid1 = userid1;
	}

	public String getUserid2() {
		return userid2;
	}

	public void setUserid2(String userid2) {
		this.userid2 = userid2;
	}

	public int getUser1_rate() {
		return user1_rate;
	}

	public void setUser1_rate(int user1_rate) {
		this.user1_rate = user1_rate;
	}

	public int getUser2_rate() {
		return user2_rate;
	}

	public void setUser2_rate(int user2_rate) {
		this.user2_rate = user2_rate;
	}

	public SameUserRateProductObject() {
		super();
	}
	
	public String toString(){
		return productid + " " + userid1 + " " + userid2 + " " + user1_rate + " " +  user2_rate ;
	}

}
