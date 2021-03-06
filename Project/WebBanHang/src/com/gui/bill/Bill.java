package com.gui.bill;

import com.*;
import com.object.*;
import java.sql.*;


public interface Bill extends ShareControl {

	public boolean addBill(BillObject item);
    public boolean editBill(BillObject item);
    public boolean delBill(BillObject item);
    public boolean cancelBill(BillObject item);
    
    public ResultSet getBill(int id);
    public ResultSet getBillForCus(String cusid);
    public ResultSet getBills(BillObject similar, int at,byte total);
}
