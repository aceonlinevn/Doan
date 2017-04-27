package com.gui.product.category;

import com.object.*;
import java.sql.*;
import com.*;

public interface Category extends ShareControl{

    public ResultSet getCategory(int id);
    public ResultSet getCategorys(CategoryObject similar, int at,byte total);
}
