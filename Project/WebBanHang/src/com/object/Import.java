package com.object;

import java.util.ArrayList;

public class Import {
	private int import_id,import_user_import_id,import_provider_id;
	private String import_prefix,import_date_imported,import_payment;
	private double import_advance_payment,import_owe;
	private ArrayList<ImportDetailObject> items;
	public Import(int import_id, int import_user_import_id, int import_provider_id, String import_prefix,
			String import_date_imported, String import_payment, double import_advance_payment, double import_owe,
			ArrayList<ImportDetailObject> items) {
		super();
		this.import_id = import_id;
		this.import_user_import_id = import_user_import_id;
		this.import_provider_id = import_provider_id;
		this.import_prefix = import_prefix;
		this.import_date_imported = import_date_imported;
		this.import_payment = import_payment;
		this.import_advance_payment = import_advance_payment;
		this.import_owe = import_owe;
		this.items = items;
	}
	public Import() {
		items=new ArrayList<>();
	}
	public int getImport_id() {
		return import_id;
	}
	public void setImport_id(int import_id) {
		this.import_id = import_id;
	}
	public int getImport_user_import_id() {
		return import_user_import_id;
	}
	public void setImport_user_import_id(int import_user_import_id) {
		this.import_user_import_id = import_user_import_id;
	}
	public int getImport_provider_id() {
		return import_provider_id;
	}
	public void setImport_provider_id(int import_provider_id) {
		this.import_provider_id = import_provider_id;
	}
	public String getImport_prefix() {
		return import_prefix;
	}
	public void setImport_prefix(String import_prefix) {
		this.import_prefix = import_prefix;
	}
	public String getImport_date_imported() {
		return import_date_imported;
	}
	public void setImport_date_imported(String import_date_imported) {
		this.import_date_imported = import_date_imported;
	}
	public String getImport_payment() {
		return import_payment;
	}
	public void setImport_payment(String import_payment) {
		this.import_payment = import_payment;
	}
	public double getImport_advance_payment() {
		return import_advance_payment;
	}
	public void setImport_advance_payment(double import_advance_payment) {
		this.import_advance_payment = import_advance_payment;
	}
	public double getImport_owe() {
		return import_owe;
	}
	public void setImport_owe(double import_owe) {
		this.import_owe = import_owe;
	}
	public ArrayList<ImportDetailObject> getItems() {
		return items;
	}
	public void setItems(ArrayList<ImportDetailObject> items) {
		this.items = items;
	}
}
