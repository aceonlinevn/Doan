package com.ads.provider;

import java.sql.*;

import com.object.*;
import com.sql.ads.MakeConditions;
import com.*;
import com.ads.basic.BasicImpl;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class ProviderImpl extends BasicImpl implements Provider {

	public ProviderImpl(ConnectionPool cp) {
		super(cp, "Provider");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addProvider(ProviderObject item) {
		String sql = "INSERT INTO provider(";
		sql += "provider_name,provider_address,provider_note,";
		sql += "provider_phone,provider_homephone,provider_taxcode,";
		sql += "provider_image";
		sql += ")";
		sql += "VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getProvider_name());
			preAdd.setString(2, item.getProvider_address());
			preAdd.setString(3, item.getProvider_note());
			preAdd.setString(4, item.getProvider_phone());
			preAdd.setString(5, item.getProvider_homephone());
			preAdd.setString(6, item.getProvider_taxcode());
			preAdd.setString(7, item.getProvider_image());
			
			return this.add(preAdd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	private String getDateToday(){
        String datetoday = "";
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        datetoday = df.format(date);
        return datetoday;
    }
	
	@Override
	public boolean editProvider(ProviderObject item) {
		String sql = "UPDATE provider SET ";
		sql += "provider_name = ?,provider_address = ?,";
		sql += "provider_note = ?,provider_phone = ?,";
		sql += "provider_homephone = ?,provider_taxcode = ?,";
		sql += "provider_image = ?";
		sql += " WHERE provider_id = ?";
		
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getProvider_name());
			preEdit.setString(2, item.getProvider_address());
			preEdit.setString(3, item.getProvider_note());
			preEdit.setString(4, item.getProvider_phone());
			preEdit.setString(5, item.getProvider_homephone());
			preEdit.setString(6, item.getProvider_taxcode());
			preEdit.setString(7, item.getProvider_image());
			
			return this.edit(preEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProvider(ProviderObject item) {
		
		String sql = "DELETE FROM provider WHERE provider_id = ?";
		
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setInt(1, item.getProvider_id());
			
			return this.del(preDel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public ResultSet getProvider(int id) {
		String sql = "SELECT * FROM provider WHERE provider_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getProviders(ProviderObject similar, int at, byte total) {
		String sql = "SELECT * FROM provider";
		String conds = MakeConditions.createConditionProvider(similar);

        if(!conds.equalsIgnoreCase("")){
            sql += " WHERE "+conds+" ";
        }
        sql +=" ORDER BY provider_name ASC ";
        if(at != 0 && total != 0){
        sql +=" LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}

}
