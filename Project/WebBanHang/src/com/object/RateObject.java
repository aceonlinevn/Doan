package com.object;

public class RateObject {
	private int rate_id,rate_product_id,rate_user_id;
	private Double rate_cost;
	public RateObject() {
		super();
	}
	public RateObject(int rate_id, int rate_product_id, int rate_user_id, Double rate_cost) {
		super();
		this.rate_id = rate_id;
		this.rate_product_id = rate_product_id;
		this.rate_user_id = rate_user_id;
		this.rate_cost = rate_cost;
	}
	public int getRate_id() {
		return rate_id;
	}
	public void setRate_id(int rate_id) {
		this.rate_id = rate_id;
	}
	public int getRate_product_id() {
		return rate_product_id;
	}
	public void setRate_product_id(int rate_product_id) {
		this.rate_product_id = rate_product_id;
	}
	public int getRate_user_id() {
		return rate_user_id;
	}
	public void setRate_user_id(int rate_user_id) {
		this.rate_user_id = rate_user_id;
	}
	public Double getRate_cost() {
		return rate_cost;
	}
	public void setRate_cost(Double rate_cost) {
		this.rate_cost = rate_cost;
	}
	
}
