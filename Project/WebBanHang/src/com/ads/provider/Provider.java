package com.ads.provider;

import java.sql.ResultSet;

import com.ShareControl;
import com.object.ProviderObject;

public interface Provider extends ShareControl {
	public boolean addProvider(ProviderObject item);
    public boolean editProvider(ProviderObject item);
    public boolean delProvider(ProviderObject item);

    public ResultSet getProvider(int id);
    public ResultSet getProviders(ProviderObject similar, int at,byte total);
}
