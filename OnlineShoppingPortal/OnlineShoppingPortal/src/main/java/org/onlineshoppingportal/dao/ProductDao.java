package org.onlineshoppingportal.dao;

import java.util.List;

import org.onlineshoppingportal.entity.Product;
import org.onlineshoppingportal.model.PaginationResult;
import org.onlineshoppingportal.model.ProductInfo;

public interface ProductDao {

	public Product findProduct(String code);
    public List<Product> getAllProducts();
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
}
