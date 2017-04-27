package com.object;

public class ProductSuggestObject {
	private int product_id;
	private float USER_KNN;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public float getUSER_KNN() {
		return USER_KNN;
	}

	public void setUSER_KNN(float uSER_KNN) {
		USER_KNN = uSER_KNN;
	}

	public ProductSuggestObject(int product_id, float uSER_KNN) {
		super();
		this.product_id = product_id;
		USER_KNN = uSER_KNN;
	}

	public ProductSuggestObject() {
		super();
	}

}
