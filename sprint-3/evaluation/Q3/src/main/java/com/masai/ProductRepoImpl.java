package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.masai.utility.EMUtil;


@Repository
public class ProductRepoImpl implements ProductRepo{

	@Override
	public boolean insertProductDetails(Product product) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		
		return true;
	}

	@Override
	public List<Product> getAllProductDetails() {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		List<Product> products=null;
		
		Query q = em.createQuery("from Product");
		
		products = q.getResultList();
		
		
		return products;
	}

	@Override
	public Product findProduct(int productId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Product p = null;
		
		p=em.find(Product.class, p);
		
		return p;
	}

	@Override
	public List<Product> getProductInPriceRange(int fromPrice, int toPrice) {
		// TODO Auto-generated method stub
EntityManager em = EMUtil.provideEntityManager();
		
		List<Product> products=null;
		
		Query q = em.createQuery("from Product where price between fromPrice and toPrice");
		
		products = q.getResultList();
		
		
		return products;
	}

}
