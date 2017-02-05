package com.object;

public class PermissionObject {
	private int permission_id;
	private String permission_name,permission_description,permission_date_created;
	private boolean permission_is_enable;
	public PermissionObject(int permission_id, String permission_name, String permission_description,
			String permission_date_created, boolean permission_is_enable) {
		super();
		this.permission_id = permission_id;
		this.permission_name = permission_name;
		this.permission_description = permission_description;
		this.permission_date_created = permission_date_created;
		this.permission_is_enable = permission_is_enable;
	}
	public PermissionObject() {
		super();
	}
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getPermission_description() {
		return permission_description;
	}
	public void setPermission_description(String permission_description) {
		this.permission_description = permission_description;
	}
	public String getPermission_date_created() {
		return permission_date_created;
	}
	public void setPermission_date_created(String permission_date_created) {
		this.permission_date_created = permission_date_created;
	}
	public boolean isPermission_is_enable() {
		return permission_is_enable;
	}
	public void setPermission_is_enable(boolean permission_is_enable) {
		this.permission_is_enable = permission_is_enable;
	}
	
	
}
