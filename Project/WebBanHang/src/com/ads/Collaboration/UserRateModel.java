package com.ads.Collaboration;

import com.*;
import com.gui.product.ProductRating;
import com.object.*;
import java.sql.*;
import java.util.*;

public class UserRateModel {
	private UserRate p;

	public UserRateModel(ConnectionPool cp) {
		this.p = new UserRateImpl(cp);
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

	public boolean addUserRate(UserRateObject item) {
		return this.p.addUserRate(item);
	}

	public ArrayList<SameUserRateProductObject> getSameProduct(String userid1, String userid2) {
		ArrayList<SameUserRateProductObject> items = new ArrayList<>();
		ResultSet rs = p.getSameProduct(userid1, userid2);
		if (rs != null) {
			try {
				while (rs.next()) {
					SameUserRateProductObject item = new SameUserRateProductObject();
					item.setProductid(rs.getInt(1));
					item.setUserid1(userid1);
					item.setUserid2(userid2);
					item.setUser1_rate(rs.getInt(2));
					item.setUser2_rate(rs.getInt(3));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	public UserRateAVGObject getUserRateAVG(String userid) {
		UserRateAVGObject item = null;
		ResultSet rs = p.getUserRateAVG(userid);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new UserRateAVGObject();
					item.setUser_id(rs.getString("user_id"));
					item.setUser_rate_avg(rs.getFloat("user_rate_avg"));
					item.setUser_rate_total(rs.getInt("user_rate_total"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return item;
	}

	public Boolean addSimPerson(SimPerson item) {
		return this.p.addSimPerson(item.getUser_id_1(), item.getUser_id_2(), item.getSimPerson());
	}

	public ArrayList<SimPerson> getSimPersons(String userid, byte limit) {
		ArrayList<SimPerson> items = new ArrayList<>();
		ResultSet rs = p.getSimPerson(userid, limit);
		if (rs != null) {
			try {
				while (rs.next()) {
					SimPerson item = new SimPerson();
					item.setUser_id_1(rs.getString("user_id_1"));
					item.setUser_id_2(rs.getString("user_id_2"));
					item.setSimPerson(rs.getFloat("simPerson"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return items;
	}

	public ArrayList<UserRateObject> getProductRating(String userid) {
		ArrayList<UserRateObject> items = new ArrayList<>();
		ResultSet rs = p.getProductRating(userid);
		if (rs != null) {
			try {
				while (rs.next()) {
					UserRateObject item = new UserRateObject();
					item.setUser_id(rs.getString("user_id"));
					item.setProduct_id(rs.getInt("product_id"));
					item.setUser_rate_point(rs.getInt("user_rate_point"));
					item.setUser_rate_comment(rs.getString("user_rate_comment"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	public ArrayList<UserRateObject> getProductRating2(String userid) {
		ArrayList<UserRateObject> items = new ArrayList<>();
		ResultSet rs = p.getProductRating2(userid);
		if (rs != null) {
			try {
				while (rs.next()) {
					UserRateObject item = new UserRateObject();
					item.setUser_id(rs.getString("user_id"));
					item.setProduct_id(rs.getInt("product_id"));
					item.setUser_rate_point(rs.getInt("user_rate_point"));
					item.setUser_rate_comment(rs.getString("user_rate_comment"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public ArrayList<UserRateObject> getProductRating3(String user_id1,String user_id2) {
		ArrayList<UserRateObject> items = new ArrayList<>();
		ResultSet rs = p.getProductRating3(user_id1,user_id2);
		if (rs != null) {
			try {
				while(rs.next()) {
					UserRateObject item = new UserRateObject();
					item.setUser_id(rs.getString("user_id"));
					item.setProduct_id(rs.getInt("product_id"));
					item.setUser_rate_point(rs.getInt("user_rate_point"));
					item.setUser_rate_comment(rs.getString("user_rate_comment"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}

	private float simPerson(ArrayList<SameUserRateProductObject> items, float userAVG1, float userAVG2) {
		float sim = 0f;
		float user1_rate = 0f;
		float user2_rate = 0f;
		float A = 0f;
		float C = 0f;
		float D = 0f;
		for (int i = 0; i < items.size(); i++) {
			user1_rate = items.get(i).getUser1_rate();
			user2_rate = items.get(i).getUser2_rate();
			A += (user1_rate - userAVG1) * (user2_rate - userAVG2);
			C += (user1_rate - userAVG1) * (user1_rate - userAVG1);
			D += (user2_rate - userAVG2) * (user2_rate - userAVG2);
		}
		if(C*D==0){
			return 0;
		}
		sim = (float)(A / Math.sqrt(C * D));
		return sim;
	}
	
	public ArrayList <ProductSuggestObject> CollaborationFilter(String user_id){
		ArrayList <ProductSuggestObject> productSuggest = new ArrayList<>();
		UserRateAVGObject UserRateAVG1 = getUserRateAVG(user_id);
		UserRateAVGObject userRateAVG2;
		float simPerson = 0f;
		
		ArrayList<SameUserRateProductObject> listSameProduct = new ArrayList<>();
		ArrayList<UserRateObject> listUserCompare = getProductRating2(user_id);
		
		for(UserRateObject userCompare:listUserCompare){
			String user_id2 = userCompare.getUser_id();
			userRateAVG2 = getUserRateAVG(user_id2);
			listSameProduct = getSameProduct(user_id, user_id2);
			if(!listSameProduct.isEmpty()){
				simPerson = simPerson(listSameProduct, UserRateAVG1.getUser_rate_avg(), userRateAVG2.getUser_rate_avg());
				SimPerson simObject = new SimPerson();
				simObject.setSimPerson(simPerson);
				simObject.setUser_id_1(user_id);
				simObject.setUser_id_2(user_id2);
				addSimPerson(simObject);
			}
			
		}
		//get list simperson
		
		double user_KNN = 0d;
		ArrayList<SimPerson> listSimperson = getSimPersons(user_id, (byte)10);
		for(SimPerson sim:listSimperson){
			//System.out.println("sim user 1: " + sim.getUser_id_1() + " user 2 " + sim.getUser_id_2());
			ArrayList<UserRateObject> listUser2Rate = getProductRating3(sim.getUser_id_1(), sim.getUser_id_2());
			for(UserRateObject user2Rate:listUser2Rate){
				//System.out.println("product orgigin: " + user2Rate.getProduct_id());
				userRateAVG2 = getUserRateAVG(user2Rate.getUser_id());
				if(sim.getSimPerson()==0){
					user_KNN = UserRateAVG1.getUser_rate_avg() ;
				}else{
					user_KNN = UserRateAVG1.getUser_rate_avg() + sim.getSimPerson()*(user2Rate.getUser_rate_point()-userRateAVG2.getUser_rate_avg())/Math.abs(sim.getSimPerson());
				}
				//System.out.println("KNN: " + user_KNN + "product: " + user2Rate.getProduct_id());
				if(user_KNN>3){
					productSuggest.add(new ProductSuggestObject(user2Rate.getProduct_id(), (float)user_KNN));
				}
			}
		}
		return productSuggest;
	}
	
	public float getProductRateAVG(int product_id){
		ResultSet rs = p.getProductRatingAVG(product_id);
		if(rs!=null){
			try {
				if(rs.next()){
					return rs.getFloat(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public ArrayList<UserRateObject> getProductRating(int product_id){
		ArrayList<UserRateObject> items = new ArrayList<>();
		UserRateObject item;
		ResultSet rs = p.getProductRating(product_id);
		if(rs!=null){
			try {
				while(rs.next()){
					item = new UserRateObject();
					if(rs.getString("user_name")==null){
						item.setUser_id(rs.getString("user_id"));
					}
					else{
						item.setUser_id(rs.getString("user_name"));
					}
					item.setProduct_id(rs.getInt("product_id"));
					item.setUser_rate_point(rs.getInt("user_rate_point"));
					item.setUser_rate_comment(rs.getString("user_rate_comment"));
					items.add(item);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public ArrayList<ProductObject> getProductRattingSample(){
		//Danh sach doi tuong
        ArrayList<ProductObject> items = new ArrayList<ProductObject>();//Mac dinh 10 ptu thieu thi cho them thua bo ra
        ProductObject item = null;

        ResultSet rs = this.p.getProductRatingSample();
        if(rs != null){
            try {
                while (rs.next()) {
                	item = new ProductObject();
					item.setProduct_id(rs.getInt("product_id"));
					item.setProduct_prefix(rs.getString("product_prefix"));
					item.setProduct_name(rs.getString("product_name"));
					item.setProduct_status(rs.getBoolean("product_status"));
					item.setProduct_category_id(rs.getInt("product_category_id"));
					item.setProduct_quantity(rs.getInt("product_quantity"));
					item.setProduct_origin_price(rs.getInt("product_origin_price"));
					item.setProduct_price2(rs.getDouble("product_price2"));
					item.setProduct_price3(rs.getDouble("product_price3"));
					item.setProduct_price_discount(rs.getInt("product_price_discount"));
					item.setProduct_imported_date(rs.getString("product_imported_date"));
					item.setProduct_last_modified(rs.getString("product_last_modified"));
					item.setProduct_specification(rs.getString("product_specification"));
					item.setProduct_note(rs.getString("product_note"));
					item.setProduct_warranty_time(rs.getInt("product_warranty_time"));
					item.setProduct_provider_id(rs.getInt("product_provider_id"));
					item.setProduct_image(rs.getString("product_image"));
					item.setProduct_visited(rs.getInt("product_visited"));
					item.setProduct_summary(rs.getString("product_summary"));
					item.setProduct_promotion(rs.getString("product_promotion"));
					item.setProduct_isnew(rs.getBoolean("product_isnew"));
					item.setProduct_isliquidation(rs.getBoolean("product_isliquidation"));
					item.setProduct_isselling(rs.getBoolean("product_isselling"));
                    //Them doi tuong vao danh sach
                    items.add(item);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return items;
	}
	
	
	public static void main(String args[]){
		ConnectionPool cp = new ConnectionPoolImpl();
		UserRateModel um = new UserRateModel(cp);
//		SameUserRateProductObject p1 = new SameUserRateProductObject(1, "1", "2", 4, 1);
//		SameUserRateProductObject p2 = new SameUserRateProductObject(2, "1", "2", 3, 1);
//		SameUserRateProductObject p4 = new SameUserRateProductObject(4, "1", "2", 2, 2);
//		ArrayList<SameUserRateProductObject> list = new ArrayList<>();
//		list.add(p1);
//		list.add(p2);
//		list.add(p4);
//		System.out.println(um.simPerson(list, (7/3), 3));
		
		ArrayList<ProductObject> items = um.getProductRattingSample();
		for(ProductObject item:items){
			System.out.println(item.getProduct_id());
		}
//		System.out.println();
		
		
	}
}
