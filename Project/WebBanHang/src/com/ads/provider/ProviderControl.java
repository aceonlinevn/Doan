package com.ads.provider;

import com.*;
import com.ads.product.category.CategoryLibrary;
import com.object.*;
import java.util.*;

public class ProviderControl {
	private ProviderModel pm;

	public ProviderControl(ConnectionPool cp) {
		this.pm = new ProviderModel(cp);
	}

	protected void finalize() throws Throwable {
		this.pm = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.pm.getConnectionPool();
	}

	public void releaseConnection() {
		this.pm.releaseConnection();
	}
	 //**********************************************/
    public boolean addProvider(ProviderObject item){
        return this.pm.addProvider(item);
    }
    public boolean editProvider(ProviderObject item){
        return this.pm.editProvider(item);
    }
    public boolean delProvider(ProviderObject item){
        return this.pm.delProvider(item);
    }
	// ************************************************/

	public ProviderObject getProviderObject(int id) {
		return this.pm.getProviderObject(id);
	}

	// ************************************************/
	public String viewProviders(ProviderObject similar, int page, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.pm.getProviderObjects(similar, page, total);

		return ProviderLibrary.viewProviders(items);
	}
	public String slcProvider(ProviderObject similar) {
		// Lay danh sach doi tuong
		ArrayList items = this.pm.getProviderObjects(similar, 0,(byte) 0);

		return ProviderLibrary.slcProvider(similar,items);
	}
}
