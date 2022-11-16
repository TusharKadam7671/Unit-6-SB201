package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Product;

public class GetProductQty5 {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        String jpql = "from Product where quantity < 5";
        
        Query q = em.createQuery(jpql);
        
        
        List<Product> list = q.getResultList();
        
        System.out.println(list);
    }

}