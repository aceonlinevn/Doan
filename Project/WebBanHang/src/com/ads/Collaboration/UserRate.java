package com.ads.Collaboration;

import com.*;
import com.object.*;
import java.sql.*;

public interface UserRate extends ShareControl {

	public ResultSet getSameProduct(String userid1, String userid2);

	public ResultSet getUserRateAVG(String userid);

	public boolean addUserRate(UserRateObject item);

	public boolean addSimPerson(String userid1, String userid2, float simPerson);

	public ResultSet getSimPerson(String userid, byte limit);

	public ResultSet getProductRating(String userid);

	public ResultSet getProductRating2(String uerid);

	public ResultSet getProductRating3(String user_id1, String user_id2);
	
	public ResultSet getProductRating(int product_id);
	
	public ResultSet getProductRatingAVG(int product_id);
	
	
}
