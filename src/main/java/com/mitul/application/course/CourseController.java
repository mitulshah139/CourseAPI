package com.mitul.application.course;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitul.application.topics.Topic;
import com.mitul.application.topics.TopicService;

@RestController
public class CourseController {
	@Autowired
	private CourseService Courseervice;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {
		return Courseervice.getAllCourse(id);
	}
	
	@RequestMapping("/topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return Courseervice.getCourse(id);
	}
	
	@PostMapping("/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		Courseervice.addCourse(course);
	}
	
		
	@PutMapping("/topics/{topicid}/courses/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id) {
		course.setTopic(new Topic(topicid,"",""));
		Courseervice.updateCourse(course);
	}
	
	@DeleteMapping("/topics/{topicid}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		Courseervice.deleteCourse(id);
	}
}
