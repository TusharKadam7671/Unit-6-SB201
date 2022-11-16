package com.masai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.EMUtil.EMUtil;
import com.masai.exception.CourseException;


import com.masai.exception.TeacherException;
import com.masai.model.Course;

import com.masai.model.Student;
import com.masai.model.Teacher;

public class TrainingDaoImpl implements TrainingDao{

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(course);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("done");
		
	}

	@Override
	public void registerStudent(Student student, int courseId) throws CourseException {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Course c = em.find(Course.class, courseId);
		
		student.getCourses().add(c);
		
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("done");
		
	}

	@Override
	public void registerTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		em.getTransaction().begin();
		em.persist(teacher);
		em.getTransaction().commit();
		
		em.close();
		System.out.println("done");
		
	}

	@Override
	public void assignTeacherWithCourse(int teacherId, int courseId) throws TeacherException, CourseException {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		Teacher emp = em.find(Teacher.class, teacherId);
		
		Course dept = em.find(Course.class, courseId);
		
		if(emp != null && dept != null)
		{
			emp.getCourses().add(dept);
			dept.setT(emp);
			
			em.getTransaction().begin();
			em.persist(emp);
			em.getTransaction().commit();
			em.close();
			System.out.println("Registered");
		}
		
		else if(emp==null)
		{
			throw new TeacherException("Teacher not found");
		}
		
		else if(dept==null)
		{
			throw new CourseException("course not found");
		}
		
	}

	@Override
	public List<Student> getAlltheStudentsByCourseName(String courseName) throws CourseException {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		String jpql = "select students from Course where courseName=:nm";
		Query q = em.createQuery(jpql);
		q.setParameter("nm", courseName);
		
		List<Student> list = q.getResultList();
		
		
		
		return list;
	}

}
