package com.ads.product.category;

import com.object.*;
import java.sql.*;
import com.*;

public interface Category extends ShareControl{
	
	public boolean addCategory(CategoryObject item);
    public boolean editCategory(CategoryObject item);
    public boolean delCategory(CategoryObject item);

    public ResultSet getCategory(int id);
    public ResultSet getCategorys(CategoryObject similar, int at,byte total);
}
