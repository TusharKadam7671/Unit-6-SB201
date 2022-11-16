package com.masai.usecases;

import javax.persistence.EntityManager;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Product;

public class Insert {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        Product p1 = new Product("Product1", 7894, 4);
        Product p2 = new Product("Product2", 145, 40);
        Product p3 = new Product("Product3", 3652, 2);
        Product p4 = new Product("Product4", 6125, 11);
        Product p5 = new Product("Product5", 334, 23);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.persist(p5);
        em.getTransaction().commit();
        
        em.close();
        
    }

}

