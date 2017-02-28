package com.object;

public class ImagesObject {
	private int images_id;
	private String images_src;
	private String images_name;
	private String images_note;
	private int images_product_id;
	private boolean images_is_primary;
	public ImagesObject(int images_id, String images_src, String images_name, String images_note,
			int images_product_id, boolean images_is_primary) {
		super();
		this.images_id = images_id;
		this.images_src = images_src;
		this.images_name = images_name;
		this.images_note = images_note;
		this.images_product_id = images_product_id;
		this.images_is_primary = images_is_primary;
	}
	
	public boolean isImages_is_primary() {
		return images_is_primary;
	}


	public void setImages_is_primary(boolean images_is_primary) {
		this.images_is_primary = images_is_primary;
	}


	public ImagesObject() {
		super();
	}
	public int getImages_id() {
		return images_id;
	}
	public void setImages_id(int images_id) {
		this.images_id = images_id;
	}
	public String getImages_src() {
		return images_src;
	}
	public void setImages_src(String images_src) {
		this.images_src = images_src;
	}
	public String getImages_name() {
		return images_name;
	}
	public void setImages_name(String images_name) {
		this.images_name = images_name;
	}
	public String getImages_note() {
		return images_note;
	}
	public void setImages_note(String images_note) {
		this.images_note = images_note;
	}
	public int getImages_product_id() {
		return images_product_id;
	}
	public void setImages_product_id(int images_product_id) {
		this.images_product_id = images_product_id;
	}
	
}
