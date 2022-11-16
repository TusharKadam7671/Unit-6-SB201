package com.masai.Q5;

public class Collage {
	
	private Person p;
	
	//constructor injection
//	public Collage(Person p)
//	{
//		this.p = p;
//	}
	
	//setter injection
	public void setP(Person p) {
		this.p = p;
	}
	
	
	
	public void doJob(){
		
		
		System.out.println("Job is started");
		
		
		//here it needs the service of its Dependencies
		p.doYourJob();
		
		
		
		}


	

}
