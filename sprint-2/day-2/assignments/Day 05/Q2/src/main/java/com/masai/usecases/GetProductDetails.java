package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Product;

public class GetProductDetails {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        String jpql = "from Product where productId=:id";
        
        Query q = em.createQuery(jpql);
        
        q.setParameter("id", 6);
        
        List<Product> list = q.getResultList();
        
        System.out.println(list);
    }

}