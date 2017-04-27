package com.object;

public class SimPerson {
	private String user_id_1, user_id_2;
	private float simPerson;

	public String getUser_id_1() {
		return user_id_1;
	}

	public void setUser_id_1(String user_id_1) {
		this.user_id_1 = user_id_1;
	}

	public String getUser_id_2() {
		return user_id_2;
	}

	public void setUser_id_2(String user_id_2) {
		this.user_id_2 = user_id_2;
	}

	public float getSimPerson() {
		return simPerson;
	}

	public void setSimPerson(float simPerson) {
		this.simPerson = simPerson;
	}

	public SimPerson(String user_id_1, String user_id_2, float simPerson) {
		super();
		this.user_id_1 = user_id_1;
		this.user_id_2 = user_id_2;
		this.simPerson = simPerson;
	}

	public SimPerson() {
		super();
	}

}
