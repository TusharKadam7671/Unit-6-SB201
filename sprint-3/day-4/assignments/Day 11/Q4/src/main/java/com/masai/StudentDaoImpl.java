package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.masai.Utility.EMUtil;




@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Override
	public String insertStudentDetails(Student student) {

//using hibernate persist student object to the database...

		EntityManager em =  EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(student);
		
		em.getTransaction().commit();
		
		em.close();
		
		return "student object registered successfully";
		
	}

	@Override
	public List<Student> getAllStudentDetails() {


		EntityManager em =  EMUtil.provideEntityManager();
		
		Query q = em.createQuery("from Student");
		
		List<Student> students =  q.getResultList();
		
		em.close();
		
		return students;
	}

}
