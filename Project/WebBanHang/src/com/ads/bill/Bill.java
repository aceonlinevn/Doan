package com.ads.bill;

import com.*;
import com.object.*;
import java.sql.*;


public interface Bill extends ShareControl {

	public boolean addBill(BillObject item);
    public boolean editBill(BillObject item);
    public boolean delBill(BillObject item);

    public ResultSet getBill(int id);
    public ResultSet getBills(BillObject similar, int at,byte total);
}
