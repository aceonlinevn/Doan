package com.object;


public class UserObject {
	private String userId;
	private String user_username,user_password,user_address,user_email,user_birthdate,user_lastlogined;
	private boolean user_isloggined,user_gender;
	private String user_note;
	private int user_permission;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_birthdate() {
		return user_birthdate;
	}
	public void setUser_birthdate(String user_birthdate) {
		this.user_birthdate = user_birthdate;
	}
	public String getUser_lastlogined() {
		return user_lastlogined;
	}
	public void setUser_lastlogined(String user_lastlogined) {
		this.user_lastlogined = user_lastlogined;
	}
	public boolean isUser_isloggined() {
		return user_isloggined;
	}
	public void setUser_isloggined(boolean user_isloggined) {
		this.user_isloggined = user_isloggined;
	}
	public boolean isUser_gender() {
		return user_gender;
	}
	public void setUser_gender(boolean user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_note() {
		return user_note;
	}
	public void setUser_note(String user_note) {
		this.user_note = user_note;
	}
	public int getUser_permission() {
		return user_permission;
	}
	public void setUser_permission(int user_permission) {
		this.user_permission = user_permission;
	}
	public UserObject(String userId, String user_username, String user_password, String user_address, String user_email,
			String user_birthdate, String user_lastlogined, boolean user_isloggined, boolean user_gender,
			String user_note, int user_permission) {
		super();
		this.userId = userId;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_address = user_address;
		this.user_email = user_email;
		this.user_birthdate = user_birthdate;
		this.user_lastlogined = user_lastlogined;
		this.user_isloggined = user_isloggined;
		this.user_gender = user_gender;
		this.user_note = user_note;
		this.user_permission = user_permission;
	}
	public UserObject() {
		super();
	}
	
	
}
