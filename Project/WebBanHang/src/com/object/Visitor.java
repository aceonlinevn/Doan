package com.object;

public class Visitor {
	private String visitor_id, visitor_prefix,visitor_created_date,visitor_IP;

	public String getVisitor_id() {
		return visitor_id;
	}

	public void setVisitor_id(String visitor_id) {
		this.visitor_id = visitor_id;
	}

	public String getVisitor_prefix() {
		return visitor_prefix;
	}

	public void setVisitor_prefix(String visitor_prefix) {
		this.visitor_prefix = visitor_prefix;
	}

	public String getVisitor_created_date() {
		return visitor_created_date;
	}

	public void setVisitor_created_date(String visitor_created_date) {
		this.visitor_created_date = visitor_created_date;
	}

	public String getVisitor_IP() {
		return visitor_IP;
	}

	public void setVisitor_IP(String visitor_IP) {
		this.visitor_IP = visitor_IP;
	}

	public Visitor(String visitor_id, String visitor_prefix, String visitor_created_date, String visitor_IP) {
		super();
		this.visitor_id = visitor_id;
		this.visitor_prefix = visitor_prefix;
		this.visitor_created_date = visitor_created_date;
		this.visitor_IP = visitor_IP;
	}

	public Visitor() {
		super();
	}
	
}
