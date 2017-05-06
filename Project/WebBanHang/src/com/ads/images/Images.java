package com.ads.images;

import com.object.*;
import java.sql.*;
import com.*;

public interface Images extends ShareControl{
	
	public boolean addImages(ImagesObject item);
    public boolean editImages(ImagesObject item);
    public boolean delImages(ImagesObject item);

    public ResultSet getImages(int id);
    public ResultSet getImagess(ImagesObject similar, int at,byte total);
}
