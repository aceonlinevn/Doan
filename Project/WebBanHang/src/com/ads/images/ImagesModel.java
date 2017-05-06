package com.ads.images;

import com.*;
import com.object.*;
import java.sql.*;
import java.util.*;

public class ImagesModel {
	private Images id;

	public ImagesModel(ConnectionPool cp) {
		this.id = new ImagesImpl(cp,"Images");
	}

	protected void finalize() throws Throwable {
		this.id = null;
		System.gc();// thu gom rac he thong
		System.runFinalization();// Don dep he thong
	}

	public ConnectionPool getConnectionPool() {
		return this.id.getConnectionPool();
	}

	public void releaseConnection() {
		this.id.releaseConnection();
	}

	// ************************************************/

	 public boolean addImages(ImagesObject item){
	        return this.id.addImages(item);
	    }

	    public boolean editImages(ImagesObject item){
	        return this.id.editImages(item);
	    }

	    public boolean delImages(ImagesObject item){
	        return this.id.delImages(item);
	    }
	    
	   
	public ImagesObject getImagesObject(int id) {
		ImagesObject item = null;		
		ResultSet rs = this.id.getImages(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ImagesObject();
					item.setImages_src(rs.getString("images_src"));
					item.setImages_name(rs.getString("images_name"));
					item.setImages_note(rs.getString("images_note"));
					item.setImages_id(rs.getInt("images_product_id"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return item;
	}
	
	public ArrayList<ImagesObject> getImagesObjects(ImagesObject similar, int page, byte total){
        //Danh sach doi tuong
        ArrayList<ImagesObject> items = new ArrayList<ImagesObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        ImagesObject item = null;

        //Lay ban ghi nguoi su dung theo danh sach
        int at = (page -1)* total;
        ResultSet rs = this.id.getImagess(similar, at, total);
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new ImagesObject();
                	item.setImages_src(rs.getString("images_src"));
					item.setImages_name(rs.getString("images_name"));
					item.setImages_note(rs.getString("images_note"));
					item.setImages_id(rs.getInt("images_product_id"));
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
