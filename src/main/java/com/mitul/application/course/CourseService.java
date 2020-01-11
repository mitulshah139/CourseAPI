package com.mitul.application.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitul.application.topics.Topic;

@Service
public class CourseService {

	@Autowired
	CourseRepository CoursRepo;
	public List<Course> getAllCourse(String id) {
		List<Course> list=new ArrayList<>();
		CoursRepo.findByTopicId(id)
				.forEach(list::add); 
		return list;		
	}

	public Course getCourse(String id) {
		return CoursRepo.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		
		CoursRepo.save(course);
	}

	public void deleteCourse(String id) {
		CoursRepo.deleteById(id);
	}

	public void updateCourse(Course topic) {
		CoursRepo.save(topic);
	}
	
}
