package com.ads.Collaboration;

import com.*;
import com.object.*;
import java.sql.*;


public interface UserRate extends ShareControl {

	public boolean addUserRate(UserRateObject item);

    public ResultSet getUserRate(int id);
    public ResultSet getUserRates(UserRateObject similar, int at,byte total);
}
