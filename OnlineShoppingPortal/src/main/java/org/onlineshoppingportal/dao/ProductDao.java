package org.onlineshoppingportal.dao;

import java.util.List;

import org.onlineshoppingportal.entity.Product;

public interface ProductDao {

	public Product findProduct(String code);
    public List<Product> getAllProducts();
   
}
