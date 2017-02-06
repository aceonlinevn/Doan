package com.object;

import java.util.ArrayList;

public class BillObject {
	private int bill_id,bill_customer_id,bill_user_created_id;
	private String bill_prefix,bill_date_created,bill_payments;
	private double bill_advance_payment,bill_owe;
	private int bill_discount,bill_typeunitprice;
	private double bill_total_amount;
	private String bill_note;
	private ArrayList<BillDetailObject> items ;
	public BillObject(int bill_id, int bill_customer_id, int bill_user_created_id, String bill_prefix,
			String bill_date_created, String bill_payments, double bill_advance_payment, double bill_owe,
			int bill_discount, int bill_typeunitprice, double bill_total_amount, String bill_note,
			ArrayList<BillDetailObject> items) {
		super();
		this.bill_id = bill_id;
		this.bill_customer_id = bill_customer_id;
		this.bill_user_created_id = bill_user_created_id;
		this.bill_prefix = bill_prefix;
		this.bill_date_created = bill_date_created;
		this.bill_payments = bill_payments;
		this.bill_advance_payment = bill_advance_payment;
		this.bill_owe = bill_owe;
		this.bill_discount = bill_discount;
		this.bill_typeunitprice = bill_typeunitprice;
		this.bill_total_amount = bill_total_amount;
		this.bill_note = bill_note;
		this.items = items;
	}
	public BillObject() {
		super();
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getBill_customer_id() {
		return bill_customer_id;
	}
	public void setBill_customer_id(int bill_customer_id) {
		this.bill_customer_id = bill_customer_id;
	}
	public int getBill_user_created_id() {
		return bill_user_created_id;
	}
	public void setBill_user_created_id(int bill_user_created_id) {
		this.bill_user_created_id = bill_user_created_id;
	}
	public String getBill_prefix() {
		return bill_prefix;
	}
	public void setBill_prefix(String bill_prefix) {
		this.bill_prefix = bill_prefix;
	}
	public String getBill_date_created() {
		return bill_date_created;
	}
	public void setBill_date_created(String bill_date_created) {
		this.bill_date_created = bill_date_created;
	}
	public String getBill_payments() {
		return bill_payments;
	}
	public void setBill_payments(String bill_payments) {
		this.bill_payments = bill_payments;
	}
	public double getBill_advance_payment() {
		return bill_advance_payment;
	}
	public void setBill_advance_payment(double bill_advance_payment) {
		this.bill_advance_payment = bill_advance_payment;
	}
	public double getBill_owe() {
		return bill_owe;
	}
	public void setBill_owe(double bill_owe) {
		this.bill_owe = bill_owe;
	}
	public int getBill_discount() {
		return bill_discount;
	}
	public void setBill_discount(int bill_discount) {
		this.bill_discount = bill_discount;
	}
	public int getBill_typeunitprice() {
		return bill_typeunitprice;
	}
	public void setBill_typeunitprice(int bill_typeunitprice) {
		this.bill_typeunitprice = bill_typeunitprice;
	}
	public double getBill_total_amount() {
		return bill_total_amount;
	}
	public void setBill_total_amount(double bill_total_amount) {
		this.bill_total_amount = bill_total_amount;
	}
	public String getBill_note() {
		return bill_note;
	}
	public void setBill_note(String bill_note) {
		this.bill_note = bill_note;
	}
	public ArrayList<BillDetailObject> getItems() {
		return items;
	}
	public void setItems(ArrayList<BillDetailObject> items) {
		this.items = items;
	}
	
	
}
