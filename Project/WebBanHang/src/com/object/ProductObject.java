package com.object;

public class ProductObject {
	private int product_id;
	private String product_prefix,product_name;
	private boolean product_status;
	private int product_category_id,product_quantity;
	private double product_origin_price,product_price2,product_price3;
	private int product_price_discount;
	private String product_imported_date,product_last_modified;
	private String product_specification,product_note;
	private int product_warranty_time,product_provider_id;
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_prefix() {
		return product_prefix;
	}
	public void setProduct_prefix(String product_prefix) {
		this.product_prefix = product_prefix;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public boolean isProduct_status() {
		return product_status;
	}
	public void setProduct_status(boolean product_status) {
		this.product_status = product_status;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public double getProduct_origin_price() {
		return product_origin_price;
	}
	public void setProduct_origin_price(double product_origin_price) {
		this.product_origin_price = product_origin_price;
	}
	public double getProduct_price2() {
		return product_price2;
	}
	public void setProduct_price2(double product_price2) {
		this.product_price2 = product_price2;
	}
	public double getProduct_price3() {
		return product_price3;
	}
	public void setProduct_price3(double product_price3) {
		this.product_price3 = product_price3;
	}
	public int getProduct_price_discount() {
		return product_price_discount;
	}
	public void setProduct_price_discount(int product_price_discount) {
		this.product_price_discount = product_price_discount;
	}
	public String getProduct_imported_date() {
		return product_imported_date;
	}
	public void setProduct_imported_date(String product_imported_date) {
		this.product_imported_date = product_imported_date;
	}
	public String getProduct_last_modified() {
		return product_last_modified;
	}
	public void setProduct_last_modified(String product_last_modified) {
		this.product_last_modified = product_last_modified;
	}
	public String getProduct_specification() {
		return product_specification;
	}
	public void setProduct_specification(String product_specification) {
		this.product_specification = product_specification;
	}
	public String getProduct_note() {
		return product_note;
	}
	public void setProduct_note(String product_note) {
		this.product_note = product_note;
	}
	public int getProduct_warranty_time() {
		return product_warranty_time;
	}
	public void setProduct_warranty_time(int product_warranty_time) {
		this.product_warranty_time = product_warranty_time;
	}
	public int getProduct_provider_id() {
		return product_provider_id;
	}
	public void setProduct_provider_id(int product_provider_id) {
		this.product_provider_id = product_provider_id;
	}
	public ProductObject(int product_id, String product_prefix, String product_name, boolean product_status,
			int product_category_id, int product_quantity, double product_origin_price, double product_price2,
			double product_price3, int product_price_discount, String product_imported_date,
			String product_last_modified, String product_specification, String product_note, int product_warranty_time,
			int product_provider_id) {
		super();
		this.product_id = product_id;
		this.product_prefix = product_prefix;
		this.product_name = product_name;
		this.product_status = product_status;
		this.product_category_id = product_category_id;
		this.product_quantity = product_quantity;
		this.product_origin_price = product_origin_price;
		this.product_price2 = product_price2;
		this.product_price3 = product_price3;
		this.product_price_discount = product_price_discount;
		this.product_imported_date = product_imported_date;
		this.product_last_modified = product_last_modified;
		this.product_specification = product_specification;
		this.product_note = product_note;
		this.product_warranty_time = product_warranty_time;
		this.product_provider_id = product_provider_id;
	}
	public ProductObject() {
		super();
	}
	
	
}