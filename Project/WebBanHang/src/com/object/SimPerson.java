package com.object;

public class SimPerson {
	private int SimPerson_id;
	private String user_id_1, user_id_2;

	public SimPerson(int simPerson_id, String user_id_1, String user_id_2) {
		SimPerson_id = simPerson_id;
		this.user_id_1 = user_id_1;
		this.user_id_2 = user_id_2;
	}

	public SimPerson() {
	}

	public int getSimPerson_id() {
		return SimPerson_id;
	}

	public void setSimPerson_id(int simPerson_id) {
		SimPerson_id = simPerson_id;
	}

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

}
