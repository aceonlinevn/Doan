package com.object;

public class UserObject {
	private String userId;
	private String user_prefix, user_name, user_last_messased, user_phonenum;
	private String user_username, user_password, user_address, user_email, user_birthdate;
	private boolean user_isloggined, user_gender,user_is_encryption;
	private String user_note;
	private int user_permission_id, user_lastlogined;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUser_prefix() {
		return user_prefix;
	}

	public void setUser_prefix(String user_prefix) {
		this.user_prefix = user_prefix;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_last_messased() {
		return user_last_messased;
	}

	public void setUser_last_messased(String user_last_messased) {
		this.user_last_messased = user_last_messased;
	}

	public String getUser_phonenum() {
		return user_phonenum;
	}

	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
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

	public int getUser_lastlogined() {
		return user_lastlogined;
	}

	public void setUser_lastlogined(int user_lastlogined) {
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

	public int getUser_permission_id() {
		return user_permission_id;
	}

	public void setUser_permission_id(int user_permission_id) {
		this.user_permission_id = user_permission_id;
	}

	public boolean isUser_is_encryption() {
		return user_is_encryption;
	}

	public void setUser_is_encryption(boolean user_is_encryption) {
		this.user_is_encryption = user_is_encryption;
	}

	public UserObject(String userId, String user_prefix, String user_name, String user_last_messased,
			String user_phonenum, String user_username, String user_password, String user_address, String user_email,
			String user_birthdate, int user_lastlogined, boolean user_isloggined, boolean user_gender,
			String user_note, int user_permission_id,boolean user_is_encryption) {
		super();
		this.userId = userId;
		this.user_prefix = user_prefix;
		this.user_name = user_name;
		this.user_last_messased = user_last_messased;
		this.user_phonenum = user_phonenum;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_address = user_address;
		this.user_email = user_email;
		this.user_birthdate = user_birthdate;
		this.user_lastlogined = user_lastlogined;
		this.user_isloggined = user_isloggined;
		this.user_gender = user_gender;
		this.user_note = user_note;
		this.user_permission_id = user_permission_id;
		this.user_is_encryption = user_is_encryption;
	}

	public UserObject() {
		super();
	}

}
