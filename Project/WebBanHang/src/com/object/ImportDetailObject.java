package com.object;

public class ImportDetailObject {
	private int import_detail_id,import_id,import_detail_product_id,import_detail_quantity;
	private double import_detail_price;
	
	public ImportDetailObject() {
		super();
	}
	public ImportDetailObject(int import_detail_id, int import_id, int import_detail_product_id,
			int import_detail_quantity, double import_detail_price) {
		super();
		this.import_detail_id = import_detail_id;
		this.import_id = import_id;
		this.import_detail_product_id = import_detail_product_id;
		this.import_detail_quantity = import_detail_quantity;
		this.import_detail_price = import_detail_price;
	}
	public int getImport_detail_id() {
		return import_detail_id;
	}
	public void setImport_detail_id(int import_detail_id) {
		this.import_detail_id = import_detail_id;
	}
	public int getImport_id() {
		return import_id;
	}
	public void setImport_id(int import_id) {
		this.import_id = import_id;
	}
	public int getImport_detail_product_id() {
		return import_detail_product_id;
	}
	public void setImport_detail_product_id(int import_detail_product_id) {
		this.import_detail_product_id = import_detail_product_id;
	}
	public int getImport_detail_quantity() {
		return import_detail_quantity;
	}
	public void setImport_detail_quantity(int import_detail_quantity) {
		this.import_detail_quantity = import_detail_quantity;
	}
	public double getImport_detail_price() {
		return import_detail_price;
	}
	public void setImport_detail_price(double import_detail_price) {
		this.import_detail_price = import_detail_price;
	}
	
}
