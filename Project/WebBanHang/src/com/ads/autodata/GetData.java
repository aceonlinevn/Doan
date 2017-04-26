package com.ads.autodata;
import com.object.*;
import java.util.*;

public interface GetData {
	
	public ProductObject getData(String url);
	public ArrayList<WebObject> getDatas(String url);
}
