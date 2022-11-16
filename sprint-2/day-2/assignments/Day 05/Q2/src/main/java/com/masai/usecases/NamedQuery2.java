package com.masai.usecases;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.masai.EMUtil.EMUtil;

public class NamedQuery2 {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        TypedQuery<Integer> q = em.createNamedQuery("prod_price",Integer.class);
        
        q.setParameter("id", 6);
        
        Integer n = q.getSingleResult();
        
        System.out.println("Product price is: "+n);
        
        
    }

}