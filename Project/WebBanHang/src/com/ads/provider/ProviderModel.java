package com.ads.provider;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class ProviderModel {
	private Provider p;

	public ProviderModel(ConnectionPool cp) {
		this.p = new ProviderImpl(cp);
	}

	protected void finalize() throws Throwable {
		this.p = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.p.getConnectionPool();
	}

	public void releaseConnection() {
		this.p.releaseConnection();
	}

	// ************************************************/

	 public boolean addProvider(ProviderObject item){
	        return this.p.addProvider(item);
	    }

	    public boolean editProvider(ProviderObject item){
	        return this.p.editProvider(item);
	    }

	    public boolean delProvider(ProviderObject item){
	        return this.p.delProvider(item);
	    }
	    
	   
	public ProviderObject getProviderObject(int id) {
		ProviderObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.p.getProvider(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ProviderObject();
					item.setProvider_id(rs.getInt("provider_id"));
					item.setProvider_prefix(rs.getString("provider_prefix"));
					item.setProvider_name(rs.getString("provider_name"));
					item.setProvider_address(rs.getString("provider_address"));
					item.setProvider_note(rs.getString("provider_note"));
					item.setProvider_phone(rs.getString("provider_phone"));
					item.setProvider_homephone(rs.getString("provider_homephone"));
					item.setProvider_taxcode(rs.getString("provider_taxcode"));
					item.setProvider_image(rs.getString("provider_image"));

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<ProviderObject> getProviderObjects(ProviderObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<ProviderObject> items = new ArrayList<ProviderObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        ProviderObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.p.getProviders(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new ProviderObject();
                	item.setProvider_id(rs.getInt("provider_id"));
					item.setProvider_prefix(rs.getString("provider_prefix"));
					item.setProvider_name(rs.getString("provider_name"));
					item.setProvider_address(rs.getString("provider_address"));
					item.setProvider_note(rs.getString("provider_note"));
					item.setProvider_phone(rs.getString("provider_phone"));
					item.setProvider_homephone(rs.getString("provider_homephone"));
					item.setProvider_taxcode(rs.getString("provider_taxcode"));
					item.setProvider_image(rs.getString("provider_image"));

                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
    }
}
