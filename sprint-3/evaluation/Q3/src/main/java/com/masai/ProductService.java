package com.masai;

import java.util.List;

public interface ProductService {
	
	public boolean addProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(int productId)throws ProductException;
	
	public List<Product> getProductsBetweenPrice(int fromPrice, int
			toPrice)throws ProductException;

	

}
