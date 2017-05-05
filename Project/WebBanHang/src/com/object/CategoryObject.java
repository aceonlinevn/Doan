package com.object;

public class CategoryObject extends CategoryGroupObject{
	private int category_id;
	private String category_prefix,category_name;
	private int category_group_id;
	private String category_note,category_created_date;
	private int category_author_created_id;
	private String category_last_modified;
	private int category_mamager_id;
	private boolean category_is_enable,category_is_deleted;
	private String category_images,category_icon;
	
	public CategoryObject() {
		super();
	}
	public CategoryObject(int category_id, String category_prefix, String category_name, int category_group_id,
			String category_note, String category_created_date, int category_author_created_id,
			String category_last_modified, int category_mamager_id, boolean category_is_enable,
			boolean category_is_deleted, String category_images,String category_icon) {
		super();
		this.category_id = category_id;
		this.category_prefix = category_prefix;
		this.category_name = category_name;
		this.category_group_id = category_group_id;
		this.category_note = category_note;
		this.category_created_date = category_created_date;
		this.category_author_created_id = category_author_created_id;
		this.category_last_modified = category_last_modified;
		this.category_mamager_id = category_mamager_id;
		this.category_is_enable = category_is_enable;
		this.category_is_deleted = category_is_deleted;
		this.category_images = category_images;
		this.category_icon = category_icon;
	}
	public String getCategory_icon() {
		return category_icon;
	}
	public void setCategory_icon(String category_icon) {
		this.category_icon = category_icon;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategory_prefix() {
		return category_prefix;
	}
	public void setCategory_prefix(String category_prefix) {
		this.category_prefix = category_prefix;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getCategory_group_id() {
		return category_group_id;
	}
	public void setCategory_group_id(int category_group_id) {
		this.category_group_id = category_group_id;
	}
	public String getCategory_note() {
		return category_note;
	}
	public void setCategory_note(String category_note) {
		this.category_note = category_note;
	}
	public String getCategory_created_date() {
		return category_created_date;
	}
	public void setCategory_created_date(String category_created_date) {
		this.category_created_date = category_created_date;
	}
	public int getCategory_author_created_id() {
		return category_author_created_id;
	}
	public void setCategory_author_created_id(int category_author_created_id) {
		this.category_author_created_id = category_author_created_id;
	}
	public String getCategory_last_modified() {
		return category_last_modified;
	}
	public void setCategory_last_modified(String category_last_modified) {
		this.category_last_modified = category_last_modified;
	}
	public int getCategory_mamager_id() {
		return category_mamager_id;
	}
	public void setCategory_mamager_id(int category_mamager_id) {
		this.category_mamager_id = category_mamager_id;
	}
	public boolean isCategory_is_enable() {
		return category_is_enable;
	}
	public void setCategory_is_enable(boolean category_is_enable) {
		this.category_is_enable = category_is_enable;
	}
	public boolean isCategory_is_deleted() {
		return category_is_deleted;
	}
	public void setCategory_is_deleted(boolean category_is_deleted) {
		this.category_is_deleted = category_is_deleted;
	}
	public String getCategory_images() {
		return category_images;
	}
	public void setCategory_images(String category_images) {
		this.category_images = category_images;
	}
	
	
}
