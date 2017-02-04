package com.ads.basic;

import java.sql.*;
import com.*;

import com.ConnectionPool;

public class BasicImpl implements Basic {

	// Bo quan ly ket noi cua rieng basic
	private ConnectionPool cp; // thuoc tinh doc lap

	// Ket noi ma basic lam viec voi CSDL
	protected Connection con; // thuoc tinh phu thuoc ConnectionPool

	// Ten doi tuong lam viec voi basic
	private String objectName; // thuoc tinh doc lap

	public BasicImpl(ConnectionPool cp, String objectName) {
		// Xac dinh doi tuong lam viec voi basic
		this.objectName = objectName;

		// xac dinh bo quan ly ket noi cho basic-bat buoc phai co
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// Hoi xin ket noi
		try {
			this.con = this.cp.getConnection(this.objectName);

			// Huy che do tu dong thuc hien cua cau lenh khi dung
			// PreparedStatement
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}
	}

	private boolean exe(PreparedStatement pre) {
		if (pre != null) {
			// thuc hien cau lenh
			try {
				int result = pre.executeUpdate();
				// Neu k cap nhat dc gi vao database
				if (result == 0) {
					this.con.rollback();
					return false;
				} else {
					// neu xac nhan thanh cong
					this.con.commit();
					return true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				// Quay lai trang thai an toan k anh huong den database
				try {
					this.con.rollback();
				} catch (SQLException ex1) {
					ex1.printStackTrace();
				}
				return false;
			}
		}
		return false;

	}

	// Ba phuong thuc them sua xoa chung nhau 1 cau lenh thuc thi nhung phai
	// tach ra de sau kiem tra trong he thong
	/**
	 * add
	 *
	 * @param pre
	 *            PreparedStatement
	 * @return boolean
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public boolean add(PreparedStatement pre) {
		return this.exe(pre);
	}

	/**
	 * del
	 *
	 * @param pre
	 *            PreparedStatement
	 * @return boolean
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public boolean del(PreparedStatement pre) {
		return this.exe(pre);
	}

	/**
	 * edit
	 *
	 * @param pre
	 *            PreparedStatement
	 * @return boolean
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public boolean edit(PreparedStatement pre) {
		return this.exe(pre);
	}

	/**
	 * get
	 *
	 * @param sql
	 *            String
	 * @param value
	 *            int
	 * @return ResultSet
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public ResultSet get(String sql, int value) {

		// Bien dich cau lenh
		try {
			PreparedStatement preCet = this.con.prepareStatement(sql);
			if (value > 0) {
				preCet.setInt(1, value);
			}
			return preCet.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * get
	 *
	 * @param sql
	 *            String
	 * @param name
	 *            String
	 * @param pass
	 *            String
	 * @return ResultSet
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public ResultSet get(String sql, String name, String pass) {
		// Bien dich cau lenh
		try {
			PreparedStatement preCet = this.con.prepareStatement(sql);
			preCet.setString(1, name);
			preCet.setString(2, pass);
			return preCet.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * getConnectionPool
	 *
	 * @return ConnectionPool
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public ConnectionPool getConnectionPool() {
		return this.cp;
	}

	/**
	 * gets
	 *
	 * @param sqls
	 *            String[]
	 * @return ResultSet[]
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public ResultSet[] gets(String[] sqls) {
		ResultSet[] tmp = new ResultSet[sqls.length];
		for (int i = 0; i < sqls.length; i++) {
			tmp[i] = this.get(sqls[i], 0);
		}
		return tmp;
	}

	/**
	 * gets
	 *
	 * @param sql
	 *            String
	 * @return ResultSet
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public ResultSet gets(String sql) {
		return get(sql, 0);
	}

	/**
	 * releaseConnection
	 *
	 * @todo Implement this jsoft.ads.basic.Basic method
	 */
	public void releaseConnection() {
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
