package com.api.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.springrest.dao.CourseRepository;
import com.api.springrest.entities.Course;


@Component
public class CourseService{

@Autowired	
private CourseRepository courseRepository;
	
//	private static List<Course> list=new ArrayList<>();
//	
//	static {
//		
//		
//		list.add(new Course(12,"Java Complete","XYZ"));
//		
//		list.add(new Course(13,"python","ABC"));
//		
//		
//		list.add(new Course(14,"Java not  Complete","XYsZ"));
//		
//		list.add(new Course(15,"pythons","AaBC"));
//		
//		
//		
//	}



	public List<Course> getAllCourses() {
		
		List<Course> list= (List<Course>) this.courseRepository.findAll();
		return list;
		
	}
	
	
	public Course getCourseById(int id) {
		Course course=null;
		try {
		//course=list.stream().filter(e->e.getId()==id).findFirst().get();
		
				course=this.courseRepository.findById(id);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}


//	public static void setList(List<Course> list) {
//		CourseService.list = list;
//	}
//	
	
	
	public Course addCourse(Course b) {
		
		Course result=courseRepository.save(b);
		
		return result;
		
	}
	
	public void deleteCourse(int bid) {
		// TODO Auto-generated method stub

         //Course course=null;
		
		//course=list.stream().filter(e->e.getId()==bid).findFirst().get();
		
         courseRepository.deleteById(bid);
		 //list.remove(course);
		 
		 
}

	
	public void updateCourse(Course course,int courseId)
	{
		
//		list=list.stream().map(b->{
//			
//			if(b.getId()==courseId) {
//				b.setTitle(course.getTitle());
//				b.setAuthor(course.getAuthor());
//				
//			}
//			
//			return b;
//		}).collect(Collectors.toList());
//		
//		
		course.setId(courseId);
		courseRepository.save(course);
		
		
	}
	
	
	
	
	
}
