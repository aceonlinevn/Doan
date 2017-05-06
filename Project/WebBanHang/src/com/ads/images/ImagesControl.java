package com.ads.images;

import com.*;
import com.ads.product.ProductLibrary;
import com.object.*;
import java.util.*;

public class ImagesControl {
	private ImagesModel im;

	public ImagesControl(ConnectionPool cp) {
		this.im = new ImagesModel(cp);
	}

	protected void finalize() throws Throwable {
		this.im = null;
	}

	public ConnectionPool getConnectionPool() {
		return this.im.getConnectionPool();
	}

	public void releaseConnection() {
		this.im.releaseConnection();
	}
	 //**********************************************/
    public boolean addImages(ImagesObject item){
        return this.im.addImages(item);
    }
    public boolean editImages(ImagesObject item){
        return this.im.editImages(item);
    }
    public boolean delImages(ImagesObject item){
        return this.im.delImages(item);
    }
	// ************************************************/

	public ImagesObject getImagesObject(int id) {
		return this.im.getImagesObject(id);
	}
	public String viewImages(ImagesObject similar, int page, byte total) {
		// Lay danh sach doi tuong
		ArrayList items = this.im.getImagesObjects(similar, page, total);

		return ImagesLibrary.viewImages(items);
	}
	// ************************************************/
}
