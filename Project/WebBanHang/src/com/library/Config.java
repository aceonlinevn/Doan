package com.library;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

 
public class Config {
	
	public ConfigObject getConfig(){
		ConfigObject con = new ConfigObject(); 
		try {   // dat try cacth de tranh ngoai le khi tao va doc File
	            FileInputStream f = new FileInputStream("config.dat"); // tao file f tro den config.dat
	            ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
	            // dung inStream doc theo Object, ep kieu tra ve la MyStudent
	            con = (ConfigObject) inStream.readObject();
	            inStream.close();
	        } catch (ClassNotFoundException e) {
	            System.out.println("Class not found");
	        } catch (IOException e) {
	            System.out.println("Error Read file");
	        }
	 
		return con;
	}
	public boolean setConfig(ConfigObject config){
		
		boolean flag = true;
		//Ghi Object vao file
		 
        try {   // dat try cacth de tranh ngoai le khi tao va viet File
            FileOutputStream f = new FileOutputStream("config.dat"); // tao file f tro den config.dat
            ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
            oStream.writeObject(config); // ghi MyStudent theo kieu Object vao file
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file: " + e.toString());
            flag = false;
        }
 
		return flag;
	}
	
	public static void main(String[] args){
		Config config = new Config();
		
		// Lay config cu
		ConfigObject con = config.getConfig();
		
		con.setCompany_currency("VNĐ");
		con.setCompany_address("Từ liêm - Hà Nội");
		con.setCompany_phonenum("0965929929");
		con.setVersion();
		con.changeKeyrule(ConfigObject.IMPORT, "Nhap khau", "NK2", (byte)6, null, (byte)0, null);
		config.setConfig(con);
		ConfigObject getcon  = config.getConfig();
		System.out.println(getcon.getCompany_address());
		System.out.println(getcon.getCompany_currency());
		System.out.println(getcon.getCompany_name());
		System.out.println(getcon.getCompany_phonenum());
		
		
		System.out.println(getcon.getVersion());
		Object[] gettemp = (Object[])getcon.getKeyrule().get(ConfigObject.IMPORT);
		
		System.out.println(gettemp[0]);
		/*
		HashMap hm = new HashMap();
		Object[] NK = {"NK",6,null,1,null,"Nhap kho"};
		Object[] XK = {"XK",6,null,1,null,"Xuat kho"};
		
		hm.put("import", NK);
		hm.put("export",XK);
		
		Object[] gettemp = (Object[])hm.get("export");
		System.out.println(con.getKeyrule().isEmpty());
		*/
	}
}
