package com.object;

public class ProviderObject {
	private int provider_id;
	private String provider_prefix,provider_name,provider_address,provider_note,provider_phone,provider_homephone,provider_taxcode;
	public ProviderObject(int provider_id, String provider_prefix, String provider_name, String provider_address,
			String provider_note, String provider_phone, String provider_homephone, String provider_taxcode) {
		super();
		this.provider_id = provider_id;
		this.provider_prefix = provider_prefix;
		this.provider_name = provider_name;
		this.provider_address = provider_address;
		this.provider_note = provider_note;
		this.provider_phone = provider_phone;
		this.provider_homephone = provider_homephone;
		this.provider_taxcode = provider_taxcode;
	}
	public ProviderObject() {
		super();
	}
	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
	public String getProvider_prefix() {
		return provider_prefix;
	}
	public void setProvider_prefix(String provider_prefix) {
		this.provider_prefix = provider_prefix;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getProvider_address() {
		return provider_address;
	}
	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
	}
	public String getProvider_note() {
		return provider_note;
	}
	public void setProvider_note(String provider_note) {
		this.provider_note = provider_note;
	}
	public String getProvider_phone() {
		return provider_phone;
	}
	public void setProvider_phone(String provider_phone) {
		this.provider_phone = provider_phone;
	}
	public String getProvider_homephone() {
		return provider_homephone;
	}
	public void setProvider_homephone(String provider_homephone) {
		this.provider_homephone = provider_homephone;
	}
	public String getProvider_taxcode() {
		return provider_taxcode;
	}
	public void setProvider_taxcode(String provider_taxcode) {
		this.provider_taxcode = provider_taxcode;
	}
	
	
}
