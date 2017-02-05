package com.object;

public class CategoryGroupObject {
	private int category_group_id;
	private String category_group_prefix;
	private String category_group_name,category_group_note;
	private String category_group_created_date;
	private int category_group_manager_id;
	private boolean category_group_is_enable;
	private String category_group_image;
	public int getCategory_group_id() {
		return category_group_id;
	}
	public void setCategory_group_id(int category_group_id) {
		this.category_group_id = category_group_id;
	}
	public String getCategory_group_prefix() {
		return category_group_prefix;
	}
	public void setCategory_group_prefix(String category_group_prefix) {
		this.category_group_prefix = category_group_prefix;
	}
	public String getCategory_group_name() {
		return category_group_name;
	}
	public void setCategory_group_name(String category_group_name) {
		this.category_group_name = category_group_name;
	}
	public String getCategory_group_note() {
		return category_group_note;
	}
	public void setCategory_group_note(String category_group_note) {
		this.category_group_note = category_group_note;
	}
	public String getCategory_group_created_date() {
		return category_group_created_date;
	}
	public void setCategory_group_created_date(String category_group_created_date) {
		this.category_group_created_date = category_group_created_date;
	}
	public int getCategory_group_manager_id() {
		return category_group_manager_id;
	}
	public void setCategory_group_manager_id(int category_group_manager_id) {
		this.category_group_manager_id = category_group_manager_id;
	}
	public boolean isCategory_group_is_enable() {
		return category_group_is_enable;
	}
	public void setCategory_group_is_enable(boolean category_group_is_enable) {
		this.category_group_is_enable = category_group_is_enable;
	}
	public String getCategory_group_image() {
		return category_group_image;
	}
	public void setCategory_group_image(String category_group_image) {
		this.category_group_image = category_group_image;
	}
	public CategoryGroupObject(int category_group_id, String category_group_prefix, String category_group_name,
			String category_group_note, String category_group_created_date, int category_group_manager_id,
			boolean category_group_is_enable, String category_group_image) {
		super();
		this.category_group_id = category_group_id;
		this.category_group_prefix = category_group_prefix;
		this.category_group_name = category_group_name;
		this.category_group_note = category_group_note;
		this.category_group_created_date = category_group_created_date;
		this.category_group_manager_id = category_group_manager_id;
		this.category_group_is_enable = category_group_is_enable;
		this.category_group_image = category_group_image;
	}
	public CategoryGroupObject() {
		super();
	}
	
}
