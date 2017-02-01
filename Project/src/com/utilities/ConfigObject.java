package com.utilities;

import java.io.Serializable;
import java.util.HashMap;

public class ConfigObject implements Serializable{
	/**
	 * 
	 */
	
	public static final String USER = "user";
	public static final String CUSTOMER = "customer";
	
	public static final String IMPORT = "import";
	public static final String EXPORT = "export";
	public static final String WARANTY = "waranty";
	public static final String PRODUCT = "product";
	public static final String PROVIDER = "provider";
	public static final String PRODUCT_LAPTOP = "laptop";
	public static final String PRODUCT_CAMERA = "camera";
	public static final String PRODUCT_PC = "pc";
	public static final String PRODUCT_COMPONENT = "component";
	public static final String PRODUCT_ACCESSORIES = "accessories";
	
	
	private static final long serialVersionUID = 1L;
	private int version = 0;
	private String company_name,company_tax_code,company_phonenum;
	private String company_address,company_national,company_currency;
	private String config_lastmodified;
	HashMap<String, Object[]> keyrule = new HashMap<String, Object[]>();
	
	public ConfigObject(){
		if(keyrule.isEmpty()){
			putKeyrule(USER, "user", "U", (byte)6,null, (byte)1, "Người dùng");
			putKeyrule(CUSTOMER, "customer", "KH", (byte)6,null, (byte)1, "Khách hàng");
			putKeyrule(IMPORT, "import", "NK", (byte)6,null, (byte)1, "Nhập khẩu");
			putKeyrule(EXPORT, "export", "XK", (byte)6,null, (byte)1, "Xuất kho");
			putKeyrule(WARANTY, "waranty", "BH", (byte)6,null, (byte)1, "Bảo hành");
			putKeyrule(PRODUCT, "product", "SP", (byte)6,null, (byte)1, "Sản phẩm");
			putKeyrule(PROVIDER, "provider", "NCC", (byte)6,null, (byte)1, "Nhà cung cấp");
			putKeyrule(PRODUCT_LAPTOP, "laptop", "LT", (byte)6,null, (byte)1, "Sản phẩm Laptop");
			putKeyrule(PRODUCT_CAMERA, "camera", "CAM", (byte)6,null, (byte)1, "Sản phẩm Camera");
			putKeyrule(PRODUCT_PC, "pc", "pc", (byte)6,null, (byte)1, "Sản phẩm PC");
			putKeyrule(PRODUCT_COMPONENT, "component", "LK", (byte)6,null, (byte)1, "Linh kiện");
			putKeyrule(PRODUCT_ACCESSORIES, "accessories", "PK", (byte)6,null, (byte)1, "Phụ kiện");
		}
		Config con = new Config();
		ConfigObject item = con.getConfig();
		this.version = item.getVersion();
		this.company_name = item.getCompany_name();
		this.company_tax_code = item.getCompany_tax_code();
		this.company_phonenum = item.getCompany_phonenum();
		this.company_address = item.getCompany_address();
		this.company_national = item.getCompany_national();
		this.company_currency = item.getCompany_currency();
		this.config_lastmodified = "";
		this.keyrule = item.getKeyrule();
		
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion() {
		this.version ++;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_tax_code() {
		return company_tax_code;
	}

	public void setCompany_tax_code(String company_tax_code) {
		this.company_tax_code = company_tax_code;
	}

	public String getCompany_phonenum() {
		return company_phonenum;
	}

	public void setCompany_phonenum(String company_phonenum) {
		this.company_phonenum = company_phonenum;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_national() {
		return company_national;
	}

	public void setCompany_national(String company_national) {
		this.company_national = company_national;
	}

	public String getCompany_currency() {
		return company_currency;
	}

	public void setCompany_currency(String company_currency) {
		this.company_currency = company_currency;
	}

	public String getConfig_lastmodified() {
		return config_lastmodified;
	}

	public void setConfig_lastmodified(String config_lastmodified) {
		this.config_lastmodified = config_lastmodified;
	}

	public HashMap<String, Object[]> getKeyrule() {
		return keyrule;
	}

	public void setKeyrule(HashMap<String, Object[]> keyrule) {
		this.keyrule = keyrule;
	}
	public void putKeyrule(String key,String name, String prefix, byte length, String suffixes, byte rule_start,String description) {
		Object[] term = {name,prefix,length,suffixes,rule_start,description};
		this.keyrule.put(key, term);
	}
	
	public void changeKeyrule(String key,String name, String prefix, byte length, String suffixes, byte rule_start,String description){
		Object[] term = {name,prefix,length,suffixes,rule_start,description};
		this.keyrule.replace(key, term);
	}
}
