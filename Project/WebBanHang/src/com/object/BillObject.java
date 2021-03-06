package com.object;

import java.util.ArrayList;

public class BillObject {
	private int bill_id;
	private String bill_prefix,bill_date_created,bill_payments,bill_tranfer,bill_customer_id;
	private double bill_advance_payment;
	private int bill_discount;
	private int bill_total_amount;
	private String bill_note,bill_product_detail,bill_finish_date,bill_accept_date,bill_user_accept_id;
	private int bill_status;
	private boolean bill_iscancel;
	public BillObject(int bill_id, String bill_customer_id, String bill_user_accept_id, String bill_prefix,
			String bill_date_created, String bill_payments, double bill_advance_payment, String bill_tranfer,
			int bill_discount, int bill_total_amount, String bill_note,int bill_status,String bill_product_detail,String bill_accept_date,String bill_finish_date,boolean bill_iscancel) {
		super();
		this.bill_id = bill_id;
		this.bill_customer_id = bill_customer_id;
		this.bill_user_accept_id = bill_user_accept_id;
		this.bill_prefix = bill_prefix;
		this.bill_date_created = bill_date_created;
		this.bill_payments = bill_payments;
		this.bill_advance_payment = bill_advance_payment;
		this.bill_tranfer = bill_tranfer;
		this.bill_discount = bill_discount;
		this.bill_total_amount = bill_total_amount;
		this.bill_note = bill_note;
		this.bill_status = bill_status;
		this.bill_product_detail = bill_product_detail;
		this.bill_finish_date = bill_finish_date;
		this.bill_accept_date = bill_accept_date;
		this.bill_iscancel = bill_iscancel;
	}
	public boolean isBill_iscancel() {
		return bill_iscancel;
	}
	public void setBill_iscancel(boolean bill_iscancel) {
		this.bill_iscancel = bill_iscancel;
	}
	public String getBill_finish_date() {
		return bill_finish_date;
	}
	public void setBill_finish_date(String bill_finish_date) {
		this.bill_finish_date = bill_finish_date;
	}
	public String getBill_accept_date() {
		return bill_accept_date;
	}
	public void setBill_accept_date(String bill_accept_date) {
		this.bill_accept_date = bill_accept_date;
	}
	public int getBill_status() {
		return bill_status;
	}
	public void setBill_status(int bill_status) {
		this.bill_status = bill_status;
	}
	public String getBill_product_detail() {
		return bill_product_detail;
	}
	public void setBill_product_detail(String bill_product_detail) {
		this.bill_product_detail = bill_product_detail;
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
	public String getBill_customer_id() {
		return bill_customer_id;
	}
	public void setBill_customer_id(String bill_customer_id) {
		this.bill_customer_id = bill_customer_id;
	}
	public String getBill_user_accept_id() {
		return bill_user_accept_id;
	}
	public void setBill_user_accept_id(String bill_user_accept_id) {
		this.bill_user_accept_id = bill_user_accept_id;
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
	public String getBill_tranfer() {
		return bill_tranfer;
	}
	public void setBill_tranfer(String bill_tranfer) {
		this.bill_tranfer = bill_tranfer;
	}
	public int getBill_discount() {
		return bill_discount;
	}
	public void setBill_discount(int bill_discount) {
		this.bill_discount = bill_discount;
	}
	public int getBill_total_amount() {
		return bill_total_amount;
	}
	public void setBill_total_amount(int bill_total_amount) {
		this.bill_total_amount = bill_total_amount;
	}
	public String getBill_note() {
		return bill_note;
	}
	public void setBill_note(String bill_note) {
		this.bill_note = bill_note;
	}
	
	
}
