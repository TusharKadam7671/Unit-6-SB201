package com.masai;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class Course {
	
	private int courseId;
	private String courseName;
	private int	duration;
	private int fee;
	
	
	public Course(int courseId, String courseName, int duration, int fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}

	
	

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, duration, fee);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName) && duration == other.duration
				&& fee == other.fee;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", fee=" + fee
				+ "]";
	}
	
	
	
	

}
