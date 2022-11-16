package com.masai;

import java.util.List;

import org.springframework.stereotype.Repository;


public interface ProductRepo {
	
	public boolean insertProductDetails(Product product);
	
	public List<Product> getAllProductDetails();

	public Product findProduct(int productId);
	
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice);

}
