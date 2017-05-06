package com.ads.images;

import java.sql.*;
import java.text.*;

import com.*;
import com.ads.basic.*;
import com.ads.product.Product;
import com.ads.product.ProductImpl;
import com.object.*;
import com.sql.ads.MakeConditions;

public class ImagesImpl extends BasicImpl implements Images {

	public ImagesImpl(ConnectionPool cp, String objectName) {
		super(cp, objectName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addImages(ImagesObject item) {
		String sql = "INSERT INTO tblimages(";
		sql += "images_src,images_name,";
		sql += "images_note,images_product_id";
		sql += ")";
		sql += "VALUES(?,?,?,?)";
		try{
			PreparedStatement preAdd = this.con.prepareStatement(sql);
			preAdd.setString(1, item.getImages_src());
			preAdd.setString(2, item.getImages_name());
			preAdd.setString(3, item.getImages_note());
			preAdd.setInt(4, item.getImages_product_id());
			
			return this.add(preAdd);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
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
	public boolean editImages(ImagesObject item) {
		String sql ="UPDATE tblimages SET ";
		sql += "images_src = ?,images_name = ?,";
		sql += "images_note = ?,images_product_id = ?,";
		sql += " WHERE images_id = ?";
		
		try {
			PreparedStatement preEdit = this.con.prepareStatement(sql);
			preEdit.setString(1, item.getImages_src());
			preEdit.setString(2, item.getImages_name());
			preEdit.setString(3, item.getImages_note());
			preEdit.setInt(4, item.getImages_product_id());
			preEdit.setInt(5, item.getImages_id());
			return this.edit(preEdit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delImages(ImagesObject item) {
		if(!isExisting(item)){
			return false;
		}
		String sql = "DELETE FROM tblimages WHERE category_group_id = ?";
		
		try {
			PreparedStatement preDel = this.con.prepareStatement(sql);
			preDel.setInt(1, item.getImages_id());
			
			return this.del(preDel);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	
	
    private boolean isExisting(ImagesObject item){
        boolean flag = true;
        String sql = "SELECT product_id FROM product WHERE product_image = "+item.getImages_src()+"";
        ResultSet rs = this.get(sql,0);
        if(rs !=null){
            try {
                if (rs.next()) {
                    flag = false;
                }
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return flag;
    }
    
	@Override
	public ResultSet getImages(int id) {
		String sql = "SELECT * FROM tblimages WHERE images_id = ?";
		
		return this.get(sql, id);
	}

	@Override
	public ResultSet getImagess(ImagesObject similar, int at, byte total) {
		String sql = "SELECT * FROM tblimages ";
        sql +=" ORDER BY images_name ASC ";
        if(at !=0 && total !=0){
        	sql +="LIMIT "+ at +","+ total;
        }
        return this.gets(sql);
	}
	
}
