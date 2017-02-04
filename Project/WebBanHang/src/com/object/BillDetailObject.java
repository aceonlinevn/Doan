package com.object;

public class BillDetailObject {
	private int bill_detail_id,bill_id;
	private int bill_detail_product_id;
	private int bill_detail_quantity;
	private int bill_detail_typeunitprice;
	private int bill_detail_discount;
	private double bill_detail_price;
	public BillDetailObject(int bill_detail_id, int bill_id, int bill_detail_product_id, int bill_detail_quantity,
			int bill_detail_typeunitprice, int bill_detail_discount, double bill_detail_price) {
		super();
		this.bill_detail_id = bill_detail_id;
		this.bill_id = bill_id;
		this.bill_detail_product_id = bill_detail_product_id;
		this.bill_detail_quantity = bill_detail_quantity;
		this.bill_detail_typeunitprice = bill_detail_typeunitprice;
		this.bill_detail_discount = bill_detail_discount;
		this.bill_detail_price = bill_detail_price;
	}
	public BillDetailObject() {
		super();
	}
	public int getBill_detail_id() {
		return bill_detail_id;
	}
	public void setBill_detail_id(int bill_detail_id) {
		this.bill_detail_id = bill_detail_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getBill_detail_product_id() {
		return bill_detail_product_id;
	}
	public void setBill_detail_product_id(int bill_detail_product_id) {
		this.bill_detail_product_id = bill_detail_product_id;
	}
	public int getBill_detail_quantity() {
		return bill_detail_quantity;
	}
	public void setBill_detail_quantity(int bill_detail_quantity) {
		this.bill_detail_quantity = bill_detail_quantity;
	}
	public int getBill_detail_typeunitprice() {
		return bill_detail_typeunitprice;
	}
	public void setBill_detail_typeunitprice(int bill_detail_typeunitprice) {
		this.bill_detail_typeunitprice = bill_detail_typeunitprice;
	}
	public int getBill_detail_discount() {
		return bill_detail_discount;
	}
	public void setBill_detail_discount(int bill_detail_discount) {
		this.bill_detail_discount = bill_detail_discount;
	}
	public double getBill_detail_price() {
		return bill_detail_price;
	}
	public void setBill_detail_price(double bill_detail_price) {
		this.bill_detail_price = bill_detail_price;
	}
	
	
}
