package com.ads.Collaboration;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class UserRateModel {
	private UserRate p;

	public UserRateModel(ConnectionPool cp) {
		//this.p = new UserRateImpl(cp);
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

	 public boolean addUserRate(UserRateObject item){
	        return this.p.addUserRate(item);
	    }

	   
	public UserRateObject getUserRateObject(int id) {
		UserRateObject item = null;

		// Lay ban ghi nguoi su dung theo id
		ResultSet rs = this.p.getUserRate(id);
		
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserRateObject();
					
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<UserRateObject> getUserRateObjects(UserRateObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<UserRateObject> items = new ArrayList<UserRateObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        UserRateObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.p.getUserRates(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new UserRateObject();
					
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
