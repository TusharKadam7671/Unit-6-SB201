package com.masai.usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Product;

public class NamedQuery1 {
    
    public static void main(String[] args) {
        
        EntityManager em = EMUtil.provideEntityManager();
        
        Query q = em.createNamedQuery("prod_name_qty");
        
        List<Object[]> objlist = q.getResultList();
        
        for(Object[] or : objlist)
        {
            System.out.println("Product name: "+or[0]+" Product quantity: "+or[1]);
        }
        
        
    }

}