package com.api.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.springrest.entities.Course;
import com.api.springrest.services.CourseService;


@RestController
@CrossOrigin
public class MyController {

	@GetMapping("/home")
	public String home() {
		
		return "Welcome to course application";
		
	}
	

	@Autowired
	private CourseService courseService;
	
	
	
	//Get all Courses
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses() {
		
		
		List<Course> list= this.courseService.getAllCourses();
		
		if(list.size()<=0) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		
		
	
	}
	
	//Get single course

	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable("id") int id)
	{
		 
		Course course=courseService.getCourseById(id);
		if(course==null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.of(Optional.of(course));
	}
	
	
	
	//add new course
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course b=null;
		
		try {
			b=this.courseService.addCourse(course);
			System.out.println(course);
			return ResponseEntity.of(Optional.of(b));
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
			
		}
		
	
	}
	
	//delete Course
	
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable("courseId") int courseId) {
		
		try {
			
			this.courseService.deleteCourse(courseId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
		
		
		
		
	}
	
	//update
	
	@PutMapping("/courses/{courseId}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course,@PathVariable("courseId") int courseId) {
	
		try {
			this.courseService.updateCourse(course, courseId);
	return ResponseEntity.ok().body(course);
			
		} catch (Exception e) {
			
			// TODO: handle exception
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	
	}
	
}
