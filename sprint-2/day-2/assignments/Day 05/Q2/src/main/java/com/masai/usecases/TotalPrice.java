package com.masai.usecases;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.masai.EMUtil.EMUtil;

public class TotalPrice {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        String jpql = "select sum(price) from Product";
        
        TypedQuery<Long> q = em.createQuery(jpql,Long.class);
        
        long totalPrice = q.getSingleResult();
        
        System.out.println("Total price: "+totalPrice);
    }

}