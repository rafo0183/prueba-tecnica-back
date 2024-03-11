package com.pruebatecnica.model.misc;

public class ProductProperty {
	private String description;
	private ProductPropertyComents[] coments;
	private String[] images;
	private String brand;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductPropertyComents[] getComents() {
		return coments;
	}
	public void setComents(ProductPropertyComents[] coments) {
		this.coments = coments;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
