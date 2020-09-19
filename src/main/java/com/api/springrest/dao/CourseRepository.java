package com.api.springrest.dao;

import org.springframework.data.repository.CrudRepository;


import com.api.springrest.entities.Course;

public interface CourseRepository extends CrudRepository<Course,Integer>{

	public Course findById(int id);
	
	
}
