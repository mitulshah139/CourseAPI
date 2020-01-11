package com.mitul.application.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepo;
//	private List<Topic> listofTopics = new ArrayList(
//			Arrays.asList(new Topic("topic1", "Topic Name", "Description OF TOpic"),
//					new Topic("topic2", "Topic Name 1", "Description OF TOpic 2"),
//					new Topic("topic3", "Topic Name 2", "Description OF TOpic 3")));

	public List<Topic> getAllTopics() {
		List<Topic> topiclist=new ArrayList<>();
		topicRepo.findAll()
				.forEach(topiclist::add); 
		return topiclist;		//listofTopics;
	}

	public Topic getTopic(String id) {
//		return listofTopics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepo.findById(id).orElse(null);
	}

	public void addTopics(Topic topic) {
		// TODO Auto-generated method stub
//		listofTopics.add(topic);
		topicRepo.save(topic);
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
//		listofTopics.removeIf(t->t.getId().equals(id));
		topicRepo.deleteById(id);
	}

	public void updateTopic(String id,Topic topic) {
		// TODO Auto-generated method stub
//		for(int i=0;i<=listofTopics.size();i++) {
//			Topic t=listofTopics.get(i);
//			if(t.getId().equals(id)) {
//				listofTopics.set(i, topic);
//				return;
//			}
//		}
		topicRepo.save(topic);
	}
}
