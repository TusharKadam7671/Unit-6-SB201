package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo prepo = new ProductRepoImpl();

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return prepo.insertProductDetails(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return prepo.getAllProductDetails();
	}

	@Override
	public Product getProductById(int productId) throws ProductException {
		// TODO Auto-generated method stub
		return prepo.findProduct(productId);
	}

	@Override
	public List<Product> getProductsBetweenPrice(int fromPrice, int toPrice) throws ProductException {
		// TODO Auto-generated method stub
		return prepo.getProductInPriceRange(fromPrice, toPrice);
	}

}
