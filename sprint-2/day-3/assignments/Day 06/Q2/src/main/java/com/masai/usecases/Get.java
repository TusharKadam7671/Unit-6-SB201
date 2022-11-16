package com.masai.usecases;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.model.Address;
import com.masai.model.Customer;


public class Get {
	
	public static void main(String[] args) {
		
		EntityManager em = EMUtil.provideEntityManager();
		
		
		String jpql = "from Customer where cid=2";
		Query q = em.createQuery(jpql);
		
		List<Customer> custList = q.getResultList();
		
		for(Customer cust : custList)
		{
			List<Address> addrs = cust.getAddresses();
			
			for(Address adr : addrs)
			{
				System.out.println(adr);
			}
		}
		
	}

}

