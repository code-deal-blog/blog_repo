package org.onlineshoppingportal.model;

import org.onlineshoppingportal.entity.Product;

public class ProductInfo {

	 private String code;
	    private String name;
	    private double price;
	    private int quantity;
	 
	    private boolean newProduct=false;
	 
	   /* // Upload file.
	    private CommonsMultipartFile fileData;*/
	 
	    public ProductInfo() {
	    }
	 
	    public ProductInfo(Product product) {
	        this.code = product.getCode();
	        this.name = product.getName();
	        this.price = product.getPrice();
	        this.quantity = product.getQuantity();
	    }
	 

	    public ProductInfo(String code, String name, double price,int quantity) {
	        this.code = code;
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }
	 
	    public String getCode() {
	        return code;
	    }
	 
	    public void setCode(String code) {
	        this.code = code;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(double price) {
	        this.price = price;
	    }
	 
	   /* public CommonsMultipartFile getFileData() {
	        return fileData;
	    }
	 
	    public void setFileData(CommonsMultipartFile fileData) {
	        this.fileData = fileData;
	    }*/
	 
	    public boolean isNewProduct() {
	        return newProduct;
	    }
	 
	    public void setNewProduct(boolean newProduct) {
	        this.newProduct = newProduct;
	    }

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "ProductInfo [code=" + code + ", name=" + name + ", price=" + price + ", newProduct=" + newProduct
					+"quantity="+quantity+ "]";
		}
	    
	    
}
